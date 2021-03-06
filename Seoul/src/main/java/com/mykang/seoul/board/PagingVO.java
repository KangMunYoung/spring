package com.mykang.seoul.board;

public class PagingVO {

	private int totalRecord;// 총레코드수
	private int nowPage = 1;// 현재페이지
	private int totalPage;// 총페이지
	private int onePageRecord = 5;// 한페이지당 레코드수

	// 검색어
	private String searchKey;
	private String searchWord;

	//페이지
	private int onePageNumCount = 5;	//한번에 표시할 페이지수
	private int startPage=1;	
	
	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;

		// 총페이지수
		totalPage = (int) Math.ceil(totalRecord / (double) onePageRecord);
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
		
		if(nowPage != 0) {
			//			현재페이지	한번에 표시할 페이지수
			startPage = (nowPage-1)/onePageNumCount*onePageNumCount+1;
		}
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getOnePageRecord() {
		return onePageRecord;
	}

	public void setOnePageRecord(int onePageRecord) {
		this.onePageRecord = onePageRecord;
	}

	//검색어
	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public int getOnePageNumCount() {
		return onePageNumCount;
	}

	public void setOnePageNumCount(int onePageNumCount) {
		this.onePageNumCount = onePageNumCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	
}
