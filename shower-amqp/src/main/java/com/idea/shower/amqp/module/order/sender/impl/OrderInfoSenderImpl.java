package com.idea.shower.amqp.module.order.sender.impl;

import com.idea.shower.amqp.commons.sender.impl.BaseSenderImpl;
import com.idea.shower.amqp.configuration.QueueConstants;
import com.idea.shower.amqp.module.order.pojo.OrderInfo;
import com.idea.shower.amqp.module.order.sender.OrderInfoSender;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: shower-01
 * @description:
 * @author: yuane
 * @create: 2020-04-01 20:57
 */
@Component
@Transactional
public class OrderInfoSenderImpl extends BaseSenderImpl<OrderInfo> implements OrderInfoSender {

    @Override
    public Object getWaterUse(OrderInfo orderInfo) {
        return sendAndRec(QueueConstants.WATER_USE_QUEUE, orderInfo);
    }

}