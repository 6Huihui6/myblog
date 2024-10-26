package com.hui.service.impl;

import com.hui.domain.Result;
import com.hui.domain.VO.WheelItemsVO;
import com.hui.domain.po.WheelItems;
import com.hui.enums.AppHttpCodeEnum;
import com.hui.mapper.WheelItemsMapper;
import com.hui.service.IWheelItemsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.utils.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 轮播图 服务实现类
 * </p>
 *
 * @author hui
 * @since 2024-10-21
 */
@Service
public class WheelItemsServiceImpl extends ServiceImpl<WheelItemsMapper, WheelItems> implements IWheelItemsService {

    /**
     * 获取轮播图
     *
     * @param id
     * @return
     */
    @Override
    public Result<WheelItemsVO> getWheelItems(Integer id) {
        if (id == null) {
            return Result.errorResult(AppHttpCodeEnum.PARAM_REQUIRE);
        }
        WheelItems wheelItems = this.getById(id);
        if (wheelItems == null) {
            return Result.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST);
        }
        WheelItemsVO wheelItemsVO = BeanUtils.copyBean(wheelItems, WheelItemsVO.class);
        String[] image = wheelItems.getImage().split(",");
        wheelItemsVO.setImage(image);
        return Result.success(wheelItemsVO);
    }
}
