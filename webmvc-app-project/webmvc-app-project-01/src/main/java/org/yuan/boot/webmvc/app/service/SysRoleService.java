package org.yuan.boot.webmvc.app.service;

import org.yuan.boot.db.service.BaseDbService;
import org.yuan.boot.webmvc.app.pojo.SysRole;
import org.yuan.boot.webmvc.app.pojo.condition.SysRoleCondition;
import org.yuan.boot.webmvc.app.pojo.vo.SysRoleVo;
import org.yuan.boot.webmvc.pojo.Result;

/**
 * @program: learning-demo-02
 * @description:
 * @author: yuane
 * @create: 2020-01-01 18:12
 */
public interface SysRoleService extends BaseDbService<SysRole, Long> {
    Result page(SysRoleCondition condition);

    Result list(SysRoleCondition condition);

    Result get(SysRole sysRole);

    Result get(Long id);

    Result save(SysRoleVo sysRoleVo);
}
