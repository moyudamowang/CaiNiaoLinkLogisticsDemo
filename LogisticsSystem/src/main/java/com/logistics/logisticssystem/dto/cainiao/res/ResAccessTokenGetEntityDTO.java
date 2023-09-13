package com.logistics.logisticssystem.dto.cainiao.res;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import com.logistics.logisticssystem.dto.cainiao.AccessTokenEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;


@Data
@Accessors(chain = true)
@ApiModel("获取菜鸟授权token 响应参数")
public class ResAccessTokenGetEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("是否成功")
	private Boolean success;

	@ApiModelProperty("授权token")
	private List<AccessTokenEntityDTO> accessTokens;
}
