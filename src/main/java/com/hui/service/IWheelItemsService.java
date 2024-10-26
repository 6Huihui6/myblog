package com.hui.service;

import com.hui.domain.Result;
import com.hui.domain.VO.WheelItemsVO;
import com.hui.domain.po.WheelItems;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 轮播图 服务类
 * </p>
 *
 * @author hui
 * @since 2024-10-21
 */
public interface IWheelItemsService extends IService<WheelItems> {

    /**
     * 获取轮播图
     * @param id
     * @return
     */
    Result<WheelItemsVO> getWheelItems(Integer id);
}
