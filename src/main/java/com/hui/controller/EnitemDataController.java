package com.hui.controller;


import com.hui.domain.Result;
import com.hui.domain.po.EnitemData;
import com.hui.service.IEnitemDataService;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/enitemdata")
@RequiredArgsConstructor
@Tag(name = "enitemdata", description = "enitemdata api")
public class EnitemDataController {

    private final IEnitemDataService enitemDataService;

    @Operation(summary = "获取enitemdata数据")
    @GetMapping("/{categoryId}/{item}")
    public Result<EnitemData> getEnitemData(@PathVariable Integer categoryId, @PathVariable String item) {
       return enitemDataService.getEnitemData( categoryId,   item);
    }

}
