package com.logistics.logisticssystem.dto.cainiao;


import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import com.logistics.logisticssystem.dto.cainiao.res.ResponseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;


public interface ResponseBaseDTO {

	@ApiModel("物流详情查询 响应DTO")
	@Data
	@EqualsAndHashCode(callSuper = true)
	@Accessors(chain = true)
	class LogisticsInterfaceResponseEntityDTO extends BaseEntityDTO {

		@ApiModelProperty("最后一次时间(yyyy-MM-ddTHH:mm:ss)")
		private String lastTime;

		@ApiModelProperty("最后一次更新时间")
		private LocalDateTime lastUpdateTime;

		@ApiModelProperty("物流详情")
		private List<LogisticsDetailsEntityDTO> detail;

		@ApiModelProperty("快递电话号码")
		private String cpTelPhoneNumber;

		@ApiModelProperty("最后一次物流状态")
		private String lastState;
	}

	@ApiModel("电子面单取号 响应DTO")
	@Data
	@EqualsAndHashCode(callSuper = true)
	@Accessors(chain = true)
	class WayBillGetResponseEntityDTO extends ResponseEntityDTO {

		private List<WaybillCloudPrintResponseEntityDTO> waybillCloudPrintResponseList;
	}

	@ApiModel("电子面单取消 响应DTO")
	@Data
	@EqualsAndHashCode(callSuper = true)
	@Accessors(chain = true)
	class WayBillCancelResponseEntityDTO extends ResponseEntityDTO {

		@ApiModelProperty("调用取消是否成功")
		private Boolean discardResult;
	}

	@ApiModel("电子面单更新 响应DTO")
	@Data
	@EqualsAndHashCode(callSuper = true)
	@Accessors(chain = true)
	class WayBiliUpdateResponseEntityDTO extends ResponseEntityDTO {

		@ApiModelProperty("电子面单号")
		private String waybillCode;

		@ApiModelProperty("云打印内容 json")
		private String printData;
	}

	@ApiModel("获取标准电子面单模板 响应DTO")
	@Data
	@EqualsAndHashCode(callSuper = true)
	@Accessors(chain = true)
	class WayBillTemplateResponseEntityDTO extends ResponseEntityDTO {

		@ApiModelProperty("标准电子面单模板列表")
		private List<StandardTemplateResultEntityDTO> data;
	}

	@ApiModel("获取自定义电子面单模板 响应DTO")
	@Data
	@EqualsAndHashCode(callSuper = true)
	@Accessors(chain = true)
	class WayBillCustomTemplateResponseEntityDTO extends ResponseEntityDTO {

		@ApiModelProperty("自定义电子面单模板列表")
		private List<CustomTemplateResultEntityDTO> data;
	}

	@ApiModel("获取发货地，CP开通状态，账户的使用情况 响应DTO")
	@Data
	@EqualsAndHashCode(callSuper = true)
	@Accessors(chain = true)
	class WaybillSubscriptionResponseEntityDTO extends ResponseEntityDTO {

		@ApiModelProperty("CP网点信息及对应的商家的发货信息")
		private List<WaybillApplySubscriptionInfoEntityDTO> waybillApplySubscriptionCols;
	}

	@ApiModel("电子面单蓝牙打印 响应参数")
	@Data
	@EqualsAndHashCode(callSuper = true)
	@Accessors(chain = true)
	class BlueToothCloudPrintResponseEntityDTO extends ResponseEntityDTO {

		@ApiModelProperty("指令集内容串")
     private String cmdContent;

		@ApiModelProperty("指令集编码方式：origin-原串 gzip-采用gzip压缩并base64编码")
		 private String cmdEncoding;
	}

	@ApiModel("电子面单充值记录 响应参数")
	@Data
	@EqualsAndHashCode(callSuper = true)
	@Accessors(chain = true)
	class RechargeRecordResponseEntityDTO extends ResponseEntityDTO {

		@ApiModelProperty("充值记录列表对象")
		private RechargeRecordDataEntityDTO data;
	}

	@ApiModel("网络打印机获取验证码 响应参数")
	@Data
	@EqualsAndHashCode(callSuper = true)
	@Accessors(chain = true)
	class PrinterVerifyCodeResponseEntityDTO extends ResponseEntityDTO {

	}

	@ApiModel("网络打印机获取分享码 响应参数")
	@Data
	@EqualsAndHashCode(callSuper = true)
	@Accessors(chain = true)
	class PrinterShareCodeResponseEntityDTO extends ResponseEntityDTO {

		@ApiModelProperty("分享码")
		private CloudPrintSharedCodeResponseEntityDTO CloudPrintSharedCodeResponse;
	}

	@ApiModel("网络打印机获取状态 响应参数")
	@Data
	@EqualsAndHashCode(callSuper = true)
	@Accessors(chain = true)
	class PrinterStatusResponseEntityDTO extends ResponseEntityDTO {

   private PrinterStatusDataEntityDTO data;
	}

	@ApiModel("网络打印机图片打印 响应参数")
	@Data
	@EqualsAndHashCode(callSuper = true)
	@Accessors(chain = true)
	class PrinterPicturePrintResponseEntityDTO extends BaseEntityDTO {

		@ApiModelProperty("调用是否成功")
		private String isSuccess;

		@ApiModelProperty("错误描述")
		private String describe;
	}

	@ApiModel("网络打印机获取任务状态 响应参数")
	@Data
	@EqualsAndHashCode(callSuper = true)
	@Accessors(chain = true)
	class PrinterTaskStatusResponseEntityDTO extends ResponseEntityDTO {

		private List<PrinterTaskEntityDTO> data;

		private Long total;

		private Long size;

		private Long current;

		private Long pages;

	}
}
