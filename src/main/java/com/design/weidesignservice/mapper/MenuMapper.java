package com.design.weidesignservice.mapper;

import com.design.weidesignservice.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<Menu> findAllMenu();
}
