package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("网络打印机打印 自定义数据")
public class CustomDataEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("打印模板链接")
	private String templateUrl;

	@ApiModelProperty("打印数据(json格式字符串)")
	private String data;
}
