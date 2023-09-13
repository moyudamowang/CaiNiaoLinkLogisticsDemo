package com.logistics.logisticssystem.dto.cainiao.req;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("获取发货地，CP开通状态，账户的使用情况 入参")
public class ReqWaybillSubscriptionEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("快递公司编码")
	private String cpCode;

	@ApiModelProperty("用户授权token")
	private String authToken;
}
