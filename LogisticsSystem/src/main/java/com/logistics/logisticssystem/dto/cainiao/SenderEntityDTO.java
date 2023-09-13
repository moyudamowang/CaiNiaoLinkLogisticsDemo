package com.logistics.logisticssystem.dto.cainiao;

 
import com.logistics.logisticssystem.dto.base.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@ApiModel("电子面单更新 sender字段")
public class SenderEntityDTO extends BaseEntityDTO {

	private String name;

	private String mobile;

	private String phone;
}
