package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@ApiModel("获取电子面单模板 响应DTO 的 data字段 的 standardTemplateDOs字段")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class StandardTemplateEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("模板url")
	private String standardTemplateUrl;

	@ApiModelProperty("模板名称")
	private String standardTemplateName;

	@ApiModelProperty("面单模板类型")
	private Integer standardWaybillType;
}
