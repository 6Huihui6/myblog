package com.hui.controller;


import com.hui.domain.Result;
import com.hui.domain.po.Earnedbadges;
import com.hui.service.IEarnedbadgesService;
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
 * @since 2024-10-21
 */
@RestController
@RequestMapping("/earnedbadges")
@RequiredArgsConstructor
@Tag(name = "earnedbadges", description = "获取用户已获得的徽章")
public class EarnedbadgesController {

    private final IEarnedbadgesService earnedbadgesService;

    @Operation(summary = "获取用户已获得的project")
    @GetMapping()
    public Result<List<Earnedbadges>> getEarnedBadges( ) {
       return earnedbadgesService.getEarnedBadges();
    }


}
