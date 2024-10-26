package com.hui.controller;


import com.hui.domain.Result;
import com.hui.domain.po.Articles;
import com.hui.service.IArticlesService;
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
@RequestMapping("/articles")
@RequiredArgsConstructor
@Tag(name = "文章管理", description = "文章的增删改查")
public class ArticlesController {

    private final IArticlesService articlesService;

    @Operation(summary = "获取文章列表")
    @GetMapping
    public Result<List<Articles>> getArticleList() {
        return  articlesService.getArticleList();
    }

    @Operation(summary = "根据id获取文章")
    @GetMapping("/{id}")
    public Result<Articles> getArticleById(@PathVariable("id") Integer id) {
        return  articlesService.getArticleById(id);
    }


}
