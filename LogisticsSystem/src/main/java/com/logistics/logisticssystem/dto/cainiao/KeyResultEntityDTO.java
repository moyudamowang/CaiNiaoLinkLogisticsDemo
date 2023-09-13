package com.logistics.logisticssystem.dto.cainiao;

import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("查询自定义快递模板出参-data 里面的key 变量对象")
public class KeyResultEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("变量名称")
	private String keyName;
}
