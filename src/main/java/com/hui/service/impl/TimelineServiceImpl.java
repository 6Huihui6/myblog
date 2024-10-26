package com.hui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hui.domain.Result;
import com.hui.domain.po.Timeline;
import com.hui.mapper.TimelineMapper;
import com.hui.service.ITimelineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class TimelineServiceImpl extends ServiceImpl<TimelineMapper, Timeline> implements ITimelineService {

    private final TimelineMapper timelineMapper;
    /**
     * 获取时间线
     *
     * @return
     */
    @Override
    public Result<List<Timeline>>getTimeline() {
        QueryWrapper<Timeline> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("date");
        List<Timeline> list = timelineMapper.selectList(queryWrapper);
        return Result.success(list);
    }
}
