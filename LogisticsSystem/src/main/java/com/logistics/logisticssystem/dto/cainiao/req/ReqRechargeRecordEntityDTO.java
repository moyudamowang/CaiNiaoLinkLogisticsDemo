package com.logistics.logisticssystem.dto.cainiao.req;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;


@Data
@Accessors(chain = true)
@ApiModel("电子面单充值记录 入参")
public class ReqRechargeRecordEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("支付时间范围左边界")
	private LocalDateTime payTimeBegin;

	@ApiModelProperty("支付时间范围又边界")
	private LocalDateTime payTimeEnd;

	@ApiModelProperty("来单手机号")
	private String mobile;

	@ApiModelProperty("买家名称，支持模糊搜索")
	private String buyerName;

	@ApiModelProperty("客户编码用,分割")
	private String customerCodes;

	@ApiModelProperty("当前页码")
	private Integer pageIndex;

	@ApiModelProperty("每页大小 最大100")
	private Integer pageSize;

	@ApiModelProperty("cp编码")
	private String cpCode;

	@ApiModelProperty("网点编码")
	private String branchCode;

	@ApiModelProperty("商家编码")
	private String customerCode;

	@ApiModelProperty("面单平台")
	private String platformType;

	@ApiModelProperty("外部订单号")
	private String outOrderId;

	@ApiModelProperty(value = "isv编码")
	private String isvCode;


	@ApiModelProperty("用户授权token")
	private String authToken;
}
