package com.idea.shower.app.db.module.dao.impl;

import com.idea.shower.app.db.commons.dao.impl.BaseDaoImpl;
import com.idea.shower.app.db.module.constants.goods.GoodsType;
import com.idea.shower.app.db.module.dao.GoodsInfoDao;
import com.idea.shower.app.db.module.mapper.GoodsInfoMapper;
import com.idea.shower.app.db.module.pojo.PriceInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @program: my-shower-01
 * @description:
 * @author: yuane
 * @create: 2020-02-14 20:18
 */
@Component
@AllArgsConstructor
public class GoodsInfoDaoImpl extends BaseDaoImpl<PriceInfo, GoodsInfoMapper> implements GoodsInfoDao {
    @Override
    public Optional<PriceInfo> getFromTheirPricesByRangeCode(String rangeCode) {
        return Optional.ofNullable(baseMapper().selectOneByTypeAndRangeCode(String.valueOf(GoodsType.FROM_THEIR_PRICES), rangeCode));
    }

    @Override
    public Optional<PriceInfo> getRenewalPriceByRangeCode(String rangeCode) {
        return Optional.ofNullable(baseMapper().selectOneByTypeAndRangeCode(String.valueOf(GoodsType.RENEWAL_PRICE), rangeCode));
    }
}