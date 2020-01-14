package org.yuan.boot.webmvc.app.controller;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yuan.boot.webmvc.app.dao.SysRoleService;
import org.yuan.boot.webmvc.controller.AbstractResultController;

/**
 * @program: learning-demo-02
 * @description:
 * @author: yuane
 * @create: 2020-01-04 22:29
 */
@EqualsAndHashCode(callSuper = true)
@RestController
@RequestMapping("sys/role")
@Value
public class SysRoleController extends AbstractResultController {
    private SysRoleService sysRoleService;
}