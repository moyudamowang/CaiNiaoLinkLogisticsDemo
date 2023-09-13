package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;


@Data
@ApiModel("获取发货地，CP开通状态，账户的使用情况 响应DTO 的 waybillApplySubscriptionCols 的 branchAccountCols")
@Accessors(chain = true)
public class WaybillBranchAccountEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("已用面单数量")
	private Long allocatedQuantity;

	@ApiModelProperty("网点Code")
	private String branchCode;

	@ApiModelProperty("网点名称")
	private String branchName;

	@ApiModelProperty("网点状态")
	private Integer branchStatus;

	@ApiModelProperty("取消的面单总数")
	private Long cancelQuantity;

	@ApiModelProperty("已打印的面单总数")
	private Long printQuantity;

	@ApiModelProperty("电子面单余额数量")
	private Long quantity;

	@ApiModelProperty("当前网点下的发货地址")
	private List<AddressEntityDTO> shippAddressCols;

	@ApiModelProperty("可用的服务信息列表")
	private List<ServiceInfoEntityDTO> serviceInfoCols;

	@ApiModelProperty("cp的品牌code")
	private String brandCode;

	@ApiModelProperty("月结卡号列表")
	private List<String> customerCodeList;

	@ApiModelProperty("号段信息")
	private String segmentCode;
}
