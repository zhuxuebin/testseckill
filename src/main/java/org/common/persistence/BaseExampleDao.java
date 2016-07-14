package org.common.persistence;

import com.liangyibang.common.domain.BaseModel;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * Base dao using mybatis example.
 * ClassName: BaseExampleDao
 * @Description: TODO
 * @author penghb <penghongbao@liangyibang.com>
 * @date 2016-4-26
 * @param <T> model
 * @param <PK> primary key
 * @param <E> mybatis example
 */
public interface BaseExampleDao<T extends BaseModel<T>, PK extends Serializable, E extends BaseExample> {
  int countByExample(E example);

  int deleteByExample(E example);

  int deleteByPrimaryKey(PK id);

  int insert(T record);

  int insertSelective(T record);

  List<T> selectByExample(E example);

  T selectByPrimaryKey(PK id);

  int updateByExampleSelective(@Param("record") T record, @Param("example") E example);

  int updateByExample(@Param("record") T record, @Param("example") E example);

  int updateByPrimaryKeySelective(T record);

  int updateByPrimaryKey(T record);
}
