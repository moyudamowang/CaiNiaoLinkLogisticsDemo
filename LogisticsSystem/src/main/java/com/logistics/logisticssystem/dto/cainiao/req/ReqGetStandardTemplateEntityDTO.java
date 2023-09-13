package com.logistics.logisticssystem.dto.cainiao.req;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("获取标准电子面单 入参")
public class ReqGetStandardTemplateEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("快递公司编号")
	private String cpCode;

	@ApiModelProperty("用户授权token")
	private String authToken;
}
