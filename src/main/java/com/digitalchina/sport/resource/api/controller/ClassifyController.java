package com.digitalchina.sport.resource.api.controller;

import com.digitalchina.common.RtnData;
import com.digitalchina.sport.resource.api.model.Classify;
import com.digitalchina.sport.resource.api.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目分类control
 */
@RestController
@RequestMapping("/res/api/classify/")
public class ClassifyController {

    //public static final Logger logger = LoggerFactory.getLogger(FieldController.class);

    @Autowired
    private ClassifyService classifyService;

    /**
     * 获取cid
     * @return
     */
    @RequestMapping(value="getCid.json",method = RequestMethod.GET)
    @ResponseBody
    public Object getCid(@RequestParam(required = false) int pid) {
        Map<String,Object> reqMap=new HashMap<String, Object>();
        //pid是获取父类ID

        try {
            int count = classifyService.getCountByPid(pid);
            if (count >0){//count>0，说明父类下面有子类
                List<Classify> classifys = classifyService.getCategoryByPid(pid);//获得改父类下面的所有子类
                Classify classify = classifyService.getCategoryByCid(pid);
                reqMap.put("pid",classify.getCid());
                reqMap.put("pname",classify.getCategoryName());
                reqMap.put("classifyList",classifys);
            }else{//相反的，说明父类没有子类，就是最后一级目录
                Classify classify = classifyService.getCategoryByCid(pid);
                Classify classify2 = classifyService.getCategoryByCid(classify.getPid());
                reqMap.put("pname",classify2.getCategoryName());
                reqMap.put("cid",classify.getCid());
                reqMap.put("cname",classify.getCategoryName());
            }
            return RtnData.ok(reqMap);
        } catch (Exception e) {
            e.printStackTrace();
            return RtnData.fail("查询失败");
        }
    }

    /**
     * 根据主场馆查询所有子场馆类别
     * @return
     */
    @RequestMapping(value="getAllClassifyByParentId.json",method = RequestMethod.GET)
    @ResponseBody
    public Object getCid(@RequestParam(required = false) String parentId) {
        Map<String,Object> reqMap=new HashMap<String, Object>();
        try {
            List<Classify> classifys = classifyService.getAllClassifyByParentId(parentId);
            reqMap.put("classifyList",classifys);
            return RtnData.ok(reqMap);
        } catch (Exception e) {
            e.printStackTrace();
            return RtnData.fail("查询失败!");
        }
    }
}
