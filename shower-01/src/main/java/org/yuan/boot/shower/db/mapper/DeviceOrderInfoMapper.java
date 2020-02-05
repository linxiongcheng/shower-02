package org.yuan.boot.shower.db.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.yuan.boot.shower.commons.mapper.BaseMapper;
import org.yuan.boot.shower.db.pojo.DeviceOrderInfo;
import org.yuan.boot.shower.db.pojo.DeviceOrderInfoExample;

@Mapper
public interface DeviceOrderInfoMapper extends BaseMapper {
    long countByExample(DeviceOrderInfoExample example);

    int deleteByExample(DeviceOrderInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DeviceOrderInfo record);

    int insertSelective(DeviceOrderInfo record);

    List<DeviceOrderInfo> selectByExample(DeviceOrderInfoExample example);

    DeviceOrderInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DeviceOrderInfo record, @Param("example") DeviceOrderInfoExample example);

    int updateByExample(@Param("record") DeviceOrderInfo record, @Param("example") DeviceOrderInfoExample example);

    int updateByPrimaryKeySelective(DeviceOrderInfo record);

    int updateByPrimaryKey(DeviceOrderInfo record);
}