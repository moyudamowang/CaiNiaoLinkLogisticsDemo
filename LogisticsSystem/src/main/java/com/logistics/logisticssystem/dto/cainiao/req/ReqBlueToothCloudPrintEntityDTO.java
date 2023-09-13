package com.logistics.logisticssystem.dto.cainiao.req;

 
import com.logistics.logisticssystem.dto.cainiao.DocumentEntityDTO;
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import com.logistics.logisticssystem.dto.cainiao.RenderConfigEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("电子面单蓝牙打印 入参")
public class ReqBlueToothCloudPrintEntityDTO extends BaseEntityDTO {

	@ApiModelProperty(required = true,value = "客户端用户标识：请确保该字段值能唯一标识一个用户")
	private String clientId;

	@ApiModelProperty(required = true,value = "客户端类型：native-本地应用 weixin-微信小程序 alipay-支付宝小程序 qianniu-千牛")
	private String clientType;

	@ApiModelProperty(required = false,value = "渲染配置")
	private RenderConfigEntityDTO config;

	@ApiModelProperty(required = true,value = "打印机名称：通过蓝牙扫描获取到的设备名称，如KM-300S-EB13")
	private String printerName;

	@ApiModelProperty(required = true,value = "需要打印的文档，包括模板地址、打印数据")
	private DocumentEntityDTO document;

	@ApiModelProperty(required = false,value = "请求id")
	private String requestId;
}
