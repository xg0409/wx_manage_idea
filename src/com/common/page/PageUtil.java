package com.common.page;

import java.util.List;


public class PageUtil {
	
	public static Page createPage(int everyPage,int totalCount,int currentPage,List<?> list) {
		everyPage = getEveryPage(everyPage);
		currentPage = getCurrentPage(currentPage);
		int totalPage = getTotalPage(everyPage, totalCount);
		int beginIndex = getBeginIndex(everyPage, currentPage);
		boolean hasPrePage = getHasPrePage(currentPage);
		boolean hasNextPage = getHasNextPage(totalPage, currentPage);
		int prePage=getPrePage(currentPage);
		int nextPage=getNextPage(currentPage);
		return new Page(everyPage, totalCount, totalPage, currentPage,
				beginIndex, hasPrePage,  hasNextPage,prePage,nextPage,list);
	}
	
	public static Page createPage(Page page,int totalCount,List<?> list) {
		int everyPage = getEveryPage(page.getEveryPage());
		int currentPage = getCurrentPage(page.getCurrentPage());
		int totalPage = getTotalPage(everyPage, totalCount);
		int beginIndex = getBeginIndex(everyPage, currentPage);
		boolean hasPrePage = getHasPrePage(currentPage);
		boolean hasNextPage = getHasNextPage(totalPage, currentPage);
		int prePage=getPrePage(currentPage);
		int nextPage=getNextPage(currentPage);
		return new Page(everyPage, totalCount, totalPage, currentPage,
				beginIndex, hasPrePage,  hasNextPage,prePage,nextPage,list);
	}
	
	public static int getEveryPage(int everyPage) {
		return everyPage == 0 ? 10 : everyPage;
	}
	
	public static int getCurrentPage(int currentPage) {
		return currentPage == 0 ? 1 : currentPage;
	}
	
	public static int getTotalPage(int everyPage,int totalCount) {
		int totalPage = 0;
		if(totalCount % everyPage == 0) {
			totalPage = totalCount / everyPage;
		} else {
			totalPage = totalCount / everyPage + 1;
		}
		return totalPage;
	}
	
	public static int getBeginIndex(int everyPage,int currentPage) {
		return (currentPage - 1) * everyPage;
	}
	
	public static boolean getHasPrePage(int currentPage) {
		return currentPage == 1 ? false : true;
	}
	
	public static boolean getHasNextPage(int totalPage, int currentPage) {
		return currentPage == totalPage || totalPage == 0 ? false : true;
	}
	public static int getPrePage(int currentPage){
		return currentPage-1;
	}
	public static int getNextPage(int currentPage){
		return currentPage+1;
	}
}
