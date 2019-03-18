package com.bin.liu.springboot.demo.requst;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


/**
 * @program: springboot-parent
 * @description: user请求参数
 * @author: bin.liu
 * @create: 2019-03-18 06:40
 **/


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class UserReq {

    @ApiModelProperty(name = "id",dataType = "Long",value = "id",example = "1")
    Long id;

    @ApiModelProperty(name = "name",dataType = "String",value = "姓名",example = "小红")
    @NotBlank(message = "姓名不能为空")
    String name;

    @ApiModelProperty(name = "level",dataType = "Integer",value = "级别",example = "1")
    //@NotBlank(message = "级别不能为空")
    Integer level;
}
