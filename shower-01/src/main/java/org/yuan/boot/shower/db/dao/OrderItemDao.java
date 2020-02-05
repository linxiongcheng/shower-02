package org.yuan.boot.shower.db.dao;

import org.yuan.boot.shower.commons.dao.BaseDao;
import org.yuan.boot.shower.db.pojo.OrderItem;

/**
 * @program: shower-01
 * @description:
 * @author: yuane
 * @create: 2020-01-23 13:42
 */
public interface OrderItemDao extends BaseDao<OrderItem> {
    void save(OrderItem orderItem);
}
