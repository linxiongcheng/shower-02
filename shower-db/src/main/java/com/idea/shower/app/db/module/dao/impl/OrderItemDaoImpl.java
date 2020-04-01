package com.idea.shower.app.db.module.dao.impl;

import com.idea.shower.app.db.commons.dao.impl.BaseDaoImpl;
import com.idea.shower.app.db.module.constants.PriceInfoConstants;
import com.idea.shower.app.db.module.dao.OrderItemDao;
import com.idea.shower.app.db.module.mapper.OrderItemMapper;
import com.idea.shower.app.db.module.pojo.OrderItem;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @program: my-shower-01
 * @description:
 * @author: yuane
 * @create: 2020-02-14 19:56
 */
@Component
@AllArgsConstructor
public class OrderItemDaoImpl extends BaseDaoImpl<OrderItem, OrderItemMapper> implements OrderItemDao {
    @Override
    public void save(OrderItem orderItem) {
        baseMapper().insertSelective(orderItem);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void batchSave(List<OrderItem> orderItems) {
        orderItems.forEach(baseMapper()::insertSelective);
    }

    @Override
    public Optional<OrderItem> getRentalItemByOrderId(Long orderId) {
        return Optional.ofNullable(baseMapper().selectOneByOrderIdAndGoodsType(orderId, PriceInfoConstants.PriceType.STARTING_PRICE));
    }

    @Override
    public List<OrderItem> selectListByOrderNo(String orderId) {
        return baseMapper().selectByOrderNo(orderId);
    }

    @Override
    public OrderItem getStartingItemByOrderId(Long id) {
        return baseMapper().selectOneByOrderIdAndPriceType(id, PriceInfoConstants.PriceType.STARTING_PRICE);
    }
}