package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Xuery on 2016/6/19.
 */
public interface SeckillDao {
    /**
     * �����
     * @param seckillId
     * @param killTime
     * @return ���Ӱ������>1.��ʾ���µļ�¼����
     * */
    int reduceNumber(@Param("seckillId")long seckillId,@Param("killTime")Date killTime);

    /**
     *����id��ѯ��ɱ����
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * ����ƫ������ѯ��ɱ��Ʒ�б�
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offset")int offset,@Param("limit")int limit);

    /**
     * 使用存储过程进行秒杀
     * @param paramMap
     */
    void killByProcedure(Map<String,Object> paramMap);
}
