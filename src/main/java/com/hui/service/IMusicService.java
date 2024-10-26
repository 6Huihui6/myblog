package com.hui.service;

import com.hui.domain.Result;
import com.hui.domain.po.Music;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hui
 * @since 2024-10-22
 */
public interface IMusicService extends IService<Music> {

    /**
     * 获取所有歌曲
     * @return
     * @throws Exception
     * @author hui
     */
    Result<List<Music>> getMusics();

    /**
     * 根据id获取歌曲
     * @param id
     * @return
     * @throws Exception
     * */
    Result<Music> getMusicById(Integer id);
}
