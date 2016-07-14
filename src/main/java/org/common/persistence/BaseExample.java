package org.common.persistence;



import org.common.consts.Const;
import org.common.utils.StringUtil;

import java.io.Serializable;

public class BaseExample implements Serializable {
    public static final long serialVersionUID = 1L;

    public static final String DEL_FLAG_NORMAL = Const.DEL_FLAG_NORMAL;
    public static final String DEL_FLAG_DELETE = Const.DEL_FLAG_DELETE;

    /** 是否相异 */
    protected boolean distinct;

    /** 排序字段 */
    protected String orderByClause;

    /** 分页信息 */
    protected PageBounds pageBounds;

    public final static int NO_PAGE_NUM = 1;
    public final static int NO_PAGE_SIZE = Integer.MAX_VALUE;
    public final static int NO_PAGE_TOTAL = -1;

    /** 页号 */
    protected int pageNum = NO_PAGE_NUM;
    /** 分页大小 */
    protected int pageSize = NO_PAGE_SIZE;
    /**
     * 排序字段
     */
    protected String sort;

    /**
     * 排序方式 asc desc
     */
    protected String dir;



    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
        if(!StringUtil.isBlank(dir)) {
            this.orderByClause = sort + " " + dir;
        }
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
        if(!StringUtil.isBlank(sort)) {
            this.orderByClause = sort + " " + dir;
        }
    }

    public BaseExample() {

    }

    public BaseExample(Integer page, Integer limit, String sort, String dir) {
        setSort(sort);
        setDir(dir);
        setPageBounds(new PageBounds(page, limit));
    }


    public void clear() {
        this.orderByClause = null;
        this.distinct = false;
        this.pageBounds = null;
    }


    public BaseExample pageBy(Integer pageNum, Integer pageSize) {
        if (pageNum == null) {
            pageNum = 0;
        }
        if (pageSize == null) {
            pageSize = 20;
        }
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        return this;
    }



    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setPageBounds(PageBounds pageBounds) {
        this.pageBounds = pageBounds;
    }

    public PageBounds getPageBounds() {
        return pageBounds;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
}
