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
@TableName("experiences")
@ApiModel(value="Experiences对象", description="")
public class ExperiencesVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ex_id", type = IdType.AUTO)
    private Integer exId;

    private String title;

    private String description;

    private String year;

    private String image;

    private String skills;

    private String[] skillsGained;

    private String challengesOvercome;

    private String keyAchievements;


}
