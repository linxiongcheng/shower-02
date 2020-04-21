var api = require("../../../config/api.js");
var util = require('../../../utils/util.js');
var user = require('../../../utils/user.js');

Page({
  data: {
    orderList: [],
    status: 0,
    page: 1,
    limit: 10,
    totalPages: 1
  },
  onLoad: function(options) {
    // 页面初始化 options为页面跳转所带来的参数
    let that = this
    try {
      var tab = wx.getStorageSync('tab');

      this.setData({
        status: tab
      });
    } catch (e) {}

  },
  getOrderList() {
    let userInfo = wx.getStorageSync('userInfo');
    let that = this;
    util.request(api.OrderList, {
      openId: userInfo.openId,
      status: that.data.status,
      page: that.data.page,
      limit: that.data.limit
    },"POST").then(function(res) {
      console.log(res.data);
      that.setData({
        orderList: that.data.orderList.concat(res.data.list),
        totalPages: res.data.total
      });
    });
  },
  onReachBottom() {
    if (this.data.totalPages > this.data.page) {
      this.setData({
        page: this.data.page + 1
      });
      this.getOrderList();
    } else {
      wx.showToast({
        title: '没有更多订单了',
        icon: 'none',
        duration: 2000
      });
      return false;
    }
  },
  switchTab: function(event) {
    let status = event.currentTarget.dataset.index;
    this.setData({
      orderList: [],
      status: status,
      page: 1,
      limit: 10,
      totalPages: 1
    });
    this.getOrderList();
  },
  onReady: function() {
    // 页面渲染完成
  },
  onShow: function() {
    // 页面显示
    this.setData({
      orderList: []
    })
    this.getOrderList();
  },
  onHide: function() {
    // 页面隐藏
  },
  onUnload: function() {
    // 页面关闭
  },
  endOrder(event) {
    const orderNo = event.currentTarget.dataset.orderno;
    console.log(orderNo)
    util.request(api.EndOrder, {
      orderNo: orderNo
    }, "POST").then(function (res) {
      console.log(res.data);
    });
    
  },
  lookDetail(event) {
    var id = event.currentTarget.dataset.id;
    wx.navigateTo({
      url: '/pages/ucenter/orderDetail/orderDetail?id=' + id,
    });
  },
  goKabaw(){
    wx.navigateTo({
      url: '/pages/ucenter/kabaw/kabaw',
    })
  }
})