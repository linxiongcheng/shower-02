package com.idea.shower.app.db.module.pojo;



import com.idea.shower.app.db.commons.pojo.BaseDbEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class AdminRole extends BaseDbEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 角色名
     */
    private String name;
    /**
     * 启用状态（1 启用，0 停用）
     */
    private Integer enabled;
}