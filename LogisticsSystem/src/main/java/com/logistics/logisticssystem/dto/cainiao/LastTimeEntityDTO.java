package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("查询物流详情出参-lastTime")
public class LastTimeEntityDTO extends BaseEntityDTO {

	@ApiModelProperty("星期几")
	private String dayOfWeek;

	@ApiModelProperty("月份")
	private String month;

	@ApiModelProperty("年")
	private Long year;

	@ApiModelProperty("月中第几天")
	private Long dayOfMonth;

	@ApiModelProperty("年中第几天")
	private Long dayOfYear;

	@ApiModelProperty("月份值")
	private Long monthValue;

	@ApiModelProperty("")
	private Long nano;

	@ApiModelProperty("秒")
	private Long second;

	@ApiModelProperty("分")
	private Long minute;

	@ApiModelProperty("时")
	private Long hour;

	@ApiModelProperty("年表 json")
	private String chronology;
}
