package com.logistics.logisticssystem.dto.cainiao.res;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("响应参数 result字段")
public class ResponseResultEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("服务端编码")
	private Integer code;

	@ApiModelProperty("服务端上下文")
	private String context;

	@ApiModelProperty("服务端执行信息")
	private String message;

	@ApiModelProperty(value = "结果",notes = "是json对象")
	private String data;
}
