package com.logistics.logisticssystem.dto.cainiao.req;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("获取网络打印机验证码 入参")
public class ReqPrinterVerifyCodeEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("打印机id")
  private String printerId;

	@ApiModelProperty("用户授权token")
	private String authToken;
}
