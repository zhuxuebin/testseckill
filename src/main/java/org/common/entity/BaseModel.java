package org.common.entity;



import com.google.common.base.Function;
import com.google.common.collect.Maps;
import org.common.consts.Const;
import org.common.persistence.PageBounds;
import org.common.utils.StringUtil;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * bean基础类
 * ClassName: BaseModel
 *
 * @author penghb <penghongbao@liangyibang.com>
 * @Description: TODO
 * @date 2016-4-26
 */
public class BaseModel<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 删除标记, 可在mapper xml中直接使用, 如: ${DEL_FLAG_NORMAL}, ${DEL_FLAG_DELETE}
     */
    public static final String DEL_FLAG_NORMAL = Const.DEL_FLAG_NORMAL;
    public static final String DEL_FLAG_DELETE = Const.DEL_FLAG_DELETE;

    /**
     * 排序字段
     */
    public static final String ORDER_BY = "orderBy";

    /**
     * 删除标记, 0：正常, 1：删除, 2：审核
     */
    protected String delFlag;

    /**
     * 创建者Id
     */
    protected String createId;

    /**
     * 创建时间
     */
    protected Date createTime;

    /**
     * 最后修改者Id
     */
    protected String modifyId;

    /**
     * 最后修改时间
     */
    protected Date modifyTime;

    /**
     * 分页信息
     */
    protected PageBounds pageBounds;

    /**
     * 其它辅助的字段 , 如: 特殊条件，拼写sql，传递数据参数等 <br>
     * 例： map.put("orderBy", "name desc"); 自定义排序
     */
    protected Map<String, String> other;

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
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }


    public PageBounds getPageBounds() {
        return pageBounds;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }



    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyId() {
        return modifyId;
    }

    public void setModifyId(String modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public void setPageBounds(PageBounds pageBounds) {
        this.pageBounds = pageBounds;
    }

    // --------------- helper methods start --------------- //

    /**
     * 分页
     *
     * @param page
     * @param limit
     */
    public void page(Integer page, Integer limit) {
        setPageBounds(new PageBounds(page, limit));
    }



    /**
     * 过滤特殊字符
     *
     * @param val
     * @return
     */
    private static String filterMapValue(String val) {
        // TODO(xxx)
        return StringUtil.filterStr(val);
    }

    public Map<String, String> getOther() {
        if (other == null) {
            other = Maps.newHashMap();
        }
        return other;
    }

    public void setOther(Map<String, String> other) {
        this.other = filterMapValues(other);
    }


    /**
     * 快速添加(覆盖旧数据)
     *
     * @param key
     * @param value
     */
    public void putOtherValue(String key, String value) {
        value = filterMapValue(value);
        if ("null".equals(value)) {
            value = null;
        }
        other = getOther();
        other.put(key, value);
    }

    /**
     * 快速添加(同key连接在旧数据后), 拼接新旧数据
     *
     * @param key
     * @param value
     */
    public void putOtherValueJoin(String key, String value) {
        value = filterMapValue(value);
        if (value != null && !"null".equals(value)) {
            other = getOther();
            if (other.get(key) != null) {
                value = other.get(key) + value;
            }
            other.put(key, value);
        }
    }



    /**
     * 过滤特殊字符
     *
     * @param map
     * @return
     */
    private static Map<String, String> filterMapValues(Map<String, String> map) {
        Function<String, String> filter = new Function<String, String>() {
            public String apply(String value) {
                return StringUtil.filterStr(value);
            }
        };
        return Maps.transformValues(map, filter);
    }

    // --------------- helper methods end --------------- //
}
