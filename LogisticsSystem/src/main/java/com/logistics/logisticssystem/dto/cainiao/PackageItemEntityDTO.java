package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("电子面单取号 tradeOrderInfoDtos字段 的 packageInfo字段 的 items字段")
public class PackageItemEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("数量")
	private Integer count;

	@ApiModelProperty("商品名称")
	private String name;
}
