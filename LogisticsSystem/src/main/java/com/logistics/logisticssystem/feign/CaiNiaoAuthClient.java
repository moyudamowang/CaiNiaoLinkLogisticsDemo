package com.logistics.logisticssystem.feign;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Api(tags = {"【菜鸟物流科技授权API】"})
@FeignClient(name = "CaiNiaoAuthClient",
		url = "http://lcp.cloud.cainiao.com/api"
)
public interface CaiNiaoAuthClient {


	
	@ApiOperation("获取授权token")
	@GetMapping("/permission/exchangeToken.do")
	String exchangeToken(@RequestParam(name = "accessCode")String accessCode, @RequestParam(name = "isvAppKey")String isvAppKey,@RequestParam(name = "sign")String sign);
}
