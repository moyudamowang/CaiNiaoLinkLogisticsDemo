package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;


@Data
@Accessors(chain = true)
@ApiModel("电子面单取号入参 tradeOrderInfoDtos字段 的 orderInfo字段")
public class OrderInfoEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("订单渠道平台，请按实际订单所属平台传入（详见https://support-cnkuaidi.taobao.com/doc.htm#?docId=105085&docType=1）")
	private String orderChannelsType;

	@ApiModelProperty("订单号列表（上限100个）")
	private List<String> tradeOrderList;


}
