package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Map;


@Data
@Accessors(chain = true)
@ApiModel("电子面单蓝牙打印 渲染配置")
public class RenderConfigEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("是否需要上联logo")
	private Boolean needTopLogo;

	@ApiModelProperty("是否需要中间部分logo")
	private Boolean needMiddleLogo;

	@ApiModelProperty("是否需要下联logo")
	private Boolean needBottomLogo;

	@ApiModelProperty("normal-正常打印 reverse-旋转180°打印（用于反向出纸的纸张规格）")
	private String orientation;

	@ApiModelProperty("扩展字段")
	private Map extra;

	@ApiModelProperty("x 轴偏移（mm）")
	private Integer horizontalCoordinate;

	@ApiModelProperty("y 轴偏移（mm）")
	private Integer verticalCoordinate;
}
