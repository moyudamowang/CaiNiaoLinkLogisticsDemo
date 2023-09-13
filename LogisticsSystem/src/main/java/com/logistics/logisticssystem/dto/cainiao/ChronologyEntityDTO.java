package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("年表 json")
public class ChronologyEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("日历类型")
	private String calendarType;

	@ApiModelProperty("ID")
	private String id;
}
