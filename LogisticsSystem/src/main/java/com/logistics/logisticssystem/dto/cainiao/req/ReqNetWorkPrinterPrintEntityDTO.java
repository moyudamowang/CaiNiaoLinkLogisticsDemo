package com.logistics.logisticssystem.dto.cainiao.req;


import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import com.logistics.logisticssystem.dto.cainiao.CustomDataEntityDTO;
import com.logistics.logisticssystem.dto.cainiao.PrintDataEntityDTO;
import com.logistics.logisticssystem.dto.cainiao.RenderConfigEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("网络打印机打印 入参")
public class ReqNetWorkPrinterPrintEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("userid")
	private String userId;

	@ApiModelProperty("分享码")
	private Integer sharedCode;

	@ApiModelProperty("打印机id")
	private String printerId;

	@ApiModelProperty("打印数据包含模板和打印数据")
	private PrintDataEntityDTO printData;

	@ApiModelProperty(value = "自定义数据",required = false)
	private CustomDataEntityDTO customData;

	@ApiModelProperty("渠道")
	private String platformChannel;

	@ApiModelProperty("是否仅取号，默认为 false")
	private Boolean onlyApply;

	@ApiModelProperty("渲染属性")
	private RenderConfigEntityDTO config;

	@ApiModelProperty("是否分页，默认false")
	private Boolean splitEnable;


	@ApiModelProperty("用户授权token")
	private String authToken;
}
