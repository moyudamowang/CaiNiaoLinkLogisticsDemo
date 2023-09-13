package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("电子面单取号响应 waybillCloudPrintResponseList字段 电子面单打印内容")
public class WaybillCloudPrintResponseEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("请求id（与参数传入时相同）")
	private String objectId;
	@ApiModelProperty("面单号")
	private String waybillCode;
	@ApiModelProperty("云打印内容")
	private String printData;
	@ApiModelProperty("子母件中的母单号，当为子母件模式时，需要此单号为实际挂载物流详情的单号，需要使用此单号进行发货，查询物流详情，非子母件，此字段为空")
	private String parentWaybillCode;
	@ApiModelProperty("拓展信息，特殊场景下使用 json")
	private String extraInfo;
	@ApiModelProperty("cpCode，跟入参传入的cpCode保持一致")
	private String cpCode;

	@ApiModelProperty("真实取号的cpCode，在淘特官方物流等虚拟cp的场景中realCpCode和入参中的cpCode不一样，其他场景二者一样")
	private String realCpCode;
}
