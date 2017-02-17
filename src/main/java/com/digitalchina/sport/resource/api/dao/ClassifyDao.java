package com.digitalchina.sport.resource.api.dao;



import com.digitalchina.sport.resource.api.model.Classify;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据主场馆查询所有子场馆类别
     * @param parentId
     * @return
     */
    List<Classify> getAllClassifyByParentId(String parentId);
}
