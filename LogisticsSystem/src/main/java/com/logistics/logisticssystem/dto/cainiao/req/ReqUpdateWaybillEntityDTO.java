package com.logistics.logisticssystem.dto.cainiao.req;


import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import com.logistics.logisticssystem.dto.cainiao.PackageInfoEntityDTO;
import com.logistics.logisticssystem.dto.cainiao.RecipientEntityDTO;
import com.logistics.logisticssystem.dto.cainiao.SenderEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("电子面单更新入参")
public class ReqUpdateWaybillEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("快递公司编码")
	private String cpCode;

	@ApiModelProperty("电子面单号")
	private String waybillCode;

	@ApiModelProperty("请求ID（只限传入数字、字母和下划线）")
	private String objectId;

	@ApiModelProperty("物流服务值（详见https://support-cnkuaidi.taobao.com/doc.htm#?docId=106156&docType=1，如无特殊服务请置空）")
	private String logisitcsServices;

	@ApiModelProperty("包裹信息")
	private PackageInfoEntityDTO packageInfo;

	@ApiModelProperty("收件人信息")
	private RecipientEntityDTO recipient;

	@ApiModelProperty("发件人信息")
	private SenderEntityDTO sender;

	@ApiModelProperty("云打印标准模板URL（组装云打印结果使用，值格式http://cloudprint.cainiao.com/template/standard/${模板ID}）")
	private String templateUrl;

	@ApiModelProperty("用户授权token")
	private String authToken;
}
