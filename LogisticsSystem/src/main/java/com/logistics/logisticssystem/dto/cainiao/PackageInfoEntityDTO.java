package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;


@Data
@Accessors(chain = true)
@ApiModel("电子面单取号 tradeOrderInfoDtos字段 的 packageInfo字段")
public class PackageInfoEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("包裹id，用于拆合单场景（只能传入数字、字母和下划线；批量请求时值不得重复，大小写敏感，即123A,123a 不可当做不同ID，否则存在一定可能取号失败）")
	private String id;

	@ApiModelProperty("商品信息,数量限制为100")
	private List<PackageItemEntityDTO> items;

	@ApiModelProperty("体积")
	private Long volume;

	@ApiModelProperty("重量")
	private Long weight;

	@ApiModelProperty("子母件模式中的总包裹数/总件数，用于打印当前包裹处于总件数的位置比如5-2，可以表示总包裹数为5，当前为第2个包裹，只有快运公司需要传入，其他的可以不用传入")
	private Long totalPackagesCount;

	@ApiModelProperty("大件快运中的包装方式描述")
	private String packagingDescription;

	@ApiModelProperty("大件快运中的货品描述，比如服装，家具")
	private String goodsDescription;
}
