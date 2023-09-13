package com.logistics.logisticssystem.dto.cainiao.req;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;


@Data
@Accessors(chain = true)
@ApiModel("获取网络打印机任务状态 入参")
public class ReqNetWorkPrinterTaskStatusEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("打印机标识唯一id")
	private String uid;

	@ApiModelProperty("开始时间")
	private LocalDate startTime;

	@ApiModelProperty("结束时间")
	private LocalDate endTime;

	@ApiModelProperty("共享码")
	private Integer shareCode;

	@ApiModelProperty("应用名称")
	private String appKey;

	@ApiModelProperty("当前页")
	private Integer currentPage;

	@ApiModelProperty("每页大小")
	private Integer pageSize;

	@ApiModelProperty("用户授权token")
	private String authToken;
}
