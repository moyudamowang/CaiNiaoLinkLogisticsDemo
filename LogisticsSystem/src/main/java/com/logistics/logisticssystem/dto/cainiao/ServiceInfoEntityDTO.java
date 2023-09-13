package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("获取发货地，CP开通状态，账户的使用情况 响应DTO 的 waybillApplySubscriptionCols 的 branchAccountCols 的 serviceInfoCols")
public class ServiceInfoEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("服务名称")
	private String serviceName;

	@ApiModelProperty("服务编码")
	private String serviceCode;
}
