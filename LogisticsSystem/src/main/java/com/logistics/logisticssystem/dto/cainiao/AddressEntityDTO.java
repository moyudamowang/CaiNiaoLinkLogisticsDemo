package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("电子面单取号 sender字段UserInfoDTO中的address字段")
public class AddressEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("市")
	private String city;

	@ApiModelProperty("详细地址")
	private String detail;

	@ApiModelProperty("区")
	private String district;

	@ApiModelProperty("省")
	private String province;

	@ApiModelProperty("镇")
	private String town;

	@ApiModelProperty("月结卡号")
	private String customerCode;
}
