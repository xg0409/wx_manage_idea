package com.tag.vo;

/**
 * Created by Administrator on 2015/4/23.
 */
public class AutoComplete {

    private String seach_name; //��ʾ��ʾ���ֶ�
    private String seach_id;   //���ݺ�̨���ֶ�
    private String seach_value; //��ѯ���ݵ�ֵ
    private String maxRows; //��ѯ�б������Ŀ


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

    public String getSeach_value() {
        return seach_value;
    }

    public void setSeach_value(String seach_value) {
        this.seach_value = seach_value;
    }

    public String getMaxRows() {
        return maxRows;
    }

    public void setMaxRows(String maxRows) {
        this.maxRows = maxRows;
    }

    @Override
    public String toString() {
        return "AutoComplete{" +
                "seach_name='" + seach_name + '\'' +
                ", seach_id='" + seach_id + '\'' +
                ", seach_value='" + seach_value + '\'' +
                ", maxRows='" + maxRows + '\'' +
                '}';
    }
}
