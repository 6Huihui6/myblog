package com.hui.controller;


import com.hui.domain.Result;
import com.hui.domain.po.Social;
import com.hui.service.ISocialService;
import io.swagger.v3.oas.annotations.Operation;
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
 * @since 2024-10-22
 */
@RestController
@RequestMapping("/social")
@RequiredArgsConstructor
@Tag(name = "社交模块", description = "社交模块相关接口")
public class SocialController {

    private final ISocialService socialService;

    @Operation(summary = "获取所有社交信息")
    @GetMapping()
    public Result<List<Social>> getAllSocials() {
        List<Social> socials = socialService.list();
        return Result.success(socials);
    }

}
