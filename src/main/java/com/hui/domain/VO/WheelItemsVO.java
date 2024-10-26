package com.hui.domain.VO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
public class WheelItemsVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String[] image;

    private String limage;

    private String rimage;

    private String name;

    private String intro;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


}
