package com.hui.service.impl;

import com.hui.domain.Result;
import com.hui.domain.po.Articles;
import com.hui.enums.AppHttpCodeEnum;
import com.hui.mapper.ArticlesMapper;
import com.hui.service.IArticlesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hui
 * @since 2024-10-21
 */
@Service
public class ArticlesServiceImpl extends ServiceImpl<ArticlesMapper, Articles> implements IArticlesService {

    /**
     * 获取文章列表
     *
     * @return
     */
    @Override
    public Result<List<Articles>> getArticleList() {
        List<Articles> list = list();
        if (list == null || list.size() == 0) {
            return Result.errorResult(AppHttpCodeEnum.AP_USER_DATA_NOT_EXIST);
        }
        return Result.success(list);
    }

    /**
     * 根据id获取文章详情
     *
     * @param id
     * @return
     */
    @Override
    public Result<Articles> getArticleById(  Integer id) {
        if (id==null){
            return Result.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST);
        }
        Articles articles = getById(id);
        if (articles == null) {
            return Result.errorResult(AppHttpCodeEnum.AP_USER_DATA_NOT_EXIST);
        }
        return Result.success(articles);
    }
}
