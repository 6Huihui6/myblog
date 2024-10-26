package com.hui.service;

import com.hui.domain.Result;
import com.hui.domain.po.Life;
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
public interface ILifeService extends IService<Life> {

    /**
     * 获取生活信息
     * @return
     */
    Result<List<Life>> getLife();

    /**
     * 获取生活信息
     * @param id
     * @return
     */
    Result<List<Life>> getLifeById(Integer id);
}
