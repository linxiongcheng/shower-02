package org.yuan.boot.shower.wx.pojo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: shower-01
 * @description:
 * @author: yuane
 * @create: 2020-01-31 09:40
 */
@Data
public class WxOrderInfo {
    private Long orderId;
    private String orderNo;
    private Long deviceId;
    private Long customerId;
    private String customerOpenId;
    private String customerUnionId;
    private String rangeCode;
    private BigDecimal waterCost;
}