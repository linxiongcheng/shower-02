package org.yuan.boot.shower.wx.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yuan.boot.shower.commons.utils.Results;
import org.yuan.boot.shower.db.pojo.OrderInfo;
import org.yuan.boot.shower.db.pojo.OrderItem;
import org.yuan.boot.shower.wx.converter.WxOrderInfoConvertService;
import org.yuan.boot.shower.wx.pojo.WxOrderInfo;
import org.yuan.boot.shower.wx.service.OrderCodeService;
import org.yuan.boot.shower.wx.service.WxCustomerService;
import org.yuan.boot.shower.wx.service.WxOrderService;
import org.yuan.boot.webmvc.pojo.Result;

import java.util.List;

/**
 * @program: shower-01
 * @description:
 * @author: yuane
 * @create: 2020-01-31 09:49
 */
@Service
@AllArgsConstructor
public class WxOrderServiceImpl implements WxOrderService {
    private WxOrderInfoConvertService wxOrderInfoConvertService;
    private OrderCodeService orderCodeService;
    private WxCustomerService wxCustomerService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result addOrder(WxOrderInfo wxOrderInfo) {
        OrderInfo orderInfo = wxOrderInfoConvertService.addOrder(wxOrderInfo);
        List<OrderItem> orderItems = wxOrderInfoConvertService.addBaseOrderItems(wxOrderInfo, orderInfo);

        return Results.ok();
    }
}