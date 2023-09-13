package com.logistics.logisticssystem.dto.cainiao.req;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("查询物流详情入参")
public class ReqLogisticsInterfaceEntityDTO extends BaseEntityDTO {

	
	@ApiModelProperty(value = "CPCode", required = true)
	private String cpCode;

	
	@ApiModelProperty(value = "快递单号", required = true)
	private String mailNo;

	@ApiModelProperty("发货号码")
	private String senderPhone;

	@ApiModelProperty("发件地址")
	private String senderAddress;

	@ApiModelProperty("收货号码")
	private String receiverPhone;

	@ApiModelProperty("派件地址")
	private String deliveryAddress;

	@ApiModelProperty(value = "应用Code", required = true)
	private String appCode;

	@ApiModelProperty(value = "淘系标")
	private String isTb;
}
