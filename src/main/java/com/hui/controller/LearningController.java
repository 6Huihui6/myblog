package com.hui.controller;


import com.hui.domain.Result;
import com.hui.domain.VO.LearningVO;
import com.hui.service.ILearningService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/learning")
@RequiredArgsConstructor
@Tag(name = "学习模块", description = "学习相关接口")
public class LearningController {

    private final ILearningService learningService;

    @Operation(summary = "获取学习列表")
    @GetMapping()
    public Result<List<LearningVO>> getLearning() {
        return learningService.getLearning();
    }

    @Operation(summary = "获取学习详情")
    @GetMapping("/{id}")
    public Result<LearningVO> getLearningById( @PathVariable Integer id) {
        return learningService.getLearningById(id);
    }

}
