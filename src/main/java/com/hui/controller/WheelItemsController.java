package com.hui.controller;


import com.hui.domain.Result;
import com.hui.domain.VO.WheelItemsVO;
import com.hui.service.IWheelItemsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 轮播图 前端控制器
 * </p>
 *
 * @author hui
 * @since 2024-10-21
 */
@RestController
@RequestMapping("/wheel")
@RequiredArgsConstructor
@Tag(name = "wheel", description = "轮播图相关接口")
public class WheelItemsController {

    private  final IWheelItemsService wheelItemsService;

    @Operation(summary = "获取轮播图")
    @GetMapping("/{id}")
    public Result<WheelItemsVO> getWheelItems(@PathVariable("id") Integer id) {
        return wheelItemsService.getWheelItems(id);
    }

}


