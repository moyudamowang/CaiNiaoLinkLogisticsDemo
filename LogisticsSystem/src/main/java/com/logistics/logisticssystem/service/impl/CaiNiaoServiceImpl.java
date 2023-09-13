package com.logistics.logisticssystem.service.impl;

import cn.hutool.core.util.StrUtil;
import com.logistics.logisticssystem.common.util.JsonUtil;
import com.logistics.logisticssystem.common.util.MD5Utils;
import com.logistics.logisticssystem.dto.cainiao.ResponseBaseDTO;
import com.logistics.logisticssystem.dto.cainiao.req.*;
import com.logistics.logisticssystem.dto.cainiao.res.*;
import com.logistics.logisticssystem.dto.cainiao.res.ResAccessTokenGetEntityDTO;
import com.logistics.logisticssystem.dto.cainiao.res.ResponseEntityDTO;
import com.logistics.logisticssystem.feign.CaiNiaoAuthClient;
import com.logistics.logisticssystem.feign.CaiNiaoClient;
import com.logistics.logisticssystem.properties.CaiNiaoProperties;
import com.logistics.logisticssystem.service.CaiNiaoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Service
@Slf4j
public class CaiNiaoServiceImpl implements CaiNiaoService {

	@Resource
	CaiNiaoProperties caiNiaoProperties;

	@Resource
	CaiNiaoClient caiNiaoClient;

	@Resource
	CaiNiaoAuthClient caiNiaoAuthClient;

	@Override
	public ResponseBaseDTO.LogisticsInterfaceResponseEntityDTO getLogisticsDetails(ReqLogisticsInterfaceEntityDTO queryDTO) {
		Map<String, Object> paramMap = new HashMap<>();
		queryDTO.setAppCode(caiNiaoProperties.getAppCode());
		paramMap.put("arg0", queryDTO);
		String response = caiNiaoClient.getLogisticsDetails(
				packParam(paramMap, caiNiaoProperties.getLogisticsDetailGet(),null));
		if(StrUtil.isBlank(response)){
			return null;
		}
		ResponseEntityDTO responseDTO = JsonUtil.toObject(response, ResponseEntityDTO.class);
		if (responseDTO != null && responseDTO.getSuccess()) {
			ResponseResultEntityDTO resultDTO = responseDTO.getResult();
			if (resultDTO != null) {
				ResponseBaseDTO.LogisticsInterfaceResponseEntityDTO result = JsonUtil.toObject(resultDTO.getData(),
						ResponseBaseDTO.LogisticsInterfaceResponseEntityDTO.class);
				Optional.ofNullable(result).ifPresent(reusult -> {
					reusult.setLastUpdateTime(
							LocalDateTime.parse(reusult.getLastTime()));
				});
				return result;
			}
		}
		return null;
	}

	@Override
	public ResponseResultEntityDTO subscribeLogisticsDetails(ReqLogisticsInterfaceEntityDTO queryDTO) {
		Map<String, Object> paramMap = new HashMap<>();
		queryDTO.setAppCode(caiNiaoProperties.getAppCode());
		paramMap.put("arg0", queryDTO);
		ResponseEntityDTO responseDTO = caiNiaoClient.subscribeLogisticsDetails(
				packParam(paramMap, caiNiaoProperties.getLogisticsDetailSubscribe(),null));
		if (responseDTO != null && responseDTO.getSuccess()) {
//			ResponseResultEntityDTO resultDTO = SfGsonBuilder.create()
//					.fromJson(responseDTO.getResult(), ResponseResultEntityDTO.class);
//			return resultDTO;
			return null;
		}
		return null;
	}

	@Override
	public ResponseBaseDTO.WayBillGetResponseEntityDTO webBillGet(ReqWebBillGetEntityDTO queryDTO) {
		String webBillGet = caiNiaoClient.webBillGet(packParam(queryDTO, caiNiaoProperties.getWaybillGet(),queryDTO.getAuthToken()));
		if (StrUtil.isBlank(webBillGet)){
			return new ResponseBaseDTO.WayBillGetResponseEntityDTO();
		}
		return JsonUtil.toObject(webBillGet, ResponseBaseDTO.WayBillGetResponseEntityDTO.class);
	}

	@Override
	public ResponseBaseDTO.WayBillCancelResponseEntityDTO webCancelBill(ReqCancelWaybillEntityDTO queryDTO) {
		return caiNiaoClient.webCancelBill(packParam(queryDTO, caiNiaoProperties.getWaybillDISCARD(),queryDTO.getAuthToken()));
	}

	@Override
	public ResponseBaseDTO.WayBiliUpdateResponseEntityDTO webUpdateBill(ReqUpdateWaybillEntityDTO queryDTO) {
		return caiNiaoClient.webUpdateBill(packParam(queryDTO, caiNiaoProperties.getWaybillUpdate(),queryDTO.getAuthToken()));
	}

	@Override
	public ResponseBaseDTO.WayBillTemplateResponseEntityDTO getStandardTemplate(ReqGetStandardTemplateEntityDTO queryDTO) {
		String standardTemplate = caiNiaoClient.getStandardTemplate(
				packParam(queryDTO, caiNiaoProperties.getCloudPrintStandardTemplates(),queryDTO.getAuthToken()));
		if (StrUtil.isBlank(standardTemplate)){
			return null;
		}
		return JsonUtil.toObject(standardTemplate, ResponseBaseDTO.WayBillTemplateResponseEntityDTO.class);
	}

	@Override
	public ResponseBaseDTO.WayBillCustomTemplateResponseEntityDTO getCustomTemplate(ReqGetCustomizeTemplateEntityDTO queryDTO) {
		return caiNiaoClient.getCustomTemplate(packParam(queryDTO, caiNiaoProperties.getCloudPrintSellerIsvTemplates(),queryDTO.getAuthToken()));
	}

	@Override
	public ResponseBaseDTO.WaybillSubscriptionResponseEntityDTO queryWaybillSubscription(ReqWaybillSubscriptionEntityDTO queryDTO) {
		String waybillSubscription = caiNiaoClient.getWaybillSubscription(
				packParam(queryDTO, caiNiaoProperties.getWaybillSubscriptionQuery(),queryDTO.getAuthToken()));
		ResponseBaseDTO.WaybillSubscriptionResponseEntityDTO waybillSubscriptionResponseDTO = JsonUtil.toObject(waybillSubscription,
				ResponseBaseDTO.WaybillSubscriptionResponseEntityDTO.class);
		return waybillSubscriptionResponseDTO;
	}

	@Override
	public ResThirdAuthLinkEntityDTO getThirdAuthUrl(String extDetailDTO) {
		return new ResThirdAuthLinkEntityDTO().setAuthUrl(
				StrUtil.format(caiNiaoProperties.getAuthUrlTemplate(), caiNiaoProperties.getAppKey(), extDetailDTO,
						caiNiaoProperties.getRedirectUrl()));
	}

	@Override
	public ResAccessTokenGetEntityDTO getAuthToken(ReqAccessTokenGetEntityDTO queryDTO) {
		String sign = MD5Utils.md5(
				queryDTO.getAccessCode() + "," + queryDTO.getIsvAppkey() + "," + caiNiaoProperties.getAppSecret());
		String resAccessTokenGet = caiNiaoAuthClient.exchangeToken(queryDTO.getAccessCode(), queryDTO.getIsvAppkey(),
				sign);
		if (StrUtil.isBlank(resAccessTokenGet)) {
			return null;
		}
		return JsonUtil.toObject(resAccessTokenGet, ResAccessTokenGetEntityDTO.class);
	}

	@Override
	public ResponseBaseDTO.BlueToothCloudPrintResponseEntityDTO bluetoothPrint(ReqBlueToothCloudPrintEntityDTO queryDTO) {
		String resBlueTooth = caiNiaoClient.getBluetoothPrint(packParam(queryDTO, caiNiaoProperties.getGeneratePrinterCommands(),null));
		if (StrUtil.isBlank(resBlueTooth)) {
			return null;
		}
		return JsonUtil.toObject(resBlueTooth, ResponseBaseDTO.BlueToothCloudPrintResponseEntityDTO.class);
	}

	@Override
	public ResponseBaseDTO.RechargeRecordResponseEntityDTO webPrintRechargeRecord(ReqRechargeRecordEntityDTO queryDTO) {
		String record = caiNiaoClient.webPrintRechargeRecord(packParam(queryDTO, caiNiaoProperties.getRechargeRecordQuery(),queryDTO.getAuthToken()));
		if (StrUtil.isBlank(record)) {
			return null;
		}
		return JsonUtil.toObject(record, ResponseBaseDTO.RechargeRecordResponseEntityDTO.class);
	}

	@Override
	public ResponseBaseDTO.PrinterVerifyCodeResponseEntityDTO getPrinterVerifyCode(ReqPrinterVerifyCodeEntityDTO queryDTO) {
		String verifyCode = caiNiaoClient.getPrinterVerifyCode(
				packParam(queryDTO, caiNiaoProperties.getPrinterVerificationCode(),
						queryDTO.getAuthToken()));
		if (StrUtil.isBlank(verifyCode)) {
			return null;
		}
		return JsonUtil.toObject(verifyCode, ResponseBaseDTO.PrinterVerifyCodeResponseEntityDTO.class);
	}

	@Override
	public ResponseBaseDTO.PrinterShareCodeResponseEntityDTO getPrinterShareCode(ReqPrinterShareCodeEntityDTO queryDTO) {
		String shareCode = caiNiaoClient.getPrinterShareCode(
				packParam(queryDTO, caiNiaoProperties.getPrinterBind(),queryDTO.getAuthToken()));
		if (StrUtil.isBlank(shareCode)) {
			return null;
		}
		return JsonUtil.toObject(shareCode, ResponseBaseDTO.PrinterShareCodeResponseEntityDTO.class);
	}

	@Override
	public ResponseBaseDTO.PrinterStatusResponseEntityDTO getPrinterStatus(ReqPrinterStatusEntityDTO queryDTO) {
		String printerStatus = caiNiaoClient.getPrinterStatus(
				packParam(queryDTO, caiNiaoProperties.getPrinterStatus(),queryDTO.getAuthToken()));
		if (StrUtil.isBlank(printerStatus)) {
			return null;
		}
		return JsonUtil.toObject(printerStatus, ResponseBaseDTO.PrinterStatusResponseEntityDTO.class);
	}

	@Override
	public ResponseEntityDTO netWorkPrinterPrint(ReqNetWorkPrinterPrintEntityDTO queryDTO) {
		String printerPrint = caiNiaoClient.netWorkPrinterPrint(
				packParam(queryDTO, caiNiaoProperties.getNetWorkPrinterPrint(),queryDTO.getAuthToken()));
		if (StrUtil.isBlank(printerPrint)) {
			return null;
		}
		return JsonUtil.toObject(printerPrint, ResponseEntityDTO.class);
	}

	@Override
	public ResponseBaseDTO.PrinterPicturePrintResponseEntityDTO netWorkPrinterImagePrint(ReqNetWorkPrinterImagePrintEntityDTO queryDTO) {
		String printerImagePrint = caiNiaoClient.netWorkPrinterImagePrint(
				packParam(queryDTO, caiNiaoProperties.getNetWorkPrinterImagePrint(),queryDTO.getAuthToken()));
		if (StrUtil.isBlank(printerImagePrint)) {
			return null;
		}
		return JsonUtil.toObject(printerImagePrint, ResponseBaseDTO.PrinterPicturePrintResponseEntityDTO.class);
	}

	@Override
	public ResponseBaseDTO.PrinterTaskStatusResponseEntityDTO netWorkPrinterTaskStatusQuery(ReqNetWorkPrinterTaskStatusEntityDTO queryDTO) {
		String printerTaskStatus = caiNiaoClient.netWorkPrinterTaskStatusQuery(
				packParam(queryDTO, caiNiaoProperties.getPrinterTaskStatus(),queryDTO.getAuthToken()));
		if (StrUtil.isBlank(printerTaskStatus)) {
			return null;
		}
		return JsonUtil.toObject(printerTaskStatus, ResponseBaseDTO.PrinterTaskStatusResponseEntityDTO.class);
	}


	private Map<String, String> packParam(Object data, String requestType,String logisticProviderId) {
		String requestData = JsonUtil.toJSONString(data);
		Map<String, String> params = new HashMap<>();
		params.put("msg_type", requestType);
		if (StrUtil.isNotBlank(logisticProviderId)){
			params.put("logistic_provider_id", logisticProviderId);
		}else {
			params.put("logistic_provider_id", caiNiaoProperties.getZyCode());
		}
		params.put("data_digest", generateLinkDigest(requestData, caiNiaoProperties.getAppSecret()));
		params.put("logistics_interface", requestData);
		return params;
	}

	protected static String generateLinkDigest(String content, String keys) {
		String digestContent = content + keys;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(digestContent.getBytes());
			return new String(Base64.encodeBase64(md.digest()), StandardCharsets.UTF_8);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
