package com.idea.shower.app.db.module.dao;


import com.idea.shower.app.db.commons.dao.BaseDao;
import com.idea.shower.app.db.module.pojo.DeviceOrder;

import java.util.Optional;

/**
 * @program: my-shower-01
 * @description:
 * @author: yuane
 * @create: 2020-02-14 22:57
 */
public interface DeviceOrderDao extends BaseDao<DeviceOrder> {
    void save(DeviceOrder deviceOrder);

    void updateStatusDeviceOrderPaid(String orderId);

    void updateStatusDeviceOrderEndUse(Long orderId);

    void updateStatusUsingByOrderInfoId(Long orderId);

    Optional<DeviceOrder> getByOrderNo(String orderNo);

    void updateStatusUsingById(Long id);

    Optional<DeviceOrder> getByOrderId(Long orderId);
}
