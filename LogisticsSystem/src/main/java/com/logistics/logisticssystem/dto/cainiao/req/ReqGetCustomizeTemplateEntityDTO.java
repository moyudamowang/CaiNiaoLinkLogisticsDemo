package com.logistics.logisticssystem.dto.cainiao.req;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("获取自定义电子面单 入参")
public class ReqGetCustomizeTemplateEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("为之后预留")
	private String objectId;

	@ApiModelProperty("用户授权token")
	private String authToken;
}
