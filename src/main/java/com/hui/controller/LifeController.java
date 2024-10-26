package com.hui.controller;


import com.hui.domain.Result;
import com.hui.domain.po.Life;
import com.hui.service.ILifeService;
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
@RequestMapping("/life")
@RequiredArgsConstructor
@Tag(name = "生活", description = "生活相关接口")
public class LifeController {

    private final ILifeService lifeService;

    @GetMapping
    @Operation(summary = "获取生活信息")
    public Result<List<Life>> getLife(){
       return lifeService.getLife();
    }

    @GetMapping("/{id}")
    @Operation(summary = "获取生活信息")
    public Result<List<Life> >getLifeById(@PathVariable Integer id){
        return lifeService.getLifeById(id);
    }

}
