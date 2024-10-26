package com.hui.controller;


import com.hui.domain.Result;
import com.hui.domain.VO.EntertainmentVO;
import com.hui.domain.po.Entertainment;
import com.hui.service.IEntertainmentService;
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
@RequestMapping("/entertainment")
@RequiredArgsConstructor
@Tag(name = "娱乐", description = "娱乐相关接口")
public class EntertainmentController {

    private final IEntertainmentService entertainmentService;

    @Operation(summary = "获取娱乐信息")
    @GetMapping
    public Result<List<EntertainmentVO>> getEntertainment() {
        return entertainmentService.getEntertainment();
    }

    @Operation(summary = "获取指定id的娱乐信息")
    @GetMapping("/{id}")
    public Result<EntertainmentVO> getEntertainmentById(@PathVariable("id") Integer id) {
        return entertainmentService.getEntertainmentById(id);
    }

}
