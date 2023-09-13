package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("电子面单取号 sender字段")
public class UserInfoEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("电话")
	private String mobile;

	@ApiModelProperty("姓名")
	private String name;

	@ApiModelProperty("手机")
	private String phone;

	@ApiModelProperty("地址")
	private AddressEntityDTO address;
}
