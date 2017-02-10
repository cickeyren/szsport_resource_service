package com.digitalchina.sport.order.api.dao;



import com.digitalchina.sport.order.api.model.Classify;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 场地dao
 */
@Mapper
public interface ClassifyDao {
    List<Classify> getCategoryByPid(int pid);
    int getCountByPid(int pid);
    Classify getCategoryByCid(int cid);
}
