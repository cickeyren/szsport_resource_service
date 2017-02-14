package com.digitalchina.sport.resource.api.controller;

import com.digitalchina.common.utils.HttpClientUtil;
import com.digitalchina.sport.resource.api.common.config.Config;
import com.digitalchina.sport.resource.api.service.StadiumService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 场馆control
 */
@RestController
@RequestMapping("/res/api/ticket/")
public class TicketController {

    //public static final Logger logger = LoggerFactory.getLogger(FieldController.class);

    @Autowired
    private Config config;
    @Autowired
    private StadiumService stadiumService;


    /**
     * 获取所有精选场馆
     * @return
     */
    @RequestMapping(value="getYearStrategyTicketModelInfoList.json",method = RequestMethod.GET)
    @ResponseBody
    public Object getYearStrategyTicketModelInfoList( @RequestParam(value = "pageIndex", required = false)String pageIndex,
                                                      @RequestParam(value = "pageSize", required = false) String pageSize) {
        if(null == pageIndex) {
            pageIndex = "";
        }
        if(null == pageSize) {
            pageSize = "";
        }
    return HttpClientUtil.doGet(config.SPORT_MGR_URL + "yearstrategyticket/api/getYearStrategyTicketModelInfoList.json?pageIndex="+pageIndex+"&pageSize="+pageSize,50000,null,"");
    }

}
