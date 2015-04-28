package com.wxmanage.easyui.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/4/17.
 */
public class EasyUiTree {

    private Integer id;
    private String text;
    private String state;
    private List<EasyUiTree> children = new ArrayList<EasyUiTree>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<EasyUiTree> getChildren() {
        return children;
    }

    public void setChildren(List<EasyUiTree> children) {
        this.children = children;
    }

    public EasyUiTree(Integer id, String text, String state) {
        this.id = id;
        this.text = text;
        this.state = state;
    }

    public EasyUiTree() {
    }
}
