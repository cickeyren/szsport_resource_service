package com.digitalchina.sport.order.api.controller;

import com.digitalchina.common.result.Result;
import com.digitalchina.sport.order.api.model.Classify;
import com.digitalchina.sport.order.api.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目分类control
 */
@RestController
@RequestMapping("/api/classify/")
public class ClassifyController {

    //public static final Logger logger = LoggerFactory.getLogger(FieldController.class);

    @Autowired
    private ClassifyService classifyService;

    /**
     * 获取cid
     * @return
     */
    @RequestMapping(value="getCid",method = RequestMethod.GET)
    @ResponseBody
    public String getCid(@RequestParam(required = false) int pid) {
        Map<String,Object> reqMap=new HashMap<String, Object>();
        //pid是获取父类ID
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

        return Result.ok(reqMap);
    }
}
