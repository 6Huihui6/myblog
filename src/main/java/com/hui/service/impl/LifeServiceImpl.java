package com.hui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hui.domain.Result;
import com.hui.domain.po.Life;
import com.hui.enums.AppHttpCodeEnum;
import com.hui.mapper.LifeMapper;
import com.hui.service.ILifeService;
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
public class LifeServiceImpl extends ServiceImpl<LifeMapper, Life> implements ILifeService {

    /**
     * 获取生活信息
     *
     * @return
     */
    @Override
    public Result<List<Life>> getLife() {
        List<Life> list = list();
        if (list==null || list.size() == 0){
            return Result.errorResult(AppHttpCodeEnum.AP_USER_DATA_NOT_EXIST);
        }
        return Result.success(list);
    }

    /**
     * 获取生活信息
     *
     * @param id
     * @return
     */
    @Override
    public Result<List<Life>> getLifeById(Integer id) {
        QueryWrapper<Life> wrapper = new QueryWrapper<Life>().eq("li_id", id);
        List<Life> list = list(wrapper);
        if (list==null || list.size() == 0){
            return Result.errorResult(AppHttpCodeEnum.AP_USER_DATA_NOT_EXIST);
        }
        return Result.success(list);
    }
}
