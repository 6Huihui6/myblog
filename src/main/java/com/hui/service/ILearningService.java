package com.hui.service;

import com.hui.domain.Result;
import com.hui.domain.VO.LearningVO;
import com.hui.domain.po.Learning;
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
public interface ILearningService extends IService<Learning> {

    /**
     * 获取学习信息
     * @return
     */
    Result<List<LearningVO>> getLearning();

    /**
     * 获取学习信息
     * @param id
     * @return
     */
    Result<LearningVO> getLearningById(Integer id);
}
