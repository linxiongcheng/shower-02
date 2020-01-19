package org.yuan.boot.shower.service.impl;

import cn.hutool.core.thread.ThreadUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.yuan.boot.shower.dao.SysPermissionDao;
import org.yuan.boot.shower.dao.SysRoleDao;
import org.yuan.boot.shower.dao.SysRolePermissionDao;
import org.yuan.boot.shower.dao.SysUserRoleDao;
import org.yuan.boot.shower.exception.ExistResultRuntimeException;
import org.yuan.boot.shower.pojo.SysRole;
import org.yuan.boot.shower.pojo.condition.SysRoleCondition;
import org.yuan.boot.shower.pojo.converter.SysRoleConverter;
import org.yuan.boot.shower.pojo.converter.SysRolePermissionConverter;
import org.yuan.boot.shower.pojo.vo.SysRoleVo;
import org.yuan.boot.shower.service.SysRoleService;
import org.yuan.boot.shower.utils.Results;
import org.yuan.boot.webmvc.pojo.Result;

import java.util.List;
import java.util.Optional;

/**
 * @program: learning-demo-02
 * @description:
 * @author: yuane
 * @create: 2020-01-11 19:58
 */
@Service
@AllArgsConstructor
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class SysRoleServiceImpl implements SysRoleService {
    private SysRoleConverter sysRoleConverter;
    private SysRoleDao sysRoleDao;
    private SysRolePermissionDao sysRolePermissionDao;
    private SysUserRoleDao sysUserRoleDao;
    private SysPermissionDao sysPermissionDao;
    private SysRolePermissionConverter sysRolePermissionConverter;

    @Override
    public Result selectPage(SysRoleCondition condition) {
        return Results.data(sysRoleDao.selectPage(condition));
    }

    @Override
    public Result selectList(SysRoleCondition condition) {
        return Results.data(sysRoleDao.selectList(condition));
    }

    @Override
    public Result selectOne(SysRole sysRole) {
        return Results.data(sysRoleDao.selectOne(sysRole));
    }

    @Override
    public Result selectById(Long id) {
        return Results.data(sysRoleDao.selectById(id));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result save(SysRoleVo sysRoleVo) {
        SysRole sysRole = sysRoleConverter.convert(sysRoleVo);
        Optional<SysRole> optional = sysRoleDao.selectByName(sysRole.getName());
        if (optional.isPresent()) {
            throw new ExistResultRuntimeException(Results.existError("name已存在"));
        }
        sysRoleDao.save(sysRole);
        ThreadUtil.execAsync(() -> {
            List<Long> permissionIds = sysPermissionDao.selectByIds(sysRoleVo.getPermissionIds());
            sysRolePermissionDao.batchSave(sysRolePermissionConverter.convert(sysRole.getId(), permissionIds));
        });
        return Results.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result update(SysRoleVo sysRoleVo) {
        SysRole sysRole = sysRoleConverter.convert(sysRoleVo);
        sysRoleDao.update(sysRole);
        return Results.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result updatePermission(SysRoleVo sysRoleVo) {
        Long roleId = sysRoleVo.getId();
        List<Long> permissionIds = sysRoleVo.getPermissionIds();
        permissionIds = sysPermissionDao.selectByIds(permissionIds);
        sysRolePermissionDao.batchUpdate(new SysRole().setId(roleId), sysRolePermissionConverter.convert(roleId, permissionIds));
        return Results.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result delete(List<Long> ids) {
        sysRoleDao.delete(ids);
        sysUserRoleDao.deleteByRoleIds(ids);
        sysRolePermissionDao.deleteByRoleIds(ids);
        return Results.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result delete(Long id) {
        sysRoleDao.delete(id);
        sysUserRoleDao.deleteByRoleId(id);
        sysRolePermissionDao.deleteByRoleId(id);
        return Results.ok();
    }
}