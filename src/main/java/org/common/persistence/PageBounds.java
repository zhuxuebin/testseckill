package org.common.persistence;

import org.apache.ibatis.session.RowBounds;

import java.io.Serializable;
import java.util.List;

/**
 * 分页参数及查询结果封装. 注意所有序号从1开始
 * ClassName: PageBounds
 * @Description: TODO
 * @author penghb <penghongbao@liangyibang.com>
 * @date 2016-4-26
 */
public class PageBounds extends RowBounds implements Serializable{
  private static final long serialVersionUID = 1L;
  public final static int NO_PAGE_NUM = 1;
  public final static int NO_PAGE_SIZE = Integer.MAX_VALUE;
  public final static int NO_PAGE_TOTAL = -1;

  /** 页号 */
  protected int pageNum = NO_PAGE_NUM;
  /** 分页大小 */
  protected int pageSize = NO_PAGE_SIZE;
  /** 总条数 */
  protected int total = NO_PAGE_TOTAL;
  /** 总页数 */
  protected int pages = NO_PAGE_TOTAL;
  /** 查询结果 */
  protected List<?> list;

  /** 第一页 */
  protected int firstPage;
  /** 前一页 */
  protected int prePage;
  /** 下一页 */
  protected int nextPage;
  /** 最后一页 */
  protected int lastPage;

  /** 是否为第一页 */
  protected boolean isFirstPage = false;
  /** 是否为最后一页 */
  protected boolean isLastPage = false;
  /** 是否有前一页 */
  protected boolean hasPreviousPage = false;
  /** 是否有下一页 */
  protected boolean hasNextPage = false;
  /** 导航页码数 */
  protected int navigatePages;
  /** 所有导航页号 */
  protected int[] navigatepageNums;

  /** 查询总条数 */
  protected boolean isTotalCountEnabled = true;

  public PageBounds() {
    this(NO_PAGE_NUM, NO_PAGE_SIZE);
  }

  /**
   * @param pageNum 页号
   * @param pageSize 每页数目
   */
  public PageBounds(int pageNum, int pageSize) {
    this.pageNum = pageNum;
    this.pageSize = pageSize;
    this.isTotalCountEnabled = true;
  }
  public PageBounds(int pageNum, int pageSize,int start) {
	  this.pageNum = (start/pageSize)+1;
	  this.pageSize = pageSize;
	  this.isTotalCountEnabled = true;
  }

  @Override
  public int getOffset() {
    if (pageNum >= 1) {
      return (pageNum - 1) * pageSize;
    }
    return 0;
  }

  @Override
  public int getLimit() {
    return pageSize;
  }

  public boolean isTotalCountEnabled() {
    return isTotalCountEnabled;
  }

  public void setTotalCountEnabled(boolean isTotalCountEnabled) {
    this.isTotalCountEnabled = isTotalCountEnabled;
  }

  public int getPageNum() {
    return pageNum;
  }

  /**
   * 根据page和limit计算当前页第一条记录在总结果集中的位置,序号从1开始.
   */
  public int getFirst() {
    return ((pageNum - 1) * pageSize) + 1;
  }

  /**
   * 根据page和limit计算当前页第一条记录在总结果集中的位置,序号从1开始.
   */
  public int getLast() {
    return ((pageNum - 1) * pageSize) + pageSize;
  }

  /**
   * 取得页内的记录列表.
   */
  public List<?> getList() {
    return list;
  }

  /**
   * 设置页内的记录列表.
   */
  public void setList(List<?> list) {
    this.list = list;
  }

  /**
   * 取得总记录数, 默认值为 {@value #NO_PAGE_TOTAL}
   */
  public int getTotal() {
    return total;
  }

  /**
   * 设置总记录数.
   */
  public void setTotal(int total) {
    this.total = total;
    this.pages = this.getPages();
  }

  /**
   * 根据pageSize与totalCount计算总页数, 默认值为 {@value #NO_PAGE_TOTAL}.
   */
  public int getPages() {
    if (total < 0) {
      return NO_PAGE_TOTAL;
    }
    int pages = total / pageSize;
    return total % pageSize > 0 ? ++pages : pages;
  }

  public void setPages(int pages) {
    this.pages = pages;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public void setPageNum(int pageNum) {
    this.pageNum = pageNum;
  }
  
  
}
