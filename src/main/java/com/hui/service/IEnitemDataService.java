package com.hui.service;

import com.hui.domain.Result;
import com.hui.domain.po.EnitemData;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hui
 * @since 2024-10-21
 */
public interface IEnitemDataService extends IService<EnitemData> {

    /**
     * 获取数据
     * @return
     */
    Result<EnitemData> getEnitemData(Integer categoryId,  String item);
}
