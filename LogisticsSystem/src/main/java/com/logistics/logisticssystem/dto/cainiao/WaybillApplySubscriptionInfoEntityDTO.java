package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;


@Data
@ApiModel("获取发货地，CP开通状态，账户的使用情况 响应DTO 的 waybillApplySubscriptionCols")
@Accessors(chain = true)
public class WaybillApplySubscriptionInfoEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("CP网点信息及对应的商家的发货信息")
	private List<WaybillBranchAccountEntityDTO> branchAccountCols;

	@ApiModelProperty("物流服务商ID")
	private String cpCode;

	@ApiModelProperty("1是直营，2是加盟")
	private Integer cpType;
}
