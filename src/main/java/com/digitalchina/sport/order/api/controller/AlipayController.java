//package com.digitalchina.sport.order.api.controller;
//
//import com.alipay.api.internal.util.AlipaySignature;
//import com.digitalchina.common.result.Result;
//import com.digitalchina.common.utils.UtilDate;
//import com.digitalchina.sport.order.api.common.config.AlipayConfig;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import com.digitalchina.common.AlipayCore;
//import java.net.URLEncoder;
//import java.util.HashMap;
//import java.util.Map;
//
//
//
///**
// * Created by xuxueyuan on 2017/2/13.
// */
//@RestController
//@RequestMapping("res/api/alipay/")
//public class AlipayController {
//
//    @Autowired
//    private AlipayConfig alipayonfig;
//
//    /**
//     * 支付宝-支付接口
//     */
//    @ResponseBody
//    @RequestMapping(value = "alipay.json",  produces = "text/html;charset=UTF-8",method={RequestMethod.GET})
//    public static String alipay(@RequestParam(value = "body",required = false) String body, @RequestParam(value = "body",required = true)String subject, @RequestParam(value = "body",required = true)String out_trade_no, @RequestParam(value = "total_amount",required = true) String total_amount) throws Exception {
//        //支付宝APP支付–申请支付请求参数
//        //公共参数
//        Map<String, String> publicMap = new HashMap<String, String>();
//        //appId
//        publicMap.put("app_id", AlipayConfig.app_id);
//        //接口名称
//        publicMap.put("method", "alipay.trade.app.pay");
//        //数据格式
//        publicMap.put("format", "json");
//        //编码
//        publicMap.put("charset", "utf-8");
//        //签名类型目前支持RSA2和RSA
//        publicMap.put("sign_type", "RSA");
//        //时间戳
//        publicMap.put("timestamp", UtilDate.getDateFormatter());
//        //调用的接口版本，固定为：1.0
//        publicMap.put("version", "1.0");
//        //付款成功后，回调的服务路径
//        publicMap.put("notify_url", AlipayConfig.service);
//
//        //业务参数
//        Map<String, String> businessParam = new HashMap<String, String>();
//        //商品描述
//        businessParam.put("body", body);
//        //商品的标题/交易标题/订单标题/订单关键字等。
//        businessParam.put("subject", subject);
//        //商户网站唯一订单号
//        businessParam.put("out_trade_no", out_trade_no);
//        //该笔订单允许的最晚付款时间，逾期将关闭交易
//        businessParam.put("timeout_express", "30m");
//        //订单总金额，单位为元，精确到小数点后两位
//        businessParam.put("total_amount", total_amount);
//        //收款支付宝用户ID。 如果该值为空，则默认为商户签约账号对应的支付宝用户ID
//        businessParam.put("seller_id", AlipayConfig.partner);
//        //销售产品码，商家和支付宝签约的产品码，为固定值QUICK_MSECURITY_PAY
//        businessParam.put("product_code", "QUICK_MSECURITY_PAY");
//
//        //对未签名原始字符串进行签名
//        String rsaSign = AlipaySignature.rsaSign(businessParam, AlipayConfig.private_key, "utf-8");
//
//        Map<String, String> map4 = new HashMap<String, String>();
//
//        map4.put("app_id", AlipayConfig.app_id);
//        map4.put("method", "alipay.   trade.app.pay");
//        map4.put("format", "json");
//        map4.put("charset", "utf-8");
//        map4.put("sign_type", "RSA");
//        map4.put("timestamp", URLEncoder.encode(UtilDate.getDateFormatter(),"UTF-8"));
//        map4.put("version", "1.0");
//        map4.put("notify_url",  URLEncoder.encode(AlipayConfig.service,"UTF-8"));
//        //最后对请求字符串的所有一级value（biz_content作为一个value）进行encode，编码格式按请求串中的charset为准，没传charset按UTF-8处理
//        map4.put("biz_content", URLEncoder.encode(businessParam.toString(), "UTF-8"));
//
//        Map par = AlipayCore.paraFilter(map4); //除去数组中的空值和签名参数
//        String json4 = AlipayCore.createLinkString(map4);   //拼接后的字符串
//
//        json4=json4 + "&sign=" + URLEncoder.encode(rsaSign, "UTF-8");
//        return Result.ok(json4.toString());
//    }
//}