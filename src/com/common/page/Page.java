package com.common.page;

import java.util.List;

public class Page {
	
	private List<?> list;
	
	/**
	 * ��װ��Ĳ�ѯ����
	 * ����" and name like '%xg%' and age = 20 "
	 */
	private String condition;
	// ��ҳ����
	private int everyPage = 2;
	// ������
	private int totalCount;
	// ��ҳ��
	private int totalPage;
	// ��ǰҳ
	private int currentPage = 1;
	 //��ʼҳ��
    private int beginIndex;
    //�Ƿ���ҳ
    private boolean hasPrePage;
    //��һҳ
    private int prePage;
    //�Ƿ�βҳ
    private boolean hasNextPage;
    //��һҳ
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
