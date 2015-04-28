package com.wxmanage.easyui.dto;

/**
 * Created by Administrator on 2015/4/23.
 */
public class SeachResultDto {

    private String seach_name;
    private String seach_id;


    public String getSeach_name() {
        return seach_name;
    }

    public void setSeach_name(String seach_name) {
        this.seach_name = seach_name;
    }

    public String getSeach_id() {
        return seach_id;
    }

    public void setSeach_id(String seach_id) {
        this.seach_id = seach_id;
    }

    public SeachResultDto(String seach_name, String seach_id) {
        this.seach_name = seach_name;
        this.seach_id = seach_id;
    }
}
