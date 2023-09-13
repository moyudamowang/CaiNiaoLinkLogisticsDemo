package com.logistics.logisticssystem.dto.cainiao;

import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("电子面单蓝牙打印 内容 的printData 字段")
public class PrintDataEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("加密数据")
	private String encryptedData;

	@ApiModelProperty("签名")
	private String signature;

	@ApiModelProperty("模板URL")
	private String templateURL;

	@ApiModelProperty("版本")
	private String ver;

	@ApiModelProperty(value = "附加字段，JSON格式",required = false)
	private String addData;
}
