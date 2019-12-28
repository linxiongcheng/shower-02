package org.yuan.boot.webmvc.app.service.impl;

import org.springframework.stereotype.Service;
import org.yuan.boot.webmvc.app.mapper.SysPermissionMapper;
import org.yuan.boot.webmvc.app.pojo.SysPermission;
import org.yuan.boot.webmvc.app.service.SysPermissionService;
import org.yuan.boot.webmvc.db.service.impl.BaseServiceImpl;

/**
 * @program: learning-demo-02
 * @description:
 * @author: yuane
 * @create: 2019-12-28 13:20
 */
@Service
public class SysPermissionServiceImpl extends BaseServiceImpl<SysPermission, SysPermissionMapper> implements SysPermissionService {
}