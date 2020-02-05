package org.yuan.boot.shower.db.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.yuan.boot.shower.commons.pojo.BaseCondition;

/**
 * @program: shower-01
 * @description:
 * @author: yuane
 * @create: 2020-01-31 09:04
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsInfoCondition extends BaseCondition {
    private Long id;
    private String code;
    private Integer type;

    public GoodsInfoCondition() {
    }

    public GoodsInfoCondition(int page, int size) {
        super(page, size);
    }

    public GoodsInfoCondition(int page, int size, String order, String sort) {
        super(page, size, order, sort);
    }
}