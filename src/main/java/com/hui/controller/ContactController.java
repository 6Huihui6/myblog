package com.hui.controller;


import com.hui.domain.Result;
import com.hui.domain.po.Contact;
import com.hui.service.IContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/contact")
@RequiredArgsConstructor
@Tag(name = "Contact", description = "Contact API")
public class ContactController {

    private final IContactService contactService;

    @Operation(summary = "获取联系方式")
    @GetMapping()
    public Result<List<Contact>> getContact(){
       return contactService.getContact();
    }

    @Operation(summary = "插入联系方式")
    @PostMapping()
    public void insertContact(@RequestBody Contact contact){
        contactService.save(contact);
    }

}
