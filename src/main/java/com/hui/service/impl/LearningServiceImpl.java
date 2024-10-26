package com.hui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hui.domain.Result;
import com.hui.domain.VO.LearningVO;
import com.hui.domain.po.Learning;
import com.hui.domain.po.Resources;
import com.hui.enums.AppHttpCodeEnum;
import com.hui.mapper.LearningMapper;
import com.hui.service.ILearningService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.service.IResourcesService;
import com.hui.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hui
 * @since 2024-10-21
 */
@Service
@RequiredArgsConstructor
public class LearningServiceImpl extends ServiceImpl<LearningMapper, Learning> implements ILearningService {

    private final LearningMapper learningMapper;
    private final IResourcesService resourcesService;

    /**
     * 获取学习信息
     *
     * @return
     */
    @Override
    public Result<List<LearningVO>> getLearning() {
        QueryWrapper<Learning> wrapper = new QueryWrapper<Learning>().orderByDesc("progress");
        List<Learning> learningList = learningMapper.selectList(wrapper);
        List<LearningVO> learningVOList = BeanUtils.copyList(learningList, LearningVO.class);
        return Result.success(learningVOList);
    }

    /**
     * 获取学习信息
     *
     * @param id
     * @return
     */
    @Override
    public Result<LearningVO> getLearningById(Integer id) {
        if (id == null) {
            return Result.errorResult(AppHttpCodeEnum.PARAM_REQUIRE);
        }
        Learning learning = this.getById(id);
        if (learning == null) {
            return Result.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST);
        }
        List<Resources> resources = resourcesService.list(new QueryWrapper<Resources>().eq("le_id", id));
        LearningVO learningVO = BeanUtils.copyBean(learning, LearningVO.class);
        learningVO.setSkills(learning.getSkills().split(","));
        learningVO.setResource(resources);
        return Result.success(learningVO);
    }
}
