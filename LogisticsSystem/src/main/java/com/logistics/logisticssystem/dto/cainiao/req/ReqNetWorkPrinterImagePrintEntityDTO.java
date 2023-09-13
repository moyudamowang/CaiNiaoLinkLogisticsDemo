package com.logistics.logisticssystem.dto.cainiao.req;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("网络打印机图片打印 入参")
public class ReqNetWorkPrinterImagePrintEntityDTO extends BaseEntityDTO {


	@ApiModelProperty("对位图gzip然后base64之后的数据")
	private String printData;

	@ApiModelProperty("用户id")
	private String userId;

	@ApiModelProperty("isv唯一id")
	private String appkey;

	@ApiModelProperty("打印机id")
	private String uid;

	@ApiModelProperty("打印机分享码")
	private String shareCode;

	@ApiModelProperty("1:图片数据 2:指令集")
	private String type;


	@ApiModelProperty("用户授权token")
	private String authToken;
}
