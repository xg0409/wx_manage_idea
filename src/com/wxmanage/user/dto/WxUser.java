package com.wxmanage.user.dto;


public class WxUser {
	private String id;
	//用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
	private int subscribe;
	//用户的标识，对当前公众号唯一
	private String openid;
	//用户的昵称
	private String nickName;
	//用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	private int sex = 0; // 默认是0
	//用户的语言，简体中文为zh_CN


	private String language;

	//用户所在城市
	private String city;
	//用户所在省份
	private String province;
	//用户所在国家
	private String country;
	/**
	 * 用户头像，最后一个数值代表正方形头像大小
	 * （有0、46、64、96、132数值可选，0代表640*640正方形头像），
	 * 用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
	 * "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/0",
	 */

	private String headimgurl;

	//用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
	private long subscribe_time;
	//只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段
	private String unionid;
	// 备注
	private String remark;


	public int getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(int subscribe) {
		this.subscribe = subscribe;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public long getSubscribe_time() {
		return subscribe_time;
	}
	public void setSubscribe_time(long subscribe_time) {
		this.subscribe_time = subscribe_time;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}



	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Override
	public String toString() {
		return "WxUser [id=" + id + ", subscribe=" + subscribe + ", openid="
				+ openid + ", nickName=" + nickName + ", sex=" + sex
				+ ", language=" + language + ", city=" + city + ", province="
				+ province + ", country=" + country + ", headimgurl="
				+ headimgurl + ", subscribe_time=" + subscribe_time
				+ ", unionid=" + unionid + ", remark=" + remark + "]";
	}







}
