package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;


@Data
@Accessors(chain = true)
@ApiModel("查询物流详情出参-detail")
public class LogisticsDetailsEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("快递编码")
	private String cpCode;

	@ApiModelProperty("城市名称")
	private String cityName;

	@ApiModelProperty("轨迹信息")
	private String opMessage;

	@ApiModelProperty("轨迹时间")
	private LocalDateTime opTime;

	@ApiModelProperty("轨迹描述")
	private String opDesc;

	@ApiModelProperty("地址文本信息")
	private String addressText;

	@ApiModelProperty("轨迹code")
	private String opCode;
}
