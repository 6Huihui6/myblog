package com.hui.domain.po;

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
 * @since 2024-10-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("learning")
@ApiModel(value="Learning对象", description="")
public class Learning implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "le_id", type = IdType.AUTO)
    private Integer leId;

    private String title;

    private String description;

    private String icon;

    private String color;

    private Integer progress;

    private String fulldescription;

    private String skills;


}
