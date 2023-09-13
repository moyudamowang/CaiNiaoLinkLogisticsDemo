package com.logistics.logisticssystem.dto.cainiao.res;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("响应参数")
public class ResponseEntityDTO extends BaseEntityDTO {

	private Boolean success;

	private String errorCode;

	private String errorMsg;

	@ApiModelProperty(value = "结果",notes = "是json对象")
	private ResponseResultEntityDTO result;
}
