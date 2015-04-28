package com.common.init;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.stereotype.Component;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.wxmanage.user.dto.WxUser;


@Component
public class InitDataAction {


	private InitDataAction() {
		XStream xstream =  new XStream(new DomDriver());
		File file = null;
		try {
			String source = this.getClass().getResource("/init/wxInitUser.xml").getPath();
			file = new File(source);
		} catch (Exception e) {
		}
		if(file != null && file.exists()){
			try {
				System.out.println("******初始化数据开始******");
				InputStreamReader o = new FileReader(file);
				Reader reader = new InputStreamReader(new FileInputStream(file),"UTF-8");
				xstream.alias("WxUser", WxUser.class);
				List<WxUser> list = (List<WxUser>) xstream.fromXML(reader);
				System.out.println(list);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("******初始化数据结束******");
		}


	}



}
