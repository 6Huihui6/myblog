package com.hui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hui.domain.Result;
import com.hui.domain.po.Contact;
import com.hui.mapper.ContactMapper;
import com.hui.service.IContactService;
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
public class ContactServiceImpl extends ServiceImpl<ContactMapper, Contact> implements IContactService {

    /**
     * 获取xinix列表
     *
     * @return
     */
    @Override
    public Result<List<Contact>> getContact() {
        QueryWrapper<Contact> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("created_time");
        List<Contact> list = list(wrapper);
        return Result.success(list);
    }
}
