package com.digitalchina.sport.order.api.dao;



import com.digitalchina.sport.order.api.model.Classify;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 分类dao
 */
@Mapper
public interface ClassifyDao {
    /**
     * 根据父类id获取所有子类
     * @param pid
     * @return
     */
    List<Classify> getCategoryByPid(int pid);

    /**
     * 根据父类id获取个数
     * @param pid
     * @return
     */
    int getCountByPid(int pid);

    /**
     * 获取子类的详情
     * @param cid
     * @return
     */
    Classify getCategoryByCid(int cid);
}
