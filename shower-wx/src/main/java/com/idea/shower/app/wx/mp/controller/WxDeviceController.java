package com.idea.shower.app.wx.mp.controller;

import com.idea.shower.app.wx.mp.service.WxDeviceService;
import com.idea.shower.web.webmvc.controller.ResultController;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: shower-01
 * @description:
 * @author: yuane
 * @create: 2020-01-31 09:47
 */
@RestController
@RequestMapping("com/idea/shower/shower/app/wx/device")
@AllArgsConstructor
public class WxDeviceController extends ResultController {
    private WxDeviceService wxDeviceService;
}