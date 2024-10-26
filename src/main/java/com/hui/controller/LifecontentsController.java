package com.hui.controller;


import com.hui.domain.Result;
import com.hui.domain.po.Lifecontents;
import com.hui.service.ILifecontentsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hui
 * @since 2024-10-21
 */
@RestController
@RequestMapping("/lifecontents")
@RequiredArgsConstructor
@Tag(name = "生活内容", description = "生活内容相关接口")
public class LifecontentsController {

    private final ILifecontentsService lifecontentsService;

    @GetMapping("/{id}")
    public Result<Lifecontents> getLifecontentsById(@PathVariable Integer id){
       return lifecontentsService.getLifecontentsById(id);
    }

}
