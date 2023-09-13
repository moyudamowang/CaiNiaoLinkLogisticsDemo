package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;


@Data
@Accessors(chain = true)
@ApiModel("查询自定义快递模板出参-data")
public class CustomTemplateResultEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("模板名称")
	private String templateName;

	@ApiModelProperty("模板url")
	private String templateUrl;

	@ApiModelProperty("模板中使用的变量列表")
	private List<KeyResultEntityDTO> keys;
}
