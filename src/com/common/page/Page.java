package com.common.page;

import java.util.List;

public class Page {
	
	private List<?> list;
	
	/**
	 * 封装后的查询条件
	 * 例：" and name like '%xg%' and age = 20 "
	 */
	private String condition;
	// 单页条数
	private int everyPage = 2;
	// 总行数
	private int totalCount;
	// 行页数
	private int totalPage;
	// 当前页
	private int currentPage = 1;
	 //开始页码
    private int beginIndex;
    //是否首页
    private boolean hasPrePage;
    //上一页
    private int prePage;
    //是否尾页
    private boolean hasNextPage;
    //下一页
    private int nextPage;
    
    

    public Page(int currentPage, int everyPage){
        this.currentPage = currentPage;
        this.everyPage = everyPage;
    }
    
    public Page(){}
    
    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public Page(int everyPage, int totalCount, int totalPage, int currentPage,
            int beginIndex, boolean hasPrePage, boolean hasNextPage,int prePage,int nextPage) {
        this.everyPage = everyPage;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.beginIndex = beginIndex;
        this.hasPrePage = hasPrePage;
        this.hasNextPage = hasNextPage;
        this.prePage=prePage;
        this.nextPage=nextPage;
    }
    public Page(int everyPage, int totalCount, int totalPage, int currentPage,
            int beginIndex, boolean hasPrePage, boolean hasNextPage,int prePage,int nextPage,List<?> list) {
        this.everyPage = everyPage;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.beginIndex = beginIndex;
        this.hasPrePage = hasPrePage;
        this.hasNextPage = hasNextPage;
        this.prePage=prePage;
        this.nextPage=nextPage;
        this.list=list;
    }
    public Page(int totalCount, int totalPage, int currentPage, int prePage,
            int nextPage, List<?> list) {
        super();
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.prePage = prePage;
        this.nextPage = nextPage;
        this.list = list;
    }

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getEveryPage() {
		return everyPage;
	}

	public void setEveryPage(int everyPage) {
		this.everyPage = everyPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	public boolean isHasPrePage() {
		return hasPrePage;
	}

	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

    
    
    
    
    
    
    
    
    
    
    
    
    
	
    
    
    
    
	

}
