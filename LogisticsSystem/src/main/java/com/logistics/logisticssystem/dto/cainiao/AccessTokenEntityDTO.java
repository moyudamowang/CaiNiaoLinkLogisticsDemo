package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("菜鸟授权token信息")
public class AccessTokenEntityDTO extends BaseEntityDTO {

	private String accessCode;

	private String grantBy;

	private Long expireDate;

	@ApiModelProperty("使用AccessToken访问用户数据")
	private String accessToken;

	private String apiId;
}
