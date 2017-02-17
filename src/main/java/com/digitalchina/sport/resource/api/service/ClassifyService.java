package com.digitalchina.sport.resource.api.service;


import com.digitalchina.sport.resource.api.dao.ClassifyDao;
import com.digitalchina.sport.resource.api.model.Classify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;


/**
 *
 */
@Service
public class ClassifyService {

    @Autowired
    private ClassifyDao classifyDao;

    public List<Classify> getCategoryByPid(int pid) throws Exception {
        return this.classifyDao.getCategoryByPid(pid);
    }
    public int getCountByPid(int pid) throws Exception{
        int count = this.classifyDao.getCountByPid(pid);
        return count;
    }
    public Classify getCategoryByCid(int cid) throws Exception{
        return this.classifyDao.getCategoryByCid(cid);
    }
    public List<Classify> getAllClassifyByParentId(String parentId) throws Exception{
        return this.classifyDao.getAllClassifyByParentId(parentId);
    }
}
