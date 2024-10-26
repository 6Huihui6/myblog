package com.hui.service;

import com.hui.domain.Result;
import com.hui.domain.po.Contact;
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
public interface IContactService extends IService<Contact> {

        /**
     * 获取xinix列表
     * @return
     */
    Result<List<Contact>> getContact();
}
