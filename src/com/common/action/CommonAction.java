package com.common.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.dto.MessageMenu;
/**
 * 公共请求处理类
 * @author Administrator
 *
 */
@Controller
public class CommonAction {

	/**
	 * 获取待办事项消息列表
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value={"/getMessageMenu.do"})
	public static void getMessageMenu(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String,List<MessageMenu>> map = new HashMap<String, List<MessageMenu>>();
		List<MessageMenu> list = new ArrayList<MessageMenu>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		MessageMenu menu = new MessageMenu(null, "xugang", dateFormat.format(new Date()), "你好！请问xxxxxx");
		list.add(menu);
		menu = new MessageMenu(null, "xugang", dateFormat.format(new Date()), "你好！请问xxxxxx");
		list.add(menu);
		menu = new MessageMenu(null, "xugang", dateFormat.format(new Date()), "你好！请问xxxxxx");
		list.add(menu);
		menu = new MessageMenu(null, "xugang", dateFormat.format(new Date()), "你好！请问xxxxxx");
		list.add(menu);
		menu = new MessageMenu(null, "xugang", dateFormat.format(new Date()), "你好！请问xxxxxx");
		list.add(menu);
		map.put("message2", list);

		JSONObject jsonObject = JSONObject.fromObject(map);
		System.out.println(jsonObject.toString());
		response.getWriter().print(jsonObject.toString());
	}


}
