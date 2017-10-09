package com.redding.rbac.commons.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class MenuNodeDto implements Serializable {

    private Integer id;

    private Integer sequence;

    private Integer appId;

    private String url;

    private String name;

    private boolean isMenu;

    private List<MenuNodeDto> nodes;


    public boolean getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(boolean isMenu) {
        isMenu = isMenu;
    }
}