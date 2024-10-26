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
@TableName("resources")
@ApiModel(value="Resources对象", description="")
public class Resources implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "re_id", type = IdType.AUTO)
    private Integer reId;

    private String name;

    private String url;

    private String icon;

    private Integer leId;


}
