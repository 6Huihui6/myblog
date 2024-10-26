package com.hui.service.impl;

import com.hui.domain.Result;
import com.hui.domain.VO.EntertainmentVO;
import com.hui.domain.po.Entertainment;
import com.hui.enums.AppHttpCodeEnum;
import com.hui.mapper.EntertainmentMapper;
import com.hui.service.IEntertainmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.utils.BeanUtils;
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
public class EntertainmentServiceImpl extends ServiceImpl<EntertainmentMapper, Entertainment> implements IEntertainmentService {

    /**
     * 获取娱乐信息
     *
     * @return
     */
    @Override
    public Result<List<EntertainmentVO>> getEntertainment() {
        List<Entertainment> entertainments = this.list();
        if (entertainments == null || entertainments.size() == 0) {
            return Result.errorResult(AppHttpCodeEnum.AP_USER_DATA_NOT_EXIST);
        }
        List<EntertainmentVO> entertainmentVOS = BeanUtils.copyList(entertainments, EntertainmentVO.class);
        for (EntertainmentVO entertainmentVO : entertainmentVOS) {
            entertainmentVO.setItem(entertainmentVO.getItems().split(","));
        }
        return Result.success(entertainmentVOS);
    }

    /**
     * 获取娱乐信息
     *
     * @param id
     * @return
     */
    @Override
    public Result<EntertainmentVO> getEntertainmentById(Integer id) {
        if (id == null) {
            return Result.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST);
        }
        Entertainment entertainment = this.getById(id);
        if (entertainment == null) {
            return Result.errorResult(AppHttpCodeEnum.AP_USER_DATA_NOT_EXIST);
        }
        EntertainmentVO entertainmentVO = BeanUtils.copyProperties(entertainment, EntertainmentVO.class);
        entertainmentVO.setItem(entertainmentVO.getItems().split(","));
        return Result.success(entertainmentVO);
    }
}
