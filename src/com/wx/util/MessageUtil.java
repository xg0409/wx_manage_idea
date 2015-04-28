package com.wx.util;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.wx.dto.message.Article;
import com.wx.dto.message.ImageMessage;
import com.wx.dto.message.MusicMessage;
import com.wx.dto.message.NewsMessage;
import com.wx.dto.message.TextMessage;
import com.wx.dto.message.VideoMessage;
import com.wx.dto.message.VoiceMessage;

public class MessageUtil {
	static Logger logger = LogManager.getLogger(MessageUtil.class);

	/**
	 * 百度翻译程序
	 */
	public static String baiduMap = "maiduMap";
	//天气
	public static String sinaTQ = "tq";
	// 当前程序
	public static String procedure = "";


	// 请求用户消息类型
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";
	public static final String REQ_MESSAGE_TYPE_VIDEO = "video";
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";
	public static final String REQ_MESSAGE_TYPE_LINK = "link";

	public static final String REQ_MESSAGE_TYPE_EVENT = "event";

	// 相应用户消息类型
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";
	public static final String RESP_MESSAGE_TYPE_IMAGE = "image";
	public static final String RESP_MESSAGE_TYPE_VOICE = "voice";
	public static final String RESP_MESSAGE_TYPE_VIDEO = "video";
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";

	// 关注事件类型
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
	// 取消关注事件类型
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
	// 自定义菜单时间
	public static final String EVENT_TYPE_MENU_CLICK = "CLICK";
	//上报地址位置
	public static final String EVENT_TYPE_LOCATION = "LOCATION";

	public static HashMap<String, String> parseXML(HttpServletRequest request)
			throws Exception {

		HashMap<String, String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		Document document = reader.read(request.getInputStream());
		// 得到xml节点
		Element root = document.getRootElement();
		recursiveParseXML(root, map);

		return map;
	}

	public static HashMap<String, String> parseXML(String xml) throws Exception {

		HashMap<String, String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		Document document = reader.read(xml);
		// 得到xml节点
		Element root = document.getRootElement();
		recursiveParseXML(root, map);

		return map;
	}

	private static void recursiveParseXML(Element root,
										  HashMap<String, String> map) {
		List<Element> elements = root.elements();
		if (elements.size() == 0) {
			map.put(root.getName(), root.getTextTrim());
			logger.info(root.getName() + ":" + root.getTextTrim());
		} else {
			for (Element element : elements) {
				recursiveParseXML(element, map);
			}
		}

	}

	public static void main(String[] args) {
		TextMessage textMessage = new TextMessage();
		textMessage.setToUserName("sdfsad");
		System.err.println(messageToXml(textMessage));
	}

	public static String messageToXml(TextMessage textMessage) {
		XStream xStream = MyXStreamUtil.xStream;
		xStream.alias("xml", TextMessage.class);
		return xStream.toXML(textMessage);
	}

	public static String messageToXml(ImageMessage imageMessage) {
		XStream xStream = MyXStreamUtil.xStream;
		xStream.alias("xml", ImageMessage.class);
		return xStream.toXML(imageMessage);
	}

	public static String messageToXml(MusicMessage musicMessage) {
		XStream xStream = MyXStreamUtil.xStream;
		xStream.alias("xml", MusicMessage.class);
		return xStream.toXML(musicMessage);
	}

	public static String messageToXml(NewsMessage newsMessage) {
		XStream xStream = MyXStreamUtil.xStream;
		xStream.alias("xml", NewsMessage.class);
		xStream.alias("item", Article.class);
		return xStream.toXML(newsMessage);
	}

	public static String messageToXml(VideoMessage videoMessage) {
		XStream xStream = MyXStreamUtil.xStream;
		xStream.alias("xml", VideoMessage.class);
		return xStream.toXML(videoMessage);
	}

	public static String messageToXml(VoiceMessage voiceMessage) {
		XStream xStream = MyXStreamUtil.xStream;
		xStream.alias("xml", VoiceMessage.class);
		return xStream.toXML(voiceMessage);
	}

	/**
	 * 判断是否是QQ表情
	 *
	 * @param content
	 * @return
	 */
	public static boolean isQqFace(String content) {
		boolean result = false;

		// 判断QQ表情的正则表达式
		String qqfaceRegex = "/::\\)|/::~|/::B|/::\\||/:8-\\)|/::<|/::$|/::X|/::Z|/::'\\(|/::-\\||/::@|/::P|/::D|/::O|/::\\(|/::\\+|/:--b|/::Q|/::T|/:,@P|/:,@-D|/::d|/:,@o|/::g|/:\\|-\\)|/::!|/::L|/::>|/::,@|/:,@f|/::-S|/:\\?|/:,@x|/:,@@|/::8|/:,@!|/:!!!|/:xx|/:bye|/:wipe|/:dig|/:handclap|/:&-\\(|/:B-\\)|/:<@|/:@>|/::-O|/:>-\\||/:P-\\(|/::'\\||/:X-\\)|/::\\*|/:@x|/:8\\*|/:pd|/:<W>|/:beer|/:basketb|/:oo|/:coffee|/:eat|/:pig|/:rose|/:fade|/:showlove|/:heart|/:break|/:cake|/:li|/:bome|/:kn|/:footb|/:ladybug|/:shit|/:moon|/:sun|/:gift|/:hug|/:strong|/:weak|/:share|/:v|/:@\\)|/:jj|/:@@|/:bad|/:lvu|/:no|/:ok|/:love|/:<L>|/:jump|/:shake|/:<O>|/:circle|/:kotow|/:turn|/:skip|/:oY|/:#-0|/:hiphot|/:kiss|/:<&|/:&>";
		Pattern p = Pattern.compile(qqfaceRegex);
		Matcher m = p.matcher(content);
		if (m.matches()) {
			result = true;
		}
		return result;
	}

}
