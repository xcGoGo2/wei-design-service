package com.design.weidesignservice.controller;

import com.design.weidesignservice.result.ResultDTO;
import com.design.weidesignservice.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("design/api/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    /**
     * 获取 menu 菜单
     */
    @GetMapping ("/getMenuList")
    public ResultDTO getMenuList() {
        return menuService.findAllMenu();
    }
}
