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
 * 
 * </p>
 *
 * @author hui
 * @since 2024-10-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("entertainment")
@ApiModel(value="Entertainment对象", description="")
public class EntertainmentVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "en_id", type = IdType.AUTO)
    private Integer enId;

    private String title;

    private String icon;

    private String items;

    private String[] item;

    private String description;

    private String image;

    private Integer articleId;


}
