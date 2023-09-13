package com.logistics.logisticssystem.dto.cainiao.req;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("获取网络打印机状态 入参")
public class ReqPrinterStatusEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("appKey")
	private String appKey;

	@ApiModelProperty("分享码")
	private Integer shareCode;

	@ApiModelProperty("打印机id")
	private String uid;


	@ApiModelProperty("用户授权token")
	private String authToken;
}
