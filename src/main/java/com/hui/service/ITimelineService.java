package com.hui.service;

import com.hui.domain.Result;
import com.hui.domain.po.Timeline;
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
public interface ITimelineService extends IService<Timeline> {

    /**
     * 获取时间线
     * @return
     */
    Result<List<Timeline>> getTimeline();
}
