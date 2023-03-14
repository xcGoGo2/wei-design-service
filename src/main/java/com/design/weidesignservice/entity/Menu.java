package com.design.weidesignservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 菜单实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    String id;

    String pid;

    Number ranking;

    String showName;

    String icon;

    String router;

    Number createDate;
}
