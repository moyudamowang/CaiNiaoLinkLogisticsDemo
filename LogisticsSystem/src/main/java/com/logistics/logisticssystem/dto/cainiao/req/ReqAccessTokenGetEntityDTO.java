package com.logistics.logisticssystem.dto.cainiao.req;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("获取菜鸟授权")
public class ReqAccessTokenGetEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("ISV必须拿这个accessCode来云平台拿真正的Token，此code仅有十分钟有效期，并在换区Token后立即失效，示例链接中的code为示例，不再有效")
	private String accessCode;

	@ApiModelProperty("ISV对应的AppKey")
	private String isvAppkey;

	@ApiModelProperty("签名，证明ISV合法，签名规则：md5(accessCode + \",\" + appKey + \",\" + appSecret);Note:别忘了逗号是英文状态下的逗号")
	private String sign;
}
