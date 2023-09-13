package com.logistics.logisticssystem.service;


import com.logistics.logisticssystem.dto.cainiao.ResponseBaseDTO;
import com.logistics.logisticssystem.dto.cainiao.req.*;
import com.logistics.logisticssystem.dto.cainiao.res.*;
import com.logistics.logisticssystem.dto.cainiao.res.ResponseEntityDTO;
import com.logistics.logisticssystem.dto.cainiao.res.ResponseResultEntityDTO;


public interface CaiNiaoService {

	
	ResponseBaseDTO.LogisticsInterfaceResponseEntityDTO getLogisticsDetails(ReqLogisticsInterfaceEntityDTO queryDTO);

	
	ResponseResultEntityDTO subscribeLogisticsDetails(ReqLogisticsInterfaceEntityDTO queryDTO);

	
	ResponseBaseDTO.WayBillGetResponseEntityDTO webBillGet(ReqWebBillGetEntityDTO queryDTO);

	
	ResponseBaseDTO.WayBillCancelResponseEntityDTO webCancelBill(ReqCancelWaybillEntityDTO queryDTO);

	
	ResponseBaseDTO.WayBiliUpdateResponseEntityDTO webUpdateBill(ReqUpdateWaybillEntityDTO queryDTO);

	
	ResponseBaseDTO.WayBillTemplateResponseEntityDTO getStandardTemplate(ReqGetStandardTemplateEntityDTO queryDTO);

	
	ResponseBaseDTO.WayBillCustomTemplateResponseEntityDTO getCustomTemplate(ReqGetCustomizeTemplateEntityDTO queryDTO);

	
	ResponseBaseDTO.WaybillSubscriptionResponseEntityDTO queryWaybillSubscription(ReqWaybillSubscriptionEntityDTO queryDTO);

	
	ResThirdAuthLinkEntityDTO getThirdAuthUrl(String extDetailDTO);

	
	ResAccessTokenGetEntityDTO getAuthToken(ReqAccessTokenGetEntityDTO queryDTO);

	
	ResponseBaseDTO.BlueToothCloudPrintResponseEntityDTO bluetoothPrint(ReqBlueToothCloudPrintEntityDTO queryDTO);

	
	ResponseBaseDTO.RechargeRecordResponseEntityDTO webPrintRechargeRecord(ReqRechargeRecordEntityDTO queryDTO);

	ResponseBaseDTO.PrinterVerifyCodeResponseEntityDTO getPrinterVerifyCode(ReqPrinterVerifyCodeEntityDTO queryDTO);

	ResponseBaseDTO.PrinterShareCodeResponseEntityDTO getPrinterShareCode(ReqPrinterShareCodeEntityDTO queryDTO);

	ResponseBaseDTO.PrinterStatusResponseEntityDTO getPrinterStatus(ReqPrinterStatusEntityDTO queryDTO);

	ResponseEntityDTO netWorkPrinterPrint(ReqNetWorkPrinterPrintEntityDTO queryDTO);

	ResponseBaseDTO.PrinterPicturePrintResponseEntityDTO netWorkPrinterImagePrint(ReqNetWorkPrinterImagePrintEntityDTO queryDTO);

	ResponseBaseDTO.PrinterTaskStatusResponseEntityDTO netWorkPrinterTaskStatusQuery(ReqNetWorkPrinterTaskStatusEntityDTO queryDTO);
}
