package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("电子面单取号 tradeOrderInfoDtos字段")
public class TradeOrderInfoEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("物流服务值（详见https://support-cnkuaidi.taobao.com/doc.htm#?docId=106156&docType=1，如无特殊服务请置空）")
	private String logisticsServices;

	@ApiModelProperty("请求ID（请保证一次批量请求中值不重复，调用方可按该值从返回数据中获取相应结果；只限传入数字、字母和下划线，建议用数字序号下标代替）")
	private String objectId;

	@ApiModelProperty("订单信息")
	private OrderInfoEntityDTO orderInfo;

	@ApiModelProperty("包裹信息")
	private PackageInfoEntityDTO packageInfo;

	@ApiModelProperty("收件人信息")
  private UserInfoEntityDTO recipient;

	@ApiModelProperty("云打印标准模板url")
	private String templateUrl;

	@ApiModelProperty("使用者ID（使用电子面单账号的实际商家ID，如存在一个电子面单账号多个店铺使用时，请传入店铺的商家ID）")
	private Long userId;
}
