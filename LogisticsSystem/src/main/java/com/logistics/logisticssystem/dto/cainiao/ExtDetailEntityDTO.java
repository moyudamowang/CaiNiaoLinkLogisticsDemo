package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@Accessors(chain = true)
@ApiModel("获取菜鸟授权链接 扩展数据")
public class ExtDetailEntityDTO extends BaseEntityDTO implements Serializable {

	private Long merchantId;
}
