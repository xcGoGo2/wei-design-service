/**
 * 主要业务层，编写复杂功能，提供impl接口
 */

package com.design.weidesignservice.service;

import com.design.weidesignservice.entity.Menu;
import com.design.weidesignservice.mapper.MenuMapper;
import com.design.weidesignservice.result.ResultDTO;
import com.design.weidesignservice.result.ResultError;
import com.design.weidesignservice.result.UserError;
import com.design.weidesignservice.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Autowired
    RedisUtils redisUtils;

   /* @Autowired
    PasswordEncoder passwordEncoder;*/

    public ResultDTO findAllMenu() {
        List<Menu> menuList = null;
        try {
            menuList = menuMapper.findAllMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(menuList == null) {
            return ResultDTO.failure(new ResultError(UserError.MENU_CHECK_ERROR));
        }else {
            return ResultDTO.success(menuList, "查询成功");
        }

    }
}
