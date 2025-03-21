package com.hui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hui.domain.Result;
import com.hui.domain.po.Life;
import com.hui.domain.po.Lifecontents;
import com.hui.enums.AppHttpCodeEnum;
import com.hui.mapper.LifeMapper;
import com.hui.mapper.LifecontentsMapper;
import com.hui.service.ILifeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.service.ILifecontentsService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class LifeServiceImpl extends ServiceImpl<LifeMapper, Life> implements ILifeService {

    private final LifecontentsMapper lifecontentsMapper;


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
    public Result<List<Lifecontents>> getLifeById(Integer id) {

        QueryWrapper<Lifecontents> wrapper = new QueryWrapper<Lifecontents>().eq("li_id", id).orderByDesc("id");
        List<Lifecontents> list = lifecontentsMapper.selectList(wrapper);
        if (list==null || list.size() == 0){
            return Result.errorResult(AppHttpCodeEnum.AP_USER_DATA_NOT_EXIST);
        }
        return Result.success(list);
    }
}
