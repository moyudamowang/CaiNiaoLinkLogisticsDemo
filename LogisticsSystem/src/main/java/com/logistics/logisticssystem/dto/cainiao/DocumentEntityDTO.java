package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;


@Data
@Accessors(chain = true)
@ApiModel("电子面单蓝牙打印 打印数据")
public class DocumentEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("包含的内容区域列表。对于有自定义区的文档，content会包含两条，即第一条是标准模板区域内容、第二条是自定义区域内容")
	private List<RenderContentEntityDTO> contents;
}
