package com.wxmanage.easyui.dto;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/4/17.
 */
public class TreeGridDto {

    private Integer id;
    private String name;
    private Integer size;
    private String date;
    private List<TreeGridDto> list;


    public TreeGridDto(Integer id, String name, Integer size, String date) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.date = date;
    }

    public TreeGridDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<TreeGridDto> getList() {
        return list;
    }

    public void setList(List<TreeGridDto> list) {
        this.list = list;
    }
}
