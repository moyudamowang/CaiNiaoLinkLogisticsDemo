package com.logistics.logisticssystem.dto.cainiao.req;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import com.logistics.logisticssystem.dto.cainiao.TradeOrderInfoEntityDTO;
import com.logistics.logisticssystem.dto.cainiao.UserInfoEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Data
@ApiModel("获取电子面单请求DTO")
public class ReqWebBillGetEntityDTO extends BaseEntityDTO {

	@ApiModelProperty(value = "物流公司Code（详见https://support-cnkuaidi.taobao.com/doc.htm#?docId=105085&docType=1）",required = true)
	private String cpCode;

	@ApiModelProperty(value = "发货人信息",required = true)
	private UserInfoEntityDTO sender;

	@ApiModelProperty(value = "请求面单列表（上限10个）",required = true)
	private List<TradeOrderInfoEntityDTO> tradeOrderInfoDtos;

	@ApiModelProperty("特殊业务使用，如需使用请联系对接人员。")
	private String storeCode;

	@ApiModelProperty("特殊业务使用，如需使用请联系对接人员。")
	private String resourceCode;

	@ApiModelProperty("特殊业务使用，如需使用请联系对接人员。")
	private Boolean dmsSorting;

	@ApiModelProperty("云打印数据是否加密（true-加密;false-不加密）")
	private Boolean needEncrypt;

	@ApiModelProperty("拓展信息，特殊场景下使用 json格式")
	private String extraInfo;

	@ApiModelProperty("月结卡号。指定月结卡号取号，仅部分快递公司支持")
	private String customerCode;

	@ApiModelProperty("品牌编码，仅部分快递公司需要传入")
	private String brandCode;

	@ApiModelProperty("目前仅部分快递公司支持此参数，传入快递产品编码")
	private String productCode;

	@ApiModelProperty("是否预约上门")
	private Boolean callDoorPickUp;

	@ApiModelProperty("预约上门时间")
	private LocalDateTime doorPickUpTime;

	@ApiModelProperty("预约上门截止时间")
	private LocalDateTime doorPickUpEndTime;

	@ApiModelProperty("用户授权token")
	private String authToken;
}
