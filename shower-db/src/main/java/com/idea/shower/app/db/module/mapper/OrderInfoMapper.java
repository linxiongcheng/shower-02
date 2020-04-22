package com.idea.shower.app.db.module.mapper;

import com.idea.shower.app.db.commons.mapper.BaseMapper;
import com.idea.shower.app.db.module.pojo.OrderInfo;
import com.idea.shower.app.db.module.pojo.OrderInfoExample;
import com.idea.shower.app.db.module.pojo.query.OrderInfoQuery;
import com.idea.shower.app.db.module.pojo.vo.OrderInfoDeviceVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface OrderInfoMapper extends BaseMapper {
    long countByExample(OrderInfoExample example);

    int deleteByExample(OrderInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    List<OrderInfo> selectByExample(OrderInfoExample example);

    OrderInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderInfo record, @Param("example") OrderInfoExample example);

    int updateByExample(@Param("record") OrderInfo record, @Param("example") OrderInfoExample example);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    int updateStatusByOrderNo(@Param("updatedStatus") Integer updatedStatus, @Param("orderNo") String orderNo);

    List<OrderInfo> selectByCondition(@Param("condition") OrderInfoQuery condition);

    OrderInfo selectOneByOrderNo(@Param("orderNo") String orderNo);

    OrderInfo selectOneByIdOrOrderNo(@Param("id") Long id, @Param("orderNo") String orderNo);

    List<OrderInfo> selectByConditionWeXin(@Param("query") OrderInfoQuery query);

    int updateTotalPriceByOrderNo(@Param("updatedTotalPrice") BigDecimal updatedTotalPrice, @Param("orderNo") String orderNo);

    List<OrderInfoDeviceVO> selectOrderInfoDeviceVOListByCondition(@Param("query") OrderInfoQuery query);

    int updateStatusById(@Param("updatedStatus") Integer updatedStatus, @Param("id") Long id);


}