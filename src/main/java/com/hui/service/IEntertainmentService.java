package com.hui.service;

import com.hui.domain.Result;
import com.hui.domain.VO.EntertainmentVO;
import com.hui.domain.po.Entertainment;
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
public interface IEntertainmentService extends IService<Entertainment> {

    /**
     * 获取娱乐信息
     * @return
     */
    Result<List<EntertainmentVO>> getEntertainment();

    /**
     * 获取娱乐信息
     * @param id
     * @return
     */
    Result<EntertainmentVO> getEntertainmentById(Integer id);
}
