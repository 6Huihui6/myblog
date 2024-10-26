package com.hui.service;

import com.hui.domain.Result;
import com.hui.domain.VO.ExperiencesVO;
import com.hui.domain.po.Experiences;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hui
 * @since 2024-10-21
 */
public interface IExperiencesService extends IService<Experiences> {

    /**
     * 获取所有经历
     * @return
     */
    Result<List<ExperiencesVO>> getExperiences();
}
