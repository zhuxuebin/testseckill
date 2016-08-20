package org.common.service;

import com.google.common.collect.Iterables;
import org.common.entity.BaseModel;
import org.common.persistence.BaseExample;
import org.common.persistence.BaseExampleDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;

public abstract class BaseExampleServiceImpl<T extends BaseModel<T>, PK extends Serializable, E extends BaseExample>
    implements BaseExampleService<T, PK, E> {

  protected final Logger logger = LoggerFactory.getLogger(getClass());

  protected abstract BaseExampleDao<T, PK, E> getDao();

  @Override
  public T findById(PK id) {
    return getDao().selectByPrimaryKey(id);
  }

  @Override
  public List<T> findByExample(E example) {
    return getDao().selectByExample(example);
  }

  @Override
  public T findOneByExample(E example) {
    List<T> list = findByExample(example);
    if (list != null) {
      return Iterables.getFirst(list, null);
    }
    return null;
  }

  @Override
  public int insert(T record) {
    return getDao().insertSelective(record);
  }

  @Override
  public int update(T record) {
    return getDao().updateByPrimaryKeySelective(record);
  }

  @Override
  public int updateByExample(T record, E example) {
    return getDao().updateByExampleSelective(record, example);
  }

  @Override
  public int delete(PK id) {
    return getDao().deleteByPrimaryKey(id);
  }

  @Override
  public int deleteByExample(T record, E example) {
    return getDao().deleteByExample(example);
  }

  @Override
  public int countByExample(E example) {
    return getDao().countByExample(example);
  }
}
