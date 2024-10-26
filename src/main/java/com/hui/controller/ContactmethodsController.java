package com.hui.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hui.domain.Result;
import com.hui.domain.po.Contactmethods;
import com.hui.service.IContactmethodsService;
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
@RequestMapping("/contactmethods")
@RequiredArgsConstructor
@Tag(name = "contactmethods", description = "留言信息接口")
public class ContactmethodsController {

    private final IContactmethodsService contactmethodsService;

    @Operation(summary = "获取所有留言信息")
    @GetMapping()
    public Result<List<Contactmethods> > getAllContactmethods() {
        List<Contactmethods> contactmethodsList = contactmethodsService.list();
        return Result.success(contactmethodsList);
    }


    }
