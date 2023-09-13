package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;


@Data
@Accessors(chain = true)
@ApiModel("电子面单充值记录 tradeOrderInfoDtos字段 的 data字段 的orders字段")
public class WtOrderEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("订单号")
	private String orderId;

	@ApiModelProperty("客户编码")
	private String customerCode;

	@ApiModelProperty("网点编码")
	private String branchCode;

	@ApiModelProperty("支付时间")
	private LocalDateTime payTime;

	@ApiModelProperty("CN-菜鸟, PDD-拼多多, JD-京东, BYTE_DANCE-抖音, KUAI_SHOU-快手, ZY-快递公司自有面单")
	private String waybillType;

	@ApiModelProperty("充值数量")
	private Integer qty;

	@ApiModelProperty("订单描述")
	private String remark;

	@ApiModelProperty("UNPAID-未付款，PAID-已付款，REFUND-已退款，COMPLETE-交易完成，CLOSED-交易关闭")
	private String status;

	@ApiModelProperty("订单实付金额，单位：分")
	private Long fee;

	@ApiModelProperty("买家留言")
	private String buyerMessage;
}
