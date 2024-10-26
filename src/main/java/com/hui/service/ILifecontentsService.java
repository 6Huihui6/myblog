package com.hui.service;

import com.hui.domain.Result;
import com.hui.domain.po.Lifecontents;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hui
 * @since 2024-10-21
 */
public interface ILifecontentsService extends IService<Lifecontents> {

    /**
     * 根据id获取详情
     * @param id
     * @return
     */
    Result<Lifecontents> getLifecontentsById(Integer id);
}
