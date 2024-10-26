package com.hui.domain.po;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hui
 * @since 2024-10-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("contactmethods")
@ApiModel(value="Contactmethods对象", description="")
public class Contactmethods implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String value;

    private String icon;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;



}
