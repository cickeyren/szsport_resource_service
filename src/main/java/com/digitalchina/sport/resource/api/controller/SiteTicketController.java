package com.digitalchina.sport.resource.api.controller;

import com.digitalchina.common.RtnData;
import com.digitalchina.sport.resource.api.service.SiteTicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:wangw
 * @Description:场地票管理
 * @Date:Created on 2017/3/16.
 */
@RestController
@RequestMapping("/res/api/siteTicket/")
public class SiteTicketController {
    private static final Logger logger = LoggerFactory.getLogger(SiteTicketController.class);

    @Autowired
    private SiteTicketService siteTicketService;

    /**
     * 获取下单需要的场地票信息
     * @param ticketId
     * @return
     */
    @RequestMapping(value = "/getSiteTicketInfoToOrder.json")
    @ResponseBody
    public RtnData getSiteTicketInfoToOrder(@RequestParam(required = true) String ticketId){
        try {
            Map<String,Object> paramMap = new HashMap<String,Object>();
            paramMap.put("ticketId", ticketId);
            return RtnData.ok(siteTicketService.getSiteTicketInfoToOrder(paramMap));
        }catch (Exception e){
            e.printStackTrace();
            logger.error("========根据场地票ID获取场地票详情失败=========",e);
        }
        return RtnData.fail("根据场地票ID获取场地票详情失败");
    }

    /**
     * 根据场馆获取生效的场地票列表信息
     * @param mainStadiumId
     * @param classify
     * @return
     */
    @RequestMapping(value = "getValidSiteTicketList.json", method = RequestMethod.GET)
    @ResponseBody
    public RtnData getValidSiteTicketList(@RequestParam(required = true) String mainStadiumId,
                                          @RequestParam(required = false) String classify){
        try {
            Map<String,Object> paramMap = new HashMap<String,Object>();
            paramMap.put("mainStadiumId", mainStadiumId);
            paramMap.put("classify", classify);
            Map<String,Object> rtnMap = new HashMap<String,Object>();
            rtnMap.put("siteTicketList",siteTicketService.getValidSiteTicketList(paramMap));
            return RtnData.ok(rtnMap);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("========根据场地获取场地票列表信息失败=========",e);
        }
        return RtnData.fail("根据场地获取场地票列表信息失败");
    }

    /**
     * 获取场地票下场地信息
     * @param ticketId
     * @return
     */
    @RequestMapping(value = "getFieldOrderInfoList.json", method = RequestMethod.GET)
    @ResponseBody
    public RtnData getFieldOrderInfoList(String ticketId, Date searchTime){
        try {
            return RtnData.ok(siteTicketService.getSiteInfoByTicket(ticketId, searchTime));
        }catch (Exception e){
            e.printStackTrace();
            logger.error("========根据场地票ID获取场地票详情失败=========",e);
        }
        return RtnData.fail("根据场地票ID获取场地票详情失败");
    }
}
