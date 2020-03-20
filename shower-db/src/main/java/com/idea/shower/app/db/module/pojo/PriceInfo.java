package com.idea.shower.app.db.module.pojo;

import com.idea.shower.app.db.commons.pojo.BaseDbEntity;
import lombok.*;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceInfo extends BaseDbEntity {
    /**
     * 编号
     */
    private String code;

    /**
     * 类型
     */
    private String type;

    /**
     * 地区码
     */
    private String rangeCode;

    /**
     * 时间定价
     */
    private BigDecimal timePrice;

    /**
     * 时间计费间隔
     */
    private Double timeInterval;

    /**
     * 时间单位
     */
    private Integer timeUnit;

    /**
     * 水定价
     */
    private BigDecimal waterPrice;

    /**
     * 水计费间隔
     */
    private Double waterInterval;

    /**
     * 水计费单位
     */
    private Integer waterUnit;

    /**
     * 有效
     */
    private Integer enabled;
}