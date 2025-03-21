package com.hui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hui.domain.Result;
import com.hui.domain.VO.ExperiencesVO;
import com.hui.domain.po.Experiences;
import com.hui.mapper.ExperiencesMapper;
import com.hui.service.IExperiencesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
public class ExperiencesServiceImpl extends ServiceImpl<ExperiencesMapper, Experiences> implements IExperiencesService {

    private final ExperiencesMapper experiencesMapper;
    /**
     * 获取所有经历
     *
     * @return
     */
    @Override
    public Result<List<ExperiencesVO>> getExperiences() {
        // 查询所有经历
        QueryWrapper<Experiences> experiencesQueryWrapper = new QueryWrapper<>();
        experiencesQueryWrapper.orderByDesc("year");
        List<Experiences> experiences = experiencesMapper.selectList(experiencesQueryWrapper);
        List<ExperiencesVO> list = BeanUtils.copyList(experiences, ExperiencesVO.class);
        for (ExperiencesVO experiencesVO : list) {
            experiencesVO.setSkillsGained( experiencesVO.getSkills().split(","));
        }
        return Result.success(list);
    }
}
