package com.baibao.core.utils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 版权所有：(C)2013-2018 中融佰诚
 * </p>
 * 
 * @作者：zp
 * @时间：2015-6-3
 * @描述：分页工具类
 */
public class Paging<T> {
	private int pageTotal = 1;  // 总页数
	private int pageNo = 1; 	// 当前页
	private int pageSize = 10;	// 每页显示个数
	private int countTotal; 	// 总数据量
	private List<T> pageList; 	// 分页列表
	private List<Map<String, Object>> pageListMap; 	// 分页列表

	/*** 分页页码显示字段 ***/
	private int startPageNo; // 起始页码
	private int fenge;
	private int endPageNo; 	 // 结束页码
	private static int initPageTotal = 3; // 初始化页码总数
	public Paging() {

	}

	public Paging(int cursor, int count) {
		this.pageSize = count;
		this.pageNo = cursor;
	}

	// 开始条数
	public int getBeginWith() {
		return pageNo == 1 ? 0 : (pageNo - 1) * pageSize;
	}

	public int getPageTotal() {
		if (countTotal > 0) {
			this.setPageTotal(this.countTotal % this.pageSize == 0 ? this.countTotal
					/ this.pageSize
					: this.countTotal / this.pageSize + 1);
		}
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCountTotal() {
		return countTotal;
	}

	public void setCountTotal(int countTotal) {
		this.countTotal = countTotal;
	}

	public List<T> getPageList() {
		return pageList;
	}

	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}
	
	public List<Map<String, Object>> getPageListMap() {
		return pageListMap;
	}

	public void setPageListMap(List<Map<String, Object>> pageListMap) {
		this.pageListMap = pageListMap;
	}

	/*** 分页页码显示字段 ***/
	public int getStartPageNo() {
		return (3<=pageNo && getPageTotal() > initPageTotal)?getEndPageNo()-2:1;
	}
	
	
	/**分割条数*/
	public int getFenge() {
		if (pageNo <3 && getPageTotal() > initPageTotal) {
			return initPageTotal;
		}
		
		return (pageNo + 1)>getPageTotal()?getPageTotal():pageNo + 1;
	}

	

	public int getEndPageNo() {
		if (pageNo <3 && getPageTotal() > initPageTotal) {
			return initPageTotal;
		}
		if(getPageTotal() < initPageTotal){
			return getPageTotal();
		}
		return (pageNo + 1)>getPageTotal()?getPageTotal():pageNo + 1;
	}
}
