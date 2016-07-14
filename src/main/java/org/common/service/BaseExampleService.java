package org.common.service;



import org.common.entity.BaseModel;
import org.common.persistence.BaseExample;

import java.io.Serializable;
import java.util.List;

public interface BaseExampleService<T extends BaseModel<T>, PK extends Serializable, E extends BaseExample> {
  /**
   * 主键id查询
   *
   * @param id
   * @return
   */
  T findById(PK id);

  /**
   * 高级查询
   *
   * @param example
   * @return
   */
  List<T> findByExample(E example);

  /**
   * 高级查询
   *
   * @param example
   * @return
   */
  T findOneByExample(E example);

  /**
   * 插入对象
   *
   * @param record 对象
   */
  int insert(T record);

  /**
   * 更新对象
   *
   * @param record 对象
   * @return
   */
  int update(T record);

  /**
   * 更新对象
   *
   * @param T
   * @return
   */
  int updateByExample(T record, E example);

  /**
   * 删除对象
   *
   * @param PK
   * @return
   */
  int delete(PK id);

  /**
   * 删除对象
   *
   * @param T
   * @return
   */
  int deleteByExample(T record, E example);

  /**
   * 查询数量
   * @param example
   * @return
   */
  int countByExample(E example);
}
