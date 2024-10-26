package com.hui.service.impl;

import com.hui.domain.Result;
import com.hui.domain.po.Lifecontents;
import com.hui.enums.AppHttpCodeEnum;
import com.hui.mapper.LifecontentsMapper;
import com.hui.service.ILifecontentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hui
 * @since 2024-10-21
 */
@Service
public class LifecontentsServiceImpl extends ServiceImpl<LifecontentsMapper, Lifecontents> implements ILifecontentsService {

    /**
     * 根据id获取详情
     *
     * @param id
     * @return
     */
    @Override
    public Result<Lifecontents> getLifecontentsById(Integer id) {
        Lifecontents lifecontents = getById(id);
        if (lifecontents == null) {
            return Result.errorResult(AppHttpCodeEnum.AP_USER_DATA_NOT_EXIST);
        }
        return Result.success(lifecontents);
    }
}
