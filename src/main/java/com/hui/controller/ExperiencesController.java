package com.hui.controller;


import com.hui.domain.Result;
import com.hui.domain.VO.ExperiencesVO;
import com.hui.domain.po.Experiences;
import com.hui.service.IExperiencesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hui
 * @since 2024-10-21
 */
@RestController
@RequestMapping("/experiences")
@RequiredArgsConstructor
@Tag(name = "经历管理", description = "经历管理接口")
public class ExperiencesController {

    private final IExperiencesService experiencesService;

    @GetMapping()
    public Result<List<ExperiencesVO>> getExperiences() {
        return experiencesService.getExperiences();
    }


}
