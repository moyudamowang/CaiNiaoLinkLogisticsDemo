package com.logistics.logisticssystem.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;


@Data
@Component
@ConfigurationProperties(prefix = "logistics.cainiao")
@RefreshScope
public class CaiNiaoProperties {

	private String appKey = "";

	private String appSecret = "";

	private String zyCode = "";


	
	private String AppCode = "";

	
	private String callUrlProd = "https://link.cainiao.com/gateway/link.do";

	
	private String authUrlTemplate = "https://lcp.cloud.cainiao.com/permission/isv/grantpage_tb.do?isvAppKey={}&ext={}&redirectUrl=https://www.{}/v1/basic/auth/callback.do";

	
	private String redirectUrl = "xxxx.com";
	//-------------------------------------------------接口名称------------------------------------------------------------
	
	private String logisticsDetailGet  = "CNTECH_LV_LOGISTICS_DETAIL_GET";

	
	private String logisticsDetailSubscribe ="CNTECH_LV_LOGISTICS_DETAIL_SUBSCRIBE";

	
	private String waybillGet ="TMS_WAYBILL_GET";

	
	private String waybillDISCARD ="TMS_WAYBILL_DISCARD";

	
	private String waybillUpdate = "TMS_WAYBILL_UPDATE";

	
	private String waybillRecycle = "TMS_WAYBILL_CODE_RECYCLE_BATCH";

	
	private String cloudPrintStandardTemplates = "CLOUDPRINT_STANDARD_TEMPLATES";

	
	private String cloudPrintSellerIsvTemplates = "CLOUDPRINT_SELLER_ISV_TEMPLATES";

	
	private String waybillSubscriptionQuery="TMS_WAYBILL_SUBSCRIPTION_QUERY";

	
  private String generatePrinterCommands = "CLOUDPRINT_CMD_RENDER";

	
	private String rechargeRecordQuery = "TMS_WAYBILL_RECHARGE_ORDERS";

	
	private String printerVerificationCode = "CLOUDPRINT_PRINTER_GET_VERIFY_CODE";

	
	private String printerBind = "CLOUDPRINT_PRINTER_BIND";

	
	private String printerStatus ="CLOUDPRINT_PRINTER_STATUS";

	
	private String netWorkPrinterPrint = "CLOUDPRINT_PRINTER_PRINT";

	
	private String netWorkPrinterImagePrint = "CLOUDPRINT_PRINTER_IMAGE_PRINT";

	
	private String printerTaskStatus ="CLOUDPRINT_PRINTER_TASK";
}
