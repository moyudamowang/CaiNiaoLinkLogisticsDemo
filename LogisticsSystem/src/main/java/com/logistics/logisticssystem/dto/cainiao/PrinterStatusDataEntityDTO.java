package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;


@Data
@Accessors(chain = true)
@ApiModel("网络打印机获取状态-data")
public class PrinterStatusDataEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("设备名称")
	private String deviceName;

	@ApiModelProperty("打印机类型：1-WiFi版，2-4G版")
	private Integer printerType;

	@ApiModelProperty("打印机状态：1-在线，2-离线")
	private Integer onlineStatus;

	@ApiModelProperty("运营商：1-移动，2-电信，3-联通，4-其他")
	private Integer ispCode;

	@ApiModelProperty("信号强度值（单位：dBm）")
	private Integer signalStrength;

	@ApiModelProperty("信号强度等级：1-1格信号，2-2格信号，3-3格信号，4-4格信号（满格）")
	private Integer signalQuality;

	@ApiModelProperty("网络状态诊断码：0-正常 （作为预留，本期默认全部传0）")
	private Integer networkExceptionCode;

	@ApiModelProperty("网络操作建议：0-无需操作 （面向用户的网络操作建议，作为预留，本期默认全部传0）")
	private Integer networkActionCode;

	@ApiModelProperty("打印机过期时间")
	private LocalDate outDate;
}
