package com.hui.mapper;

import com.hui.domain.po.Contact;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hui
 * @since 2024-10-22
 */
@Mapper
public interface ContactMapper extends BaseMapper<Contact> {

}
