package com.hui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hui.domain.Result;
import com.hui.domain.po.EnitemData;
import com.hui.enums.AppHttpCodeEnum;
import com.hui.mapper.EnitemDataMapper;
import com.hui.service.IEnitemDataService;
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
public class EnitemDataServiceImpl extends ServiceImpl<EnitemDataMapper, EnitemData> implements IEnitemDataService {

    /**
     * 获取数据
     *
     * @return
     */
    @Override
    public Result<EnitemData> getEnitemData(Integer categoryId,  String item) {
        QueryWrapper<EnitemData> enitemDataQueryWrapper = new QueryWrapper<>();
        enitemDataQueryWrapper.eq("en_id", categoryId).eq("item_name", item);
        EnitemData enitemData = this.getOne(enitemDataQueryWrapper);
        if (enitemData== null) {
            return Result.errorResult(AppHttpCodeEnum.AP_USER_DATA_NOT_EXIST);
        }
        return Result.success(enitemData);
    }
}
