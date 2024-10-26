package com.hui.service;

import com.hui.domain.Result;
import com.hui.domain.po.Earnedbadges;
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
public interface IEarnedbadgesService extends IService<Earnedbadges> {

    /**
     * 获取所有获得的徽章
     * @return
     */
    Result<List<Earnedbadges>> getEarnedBadges();
}
