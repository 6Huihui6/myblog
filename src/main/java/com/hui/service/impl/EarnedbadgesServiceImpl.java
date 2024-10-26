package com.hui.service.impl;

import com.hui.domain.Result;
import com.hui.domain.po.Earnedbadges;
import com.hui.enums.AppHttpCodeEnum;
import com.hui.mapper.EarnedbadgesMapper;
import com.hui.service.IEarnedbadgesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
public class EarnedbadgesServiceImpl extends ServiceImpl<EarnedbadgesMapper, Earnedbadges> implements IEarnedbadgesService {

    /**
     * 获取所有获得的徽章
     *
     * @return
     */
    @Override
    public Result<List<Earnedbadges>> getEarnedBadges() {
        List<Earnedbadges> list = list();
        if (list == null || list.size() == 0) {
            return Result.errorResult(AppHttpCodeEnum.AP_USER_DATA_NOT_EXIST);
        }
        return Result.success(list);
    }
}
