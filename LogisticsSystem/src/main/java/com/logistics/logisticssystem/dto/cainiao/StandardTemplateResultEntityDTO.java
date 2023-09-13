package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;


@ApiModel("获取电子面单模板 响应DTO 的 data字段")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class StandardTemplateResultEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("cpCode")
	private String cpCode;

	@ApiModelProperty("cpCode 对应的模板列表")
	private List<StandardTemplateEntityDTO> standardTemplateDOs;
}
