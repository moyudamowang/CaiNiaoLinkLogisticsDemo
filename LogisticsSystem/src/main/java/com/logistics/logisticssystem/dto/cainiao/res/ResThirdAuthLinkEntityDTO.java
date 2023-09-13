package com.logistics.logisticssystem.dto.cainiao.res;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("传给前端的第三方授权链接")
public class ResThirdAuthLinkEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("授权链接")
	private String authUrl;
}
