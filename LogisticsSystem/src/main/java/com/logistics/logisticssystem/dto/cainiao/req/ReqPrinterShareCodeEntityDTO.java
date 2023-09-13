package com.logistics.logisticssystem.dto.cainiao.req;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("获取网络打印机分享码 入参")
public class ReqPrinterShareCodeEntityDTO extends BaseEntityDTO {


	@ApiModelProperty("打印机ID")
	private String printerId;

	@ApiModelProperty("验证码")
	private String verifyCode;

	@ApiModelProperty("用户ID")
	private String userId;

	@ApiModelProperty("用户授权token")
	private String authToken;

}
