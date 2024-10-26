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
 * 轮播图
 * </p>
 *
 * @author hui
 * @since 2024-10-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("wheelItems")
@ApiModel(value="WheelItems对象", description="轮播图")
public class WheelItems implements Serializable {

    private static final long serialVersionUID = 1L;

    private String image;

    private String limage;

    private String rimage;

    private String name;

    private String intro;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


}
