package com.wxmanage.easyui.action;

import com.common.page.Page;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.tag.vo.AutoComplete;
import com.wxmanage.easyui.dto.EasyUiTree;
import com.wxmanage.easyui.dto.SeachResultDto;
import com.wxmanage.easyui.dto.TreeGridDto;
import com.wxmanage.user.dto.WxUserQueryDto;
import com.wxmanage.user.service.WxmUserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

@Controller
public class EasyUiAction {

	@RequestMapping(value={"/easyui_panel.do"})
	public void getPanel(HttpServletRequest request,HttpServletResponse response) throws  Exception{
		String json="<p>panel1</p><p>panel2</p>";
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
		response.getWriter().print(json);

	}

	@RequestMapping(value={"/easyui_tabs.do"})
	public String getTabs(HttpServletRequest request,HttpServletResponse response) throws  Exception{
		String json="<p>panel1</p><p>panel2</p>";
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
		return "/easyui/easyui_panel";

	}


	@RequestMapping(value={"/easyui_accordion.do"})
	public void getAccordion(HttpServletRequest request,HttpServletResponse response) throws  Exception{
		StringBuffer json = new StringBuffer("{\"total\":28,\"rows\":");
		json.append("[{\"itemid\":\"item1\",\"productid\":\"product1\",\"listprice\":\"price1\",\"unitcost\":\"cast1\",\"attr1\":\"attribute1\",\"status\":\"status1\"},");
		json.append("{\"itemid\":\"item2\",\"productid\":\"product2\",\"listprice\":\"price2\",\"unitcost\":\"cast2\",\"attr1\":\"attribute2\",\"status\":\"status2\"},");
		json.append("{\"itemid\":\"item3\",\"productid\":\"product3\",\"listprice\":\"price3\",\"unitcost\":\"cast3\",\"attr1\":\"attribute3\",\"status\":\"status3\"},");
		json.append("{\"itemid\":\"item4\",\"productid\":\"product4\",\"listprice\":\"price4\",\"unitcost\":\"cast4\",\"attr1\":\"attribute4\",\"status\":\"status4\"}");
		json.append("]}");

		response.getWriter().print(json.toString());

	}

	@RequestMapping(value={"/easyui_tree.do"})
	public void getTree(HttpServletRequest request,HttpServletResponse response) throws  Exception{
		StringBuffer json = new StringBuffer("[{");
		json.append(" \"id\":\"1\", ");
		json.append("\"text\":\"父节点1\",");
		json.append("\"children\":[{");
			          json.append("\"id\":\"11\",");
		              json.append("\"text\":\"Photos\",");
		              json.append("\"state\":\"closed\",");
		              json.append("\"children\":[{");
		                            json.append("\"id\":\"111\",");
		                            json.append("\"text\":\"Friend\"");
		                            json.append("},{");
                                    json.append("\"id\":\"112\",");
		                            json.append("\"text\":\"Wife\"");
		                            json.append("}]");
		             json.append("}]");
		json.append("}]");

		List<EasyUiTree> parent_list = new ArrayList<EasyUiTree>();

		EasyUiTree tree = new EasyUiTree();
		tree.setId(100);
		tree.setText("类节点");
		tree.setState("open");
		List<EasyUiTree> children = new ArrayList<EasyUiTree>();
		children.add(new EasyUiTree(1001, "子节点1", "open"));
		children.add(new EasyUiTree(1002, "子节点2", "open"));

		EasyUiTree children_tree = new EasyUiTree(1003, "子节点3", "open");
		List<EasyUiTree> children_c_tree_list = new ArrayList<EasyUiTree>();
		children_c_tree_list.add(new EasyUiTree(10021, "子节点2_子节点1", "closed"));
		children_c_tree_list.add(new EasyUiTree(10022, "子节点2_子节点2", "closed"));
		children_tree.setChildren(children_c_tree_list);
		children.add(children_tree);

		tree.setChildren(children);
		parent_list.add(tree);

		JSONArray jsonArray = JSONArray.fromObject(parent_list);
		String result = jsonArray.toString().replaceAll("list", "children");
		response.getWriter().print(result);

	}

	@RequestMapping(value={"/easyui_treeGrid.do"})
	public void getTreeGrid(HttpServletRequest request,HttpServletResponse response) throws  Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<TreeGridDto> list = new ArrayList<TreeGridDto>();
		TreeGridDto dto1 =  new TreeGridDto(100,"节点1",100,format.format(new Date()));
			List<TreeGridDto> list_children1 = new ArrayList<TreeGridDto>();
			TreeGridDto dto_children1 =  new TreeGridDto(1001,"子节点1",1001,format.format(new Date()));
			list_children1.add(dto_children1);
			TreeGridDto dto_children2 =  new TreeGridDto(1002,"子节点2",1002,format.format(new Date()));
			list_children1.add(dto_children2);
		dto1.setList(list_children1);
		list.add(dto1);


		TreeGridDto dto2 =  new TreeGridDto(200,"节点2",200,format.format(new Date()));
		list.add(dto2);
		JSONArray jsonArray = JSONArray.fromObject(list);
		String result = jsonArray.toString().replaceAll("list", "children");
		response.getWriter().print(result);

	}

	@RequestMapping(value={"/autocomplete.do"})
	public void getAutoComplete(HttpServletRequest request,
								HttpServletResponse response,AutoComplete autoComplete) throws  Exception {
		System.out.println("autocomplete.do==>"+autoComplete);
		StringBuffer result = new StringBuffer();
		result.append("[{\"id\":\"1\",\"name\":\"aa\"},");
		result.append("{\"id\":\"2\",\"name\":\"ab\"},");
		result.append("{\"id\":\"3\",\"name\":\"bc\"}]");

		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().print(result.toString());
		response.setDateHeader("Expires", 0);
		response.getWriter().flush();
		response.getWriter().close();
	}
	@RequestMapping(value={"/autocomplete2.do"})
	public void getAutoComplete2(HttpServletRequest request,
								 HttpServletResponse response,AutoComplete autoComplete) throws  Exception {
		System.out.println("autocomplete2.do===>" + autoComplete);

		List<SeachResultDto> list = new ArrayList<SeachResultDto>();
		list.add(new SeachResultDto("xugang","1001"));
		list.add(new SeachResultDto("xugang2", "1002"));
		list.add(new SeachResultDto("xugang3", "1003"));
		list.add(new SeachResultDto("xugang4", "1004"));

		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().print(getJsonArray(list));
		response.setDateHeader("Expires", 0);
		response.getWriter().flush();
		response.getWriter().close();



	}

	public String getJsonArray(List<SeachResultDto> list){
		JSONArray jsonArray = JSONArray.fromObject(list);
		System.out.println(jsonArray.toString());
		return jsonArray.toString();
	}



	@RequestMapping(value={"/dialog.do"})
	public String getDialog(HttpServletRequest request,HttpServletResponse response) throws  Exception {
		request.setAttribute("name","xugang");
		System.out.println("hahhhahahah");

		return "/dialog/iframeTest";
	}

	@RequestMapping(value={"/menu.do"})
	public void getMenu(HttpServletRequest request,HttpServletResponse response) throws  Exception {

		StringBuffer data = new StringBuffer();
		data.append("[{\"id\":\"1001\",\"menu\":\"菜单1\",\"url\":\"/xxx.do\",\"children\":" +
				"[{\"id\":\"10011\",\"menu\":\"子菜单1.1\",\"url\":\"/easyui_tabs.do\"}," +
				"{\"id\":\"10012\",\"menu\":\"子菜单2.1\",\"url\":\"/menu_01.do\",\"children\":[{\"id\":\"100111\",\"menu\":\"子菜单1.2.1\",\"url\":\"/dialog.do\"}]}]},");
		data.append("{\"id\":\"1001\",\"menu\":\"菜单2\",\"url\":\"/xxx.do\",\"children\":[{\"id\":\"10011\",\"menu\":\"子菜单2.1\",\"url\":\"/menu_01.do\"},{\"id\":\"10012\",\"menu\":\"子菜单2.2\",\"url\":\"/menu_02.do\"}]},");
		data.append("{\"id\":\"1001\",\"menu\":\"菜单3\",\"url\":\"/xxx.do\",\"children\":[{\"id\":\"10011\",\"menu\":\"子菜单3.1\",\"url\":\"/xxxx.do\"},{\"id\":\"10012\",\"menu\":\"子菜单3.2\",\"url\":\"/nnnn.do\"}]}]");

		response.getWriter().print(data.toString());
	}

	@RequestMapping(value={"/menu_01.do"})
	public String getMenu_01(){
		return "/easyui/layout/test";
	}
	@RequestMapping(value={"/menu_02.do"})
	public String getMenu_02(){
		return "/easyui/layout/test2";
	}








}
