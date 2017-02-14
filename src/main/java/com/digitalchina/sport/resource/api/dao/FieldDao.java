package com.digitalchina.sport.resource.api.dao;



import com.digitalchina.sport.resource.api.model.Field;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 场地dao
 */
@Mapper
public interface FieldDao {
    List<Field> findAll();


}
