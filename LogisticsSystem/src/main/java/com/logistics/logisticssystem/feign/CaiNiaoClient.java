package com.logistics.logisticssystem.feign;


import com.logistics.logisticssystem.dto.cainiao.ResponseBaseDTO;
import com.logistics.logisticssystem.dto.cainiao.res.ResponseEntityDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Map;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PostMapping;


@Api(tags = {"【菜鸟物流科技API】"})
@FeignClient(name = "CaiNiaoClient",
		url ="https://link.cainiao.com/gateway"
)
public interface CaiNiaoClient {

	@ApiOperation("电子面单取号")
	@PostMapping("/link.do")
	String webBillGet(@SpringQueryMap Map<String, String> packParam);


	@ApiOperation("电子面单取消")
	@PostMapping("/link.do")
    ResponseBaseDTO.WayBillCancelResponseEntityDTO webCancelBill(@SpringQueryMap Map<String, String> packParam);

	@ApiOperation("电子面单更新")
	@PostMapping("/link.do")
    ResponseBaseDTO.WayBiliUpdateResponseEntityDTO webUpdateBill(@SpringQueryMap Map<String, String> packParam);

	@ApiOperation("获取标准快递模板")
	@PostMapping("/link.do")
	String getStandardTemplate(@SpringQueryMap Map<String, String> packParam);

	@ApiOperation("获取自定义快递模板")
	@PostMapping("/link.do")
    ResponseBaseDTO.WayBillCustomTemplateResponseEntityDTO getCustomTemplate(@SpringQueryMap Map<String, String> packParam);

	@ApiOperation("物流详情查询")
  @PostMapping("/link.do")
	String getLogisticsDetails(@SpringQueryMap Map<String, String> packParam);

	@ApiOperation("物流详情订阅")
	@PostMapping("/link.do")
    ResponseEntityDTO subscribeLogisticsDetails(@SpringQueryMap Map<String, String> packParam);

	@ApiOperation("获取发货地，CP开通状态，账户的使用情况")
	@PostMapping("/link.do")
	String getWaybillSubscription(@SpringQueryMap Map<String, String> packParam);

	@ApiOperation("生成打印机指令")
	@PostMapping("/link.do")
	String getBluetoothPrint(@SpringQueryMap Map<String, String> packParam);

	@ApiOperation("查询充值记录")
	@PostMapping("/link.do")
	String webPrintRechargeRecord(@SpringQueryMap Map<String, String> packParam);

	@ApiOperation("获取网络打印机验证码")
	@PostMapping("/link.do")
	String getPrinterVerifyCode(@SpringQueryMap Map<String, String> packParam);

	@ApiOperation("获取网络打印机分享码")
	@PostMapping("/link.do")
	String getPrinterShareCode(@SpringQueryMap Map<String, String> packParam);

	@ApiOperation("获取网络打印机状态")
	@PostMapping("/link.do")
	String getPrinterStatus(@SpringQueryMap Map<String, String> packParam);

	@ApiOperation("网络打印机打印(菜鸟模板)")
	@PostMapping("/link.do")
	String netWorkPrinterPrint(@SpringQueryMap Map<String, String> packParam);

	@ApiOperation("网络打印机打印(全平台)")
	@PostMapping("/link.do")
	String netWorkPrinterImagePrint(@SpringQueryMap Map<String, String> packParam);

	@ApiOperation("网络打印机任务状态")
	@PostMapping("/link.do")
	String netWorkPrinterTaskStatusQuery(@SpringQueryMap Map<String, String> packParam);
}
