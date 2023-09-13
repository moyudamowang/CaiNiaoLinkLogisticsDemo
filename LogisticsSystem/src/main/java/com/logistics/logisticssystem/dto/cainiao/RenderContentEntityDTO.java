package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("电子面单蓝牙打印 内容")
public class RenderContentEntityDTO extends BaseEntityDTO {

	@ApiModelProperty(value = "打印模板链接",required = true)
	private String templateUrl;

	@ApiModelProperty(value = "打印数据(json格式字符串)",required = true)
	private String printData;

	@ApiModelProperty("是否加密")
	private Boolean encrypted;

	@ApiModelProperty("秘钥版本")
	private String ver;

	@ApiModelProperty("附加数据(用于更改基础数据)")
	private String addData;

	@ApiModelProperty("数据签名")
	private String signature;
}
