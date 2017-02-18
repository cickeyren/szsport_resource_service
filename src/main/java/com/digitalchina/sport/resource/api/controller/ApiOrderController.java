//package com.digitalchina.sport.resource.api.controller;
//
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * Created by xiaoning.sun on 2016/12/5.
// */
//@RestController
//public class ApiOrderController {
//
////    @Autowired
////    private ApiOrderService apiOrderService;
////
////    public static final Logger logger = LoggerFactory.getLogger(ApiOrderController.class);
////
////	/**
////	 * 获取订单列表
////	 *
////	 * @return
////	 */
////	@ApiOperation(value = "获取订单列表",
////			httpMethod = "GET",
////			produces = "application/json")
////	@ApiImplicitParams({
////			@ApiImplicitParam(name = "id",  value = "订单ID",  dataType = "String", defaultValue = "1", paramType = "query")
////	})
////	@RequestMapping(value = "/order/getOrderListByPK.do", method = RequestMethod.GET)
////	public RtnData<ApiOrder> getOrderListByPK(@RequestParam(required = true) Integer id) {
////		ApiOrder result =apiOrderService.getOrderInfoByPK(id);
////		return RtnData.ok(result);
////	}
//
//}
