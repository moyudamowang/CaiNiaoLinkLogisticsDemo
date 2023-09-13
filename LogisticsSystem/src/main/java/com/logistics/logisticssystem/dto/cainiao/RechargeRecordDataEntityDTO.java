package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;


@Data
@Accessors(chain = true)
@ApiModel("电子面单充值记录 tradeOrderInfoDtos字段 的 data字段")
public class RechargeRecordDataEntityDTO extends BaseEntityDTO {

  private Integer totalRecords;

	private Integer pageIndex;

	private Integer pageSize;

	private List<WtOrderEntityDTO> orders;
}
