package com.logistics.logisticssystem.controller;


import com.logistics.logisticssystem.dto.cainiao.ResponseBaseDTO;
import com.logistics.logisticssystem.dto.cainiao.req.*;
import com.logistics.logisticssystem.dto.cainiao.res.*;
import com.logistics.logisticssystem.dto.cainiao.res.ResponseEntityDTO;
import com.logistics.logisticssystem.dto.cainiao.res.ResponseResultEntityDTO;
import com.logistics.logisticssystem.service.CaiNiaoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;


@RequestMapping(value = "/logistics/cai-niao")
@RestController
public class CaiNiaoController {

	@Resource
	private CaiNiaoService caiNiaoService;

	@PostMapping("/getLogisticsDetails")
	@ApiOperation("查询物流详情")
	public ResponseBaseDTO.LogisticsInterfaceResponseEntityDTO getLogisticsDetails(@RequestBody @Valid ReqLogisticsInterfaceEntityDTO queryDTO) {
		return caiNiaoService.getLogisticsDetails(queryDTO);
	}

	@ApiOperation("订阅物流详情")
	@PostMapping("/subscribeLogisticsDetails")
	public ResponseResultEntityDTO subscribeLogisticsDetails(@RequestBody @Valid ReqLogisticsInterfaceEntityDTO queryDTO) {
		return caiNiaoService.subscribeLogisticsDetails(queryDTO);
	}

	@ApiOperation("电子面单取号")
	@PostMapping("/webBillGet")
	public ResponseBaseDTO.WayBillGetResponseEntityDTO webBillGet(@RequestBody @Valid ReqWebBillGetEntityDTO queryDTO) {
		return caiNiaoService.webBillGet(queryDTO);
	}

	@ApiOperation("电子面单取消")
	@PostMapping("/webCancelBill")
	public ResponseBaseDTO.WayBillCancelResponseEntityDTO webCancelBill(@RequestBody @Valid ReqCancelWaybillEntityDTO queryDTO) {
		return caiNiaoService.webCancelBill(queryDTO);
	}

	@ApiOperation("电子面单更新")
	@PostMapping("/webUpdateBill")
	public ResponseBaseDTO.WayBiliUpdateResponseEntityDTO webUpdateBill(@RequestBody @Valid ReqUpdateWaybillEntityDTO queryDTO) {
		return caiNiaoService.webUpdateBill(queryDTO);
	}

	@ApiOperation("获取标准快递模板")
	@PostMapping("/getStandardTemplate")
	public ResponseBaseDTO.WayBillTemplateResponseEntityDTO getStandardTemplate(@RequestBody @Valid ReqGetStandardTemplateEntityDTO queryDTO) {
		return caiNiaoService.getStandardTemplate(queryDTO);
	}

	@ApiOperation("获取自定义快递模板")
	@PostMapping("/getCustomTemplate")
	public ResponseBaseDTO.WayBillCustomTemplateResponseEntityDTO getCustomTemplate(@RequestBody @Valid ReqGetCustomizeTemplateEntityDTO queryDTO) {
		return caiNiaoService.getCustomTemplate(queryDTO);
	}

	@ApiOperation("获取发货地，CP开通状态，账户的使用情况")
	@PostMapping("/getWaybillAccount")
	public ResponseBaseDTO.WaybillSubscriptionResponseEntityDTO queryWaybillSubscription(@RequestBody @Valid ReqWaybillSubscriptionEntityDTO queryDTO) {
		return caiNiaoService.queryWaybillSubscription(queryDTO);
	}

	@ApiOperation("蓝牙云打印接口 生成打印机指令")
	@PostMapping("/bluetoothPrint")
	public ResponseBaseDTO.BlueToothCloudPrintResponseEntityDTO bluetoothPrint(@RequestBody @Valid ReqBlueToothCloudPrintEntityDTO queryDTO) {
		return caiNiaoService.bluetoothPrint(queryDTO);
	}

	@ApiOperation("电子面单充值记录查询")
	@PostMapping("/webPrintRechargeRecord")
	public ResponseBaseDTO.RechargeRecordResponseEntityDTO webPrintRechargeRecord(@RequestBody @Valid ReqRechargeRecordEntityDTO queryDTO) {
		return caiNiaoService.webPrintRechargeRecord(queryDTO);
	}

	@ApiOperation("创建三方授权链接")
	@PostMapping("/getThirdAuthUrl")
	public ResThirdAuthLinkEntityDTO getThirdAuthUrl(@RequestBody @Valid String extDetailDTO) {
		return caiNiaoService.getThirdAuthUrl(extDetailDTO);
	}

	@ApiOperation("获取菜鸟token")
	@PostMapping("/getAuthToken")
	public ResAccessTokenGetEntityDTO getAuthToken(@RequestBody @Valid ReqAccessTokenGetEntityDTO queryDTO) {
		return caiNiaoService.getAuthToken(queryDTO);
	}

	@ApiOperation("获取网络打印机验证码")
	@PostMapping("/getPrinterVerifyCode")
	public ResponseBaseDTO.PrinterVerifyCodeResponseEntityDTO getPrinterVerifyCode(@RequestBody @Valid ReqPrinterVerifyCodeEntityDTO queryDTO) {
		return caiNiaoService.getPrinterVerifyCode(queryDTO);
	}

	@ApiOperation("获取网络打印机分享码")
	@PostMapping("/getPrinterShareCode")
	public ResponseBaseDTO.PrinterShareCodeResponseEntityDTO getPrinterShareCode(@RequestBody @Valid ReqPrinterShareCodeEntityDTO queryDTO) {
		return caiNiaoService.getPrinterShareCode(queryDTO);
	}

	@ApiOperation("获取打印机状态")
	@PostMapping("/getPrinterStatus")
	public ResponseBaseDTO.PrinterStatusResponseEntityDTO getPrinterStatus(@RequestBody @Valid ReqPrinterStatusEntityDTO queryDTO) {
		return caiNiaoService.getPrinterStatus(queryDTO);
	}

	@ApiOperation("网络打印机打印")
	@PostMapping("/netWorkPrinterPrint")
	public ResponseEntityDTO netWorkPrinterPrint(@RequestBody @Valid ReqNetWorkPrinterPrintEntityDTO queryDTO) {
		return caiNiaoService.netWorkPrinterPrint(queryDTO);
	}

	@ApiOperation("网络打印机图片打印")
	@PostMapping("/netWorkPrinterImagePrint")
	public ResponseBaseDTO.PrinterPicturePrintResponseEntityDTO netWorkPrinterImagePrint(@RequestBody @Valid ReqNetWorkPrinterImagePrintEntityDTO queryDTO) {
		return caiNiaoService.netWorkPrinterImagePrint(queryDTO);
	}

	@ApiOperation("网络打印机任务状态查询")
	@PostMapping("/netWorkPrinterTaskStatusQuery")
	public ResponseBaseDTO.PrinterTaskStatusResponseEntityDTO netWorkPrinterTaskStatusQuery(@RequestBody @Valid ReqNetWorkPrinterTaskStatusEntityDTO queryDTO) {
		return caiNiaoService.netWorkPrinterTaskStatusQuery(queryDTO);
	}


}
