package com.digitalchina.sport.order.api.dao;



import com.digitalchina.sport.order.api.model.Field;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 场地dao
 */
@Mapper
public interface FieldDao {
    List<Field> findAll();


}
