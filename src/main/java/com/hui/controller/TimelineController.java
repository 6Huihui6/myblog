package com.hui.controller;


import com.hui.domain.Result;
import com.hui.domain.po.Timeline;
import com.hui.service.ITimelineService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hui
 * @since 2024-10-21
 */
@RestController
@RequestMapping("/timeline")
@RequiredArgsConstructor
@Tag(name = "时间线", description = "时间线相关接口")
public class TimelineController {

    private final ITimelineService timelineService;

    @GetMapping()
    public Result<List<Timeline>> getTimeline() {
        return timelineService.getTimeline();
    }



}
