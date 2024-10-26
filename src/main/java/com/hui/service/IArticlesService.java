package com.hui.service;

import com.hui.domain.Result;
import com.hui.domain.po.Articles;
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
public interface IArticlesService extends IService<Articles> {


    /**
     * 获取文章列表
     * @return
     */
    Result<List<Articles>> getArticleList();

    /**
     * 根据id获取文章详情
     * @param id
     * @return
     */
    Result<Articles> getArticleById(Integer id);
}
