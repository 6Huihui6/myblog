package com.hui.controller;


import com.hui.domain.Result;
import com.hui.domain.po.Music;
import com.hui.service.IMusicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hui
 * @since 2024-10-22
 */
@RestController
@RequestMapping("/music")
@RequiredArgsConstructor
@Tag(name = "音乐模块", description = "音乐相关接口")
public class MusicController {

    private final IMusicService musicService;

    @Operation(summary = "获取所有音乐")
    @GetMapping
    public Result<List<Music> >getMusics() {
        return musicService.getMusics();
    }


    @Operation(summary = "获取歌曲")
    @GetMapping("/{id}")
    public  Result<Music> getMusicById(@PathVariable ("id") Integer id){
        return musicService.getMusicById(id);
    }


}
