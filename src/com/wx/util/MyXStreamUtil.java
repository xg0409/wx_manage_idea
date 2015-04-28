package com.wx.util;

import java.io.Writer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class MyXStreamUtil {

	/**
	 * 将所有xml数据都添加CDATA格式
	 */
	public static XStream xStream	= new XStream(new XppDriver(){

		@Override
		public HierarchicalStreamWriter createWriter(Writer out) {
			// TODO Auto-generated method stub
			return new PrettyPrintWriter(out){
				// 对所有xml节点都添加CDATA标记
				boolean cdata = true;

				@Override
				public void startNode(String name, Class clazz) {
					// TODO Auto-generated method stub
					super.startNode(name, clazz);
				}

				@Override
				protected void writeText(QuickWriter writer, String text) {
					if(cdata){
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					}else{
						writer.write(text);
					}
				}

			};
		}

	});

}
