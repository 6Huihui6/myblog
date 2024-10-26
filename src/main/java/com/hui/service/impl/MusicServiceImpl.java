package com.hui.service.impl;

import com.hui.domain.Result;
import com.hui.domain.po.Music;
import com.hui.mapper.MusicMapper;
import com.hui.service.IMusicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hui
 * @since 2024-10-22
 */
@Service
public class MusicServiceImpl extends ServiceImpl<MusicMapper, Music> implements IMusicService {

    /**
     * 获取所有歌曲
     *
     * @return
     * @throws Exception
     * @author hui
     */
    @Override
    public Result<List<Music>> getMusics() {
        List<Music> list = list();
        return Result.success(list);
    }

    /**
     * 根据id获取歌曲
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Result<Music> getMusicById(Integer id) {
        Music music = getById(id);
        return Result.success(music);
    }
}
