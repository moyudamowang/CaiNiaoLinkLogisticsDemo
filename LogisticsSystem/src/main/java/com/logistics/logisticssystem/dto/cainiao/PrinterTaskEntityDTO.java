package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;


@Data
@Accessors(chain = true)
@ApiModel("网络打印机获取任务状态-data")
public class PrinterTaskEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("任务id")
	private Long taskId;

	@ApiModelProperty("打印状态 0（新任务）1（已下发）2（正在运行）3（失败）4（完成）5（下发中未确认）")
	private Integer taskStatus;

	@ApiModelProperty("创建时间")
	private LocalDate createTime;

	@ApiModelProperty("打印时间")
	private LocalDate printedTime;

	@ApiModelProperty("接收准备时间")
	private LocalDate preparedTime;

	@ApiModelProperty("下发时间")
	private LocalDate dispatchTime;

}
