package com.tag.core;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Created by Administrator on 2015/4/23.
 */
public class AutoCompleteTag extends TagSupport {

    private String seach_name;
    private String seach_id;
    private String url;
    private String id;
    private String name;
    private String maxRows;    // 显示最多匹配数目
    private String minChars;  // 最少字符开始匹配
    private String class_name;



    @Override
    public int doStartTag() throws JspException {
        return super.doStartTag();
    }

    @Override
    public int doEndTag() throws JspException {

        StringBuffer tag = new StringBuffer();
        tag.append("<input type=\"text\" class=\"").append(getClass_name()).append("\" id=\"")
                .append(id).append("\" name=\"").append(getName()).append("\"/>").append("\n");
        tag.append("<script>").append("\n");
        tag.append("$(function(){").append("\n");
        tag.append("    $(\"#").append(id).append("\").autocomplete(\"").append(url).append("\",{").append("\n");
        tag.append("          max:").append(getMaxRows()).append(",").append("\n");
        tag.append("          minChars: ").append(getMinChars()).append(",").append("\n");
        tag.append("          dataType: 'json',").append("\n");
        tag.append("          multiple: false,").append("\n");
        tag.append("          extraParams: {").append("\n");
        tag.append("               maxRows:").append(getMaxRows()).append(",").append("\n");
        tag.append("               seach_value:function(){").append("\n");
        tag.append("                    return $(\"#").append(id).append("\").val();").append("\n");
        tag.append("               }").append("\n");
        tag.append("           },").append("\n");
        tag.append("          parse: function (data) {").append("\n");
        tag.append("                    var res_array = $.map(data, function(temp) {").append("\n");
        tag.append("                         return {").append("\n");
        tag.append("                                   data: temp,").append("\n");
        tag.append("                                   value: temp.").append(seach_name).append(",").append("\n");
        tag.append("                                   result:temp.").append(seach_name).append("\n");
        tag.append("                                }").append("\n");
        tag.append("                    });").append("\n");
        tag.append("                    return res_array;").append("\n");
        tag.append("                },").append("\n");
        tag.append("         formatItem: function (row, i, max) {").append("\n");
        tag.append("             return row['").append(seach_name).append("'];").append("\n");
        tag.append("         }").append("\n");
        tag.append("    }).result(function (event, row, formatted) {").append("\n");
        tag.append("              alert(row['").append(seach_id).append("']);").append("\n");
        tag.append("    });").append("\n");
        tag.append("});").append("\n");
        tag.append("</script>");
        JspWriter out = this.pageContext.getOut();
        try {
            out.print(tag.toString());
        }catch (Exception e){
            e.printStackTrace();
        }

        return super.doEndTag();
    }


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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        setName(name);
        return name;
    }

    public void setName(String name) {
        if(name == null){
            name = "";
        }
        this.name = name;
    }


    public String getMaxRows() {
        setMaxRows(maxRows);
        return maxRows;
    }

    public void setMaxRows(String maxRows) {
        if(maxRows == null || maxRows.length() == 0){
            maxRows = "10";
        }
        this.maxRows = maxRows;
    }

    public String getMinChars() {
        setMinChars(minChars);
        return minChars;
    }

    public void setMinChars(String minChars) {
        if(minChars == null || minChars.length() == 0){
            minChars = "2";
        }
        this.minChars = minChars;
    }

    public String getClass_name() {
        setClass_name(class_name);
        return class_name;
    }

    public void setClass_name(String class_name) {
        if(class_name == null){
            class_name = "";
        }
        this.class_name = class_name;
    }
}
