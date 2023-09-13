package com.logistics.logisticssystem.dto.cainiao.req;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("电子面单取消入参")
public class ReqCancelWaybillEntityDTO extends BaseEntityDTO {

	
	@ApiModelProperty("电子面单号")
	private String waybillCode;

	
	@ApiModelProperty("快递公司编码")
	private String cpCode;


	@ApiModelProperty("用户授权token")
	private String authToken;
}
