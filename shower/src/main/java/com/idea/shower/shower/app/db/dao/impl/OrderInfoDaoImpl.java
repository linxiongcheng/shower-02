package com.idea.shower.shower.app.db.dao.impl;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.idea.shower.db.mybaits.pojo.PageResult;
import com.idea.shower.shower.app.commons.dao.impl.BaseDaoImpl;
import com.idea.shower.shower.app.db.dao.OrderInfoDao;
import com.idea.shower.shower.app.db.mapper.OrderInfoMapper;
import com.idea.shower.shower.app.db.pojo.OrderInfo;
import com.idea.shower.shower.app.db.pojo.OrderInfoQueryBase;

import java.util.Optional;

/**
 * @program: shower-01
 * @description:
 * @author: yuane
 * @create: 2020-01-23 13:34
 */
@Component
@AllArgsConstructor
@Log4j2
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class OrderInfoDaoImpl extends BaseDaoImpl<OrderInfo, OrderInfoMapper> implements OrderInfoDao {
    @Override
    public PageResult<OrderInfo> selectPage(OrderInfoQueryBase condition) {
        return pageResult(condition,baseMapper()::selectByCondition);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(OrderInfo orderInfo) {
        baseMapper().insertSelective(orderInfo);
    }

    @Override
    public Optional<OrderInfo> selectById(Long orderId) {
        return Optional.ofNullable(baseMapper().selectByPrimaryKey(orderId));
    }

}