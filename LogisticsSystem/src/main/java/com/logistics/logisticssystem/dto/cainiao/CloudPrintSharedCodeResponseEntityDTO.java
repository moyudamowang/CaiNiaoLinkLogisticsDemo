package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("网络打印机获取分享码-CloudPrintSharedCodeResponse")
public class CloudPrintSharedCodeResponseEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("分享码")
	private String shardCode;
}
