package com.idea.shower.shower.db.dao.impl;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.idea.shower.shower.commons.dao.impl.BaseDaoImpl;
import com.idea.shower.shower.db.dao.OrderItemDao;
import com.idea.shower.shower.db.mapper.OrderItemMapper;
import com.idea.shower.shower.db.pojo.OrderItem;

import java.util.List;

/**
 * @program: shower-01
 * @description:
 * @author: yuane
 * @create: 2020-01-23 13:42
 */
@Component
@AllArgsConstructor
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
@Log4j2
public class OrderItemDaoImpl extends BaseDaoImpl<OrderItem, OrderItemMapper> implements OrderItemDao {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(OrderItem orderItem) {
        baseMapper().insertSelective(orderItem);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void batchSave(List<OrderItem> orderItems) {
        orderItems.forEach(baseMapper()::insertSelective);
    }
}