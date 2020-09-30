package com.baomidou.samples.metainfo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.samples.metainfo.entity.School;
import com.baomidou.samples.metainfo.mapper.SchoolMapper;
import com.baomidou.samples.metainfo.service.ISchoolService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dawn
 * @since 2020-09-30
 */
@Service
public class SchoolServiceImpl extends ServiceImpl<SchoolMapper, School> implements ISchoolService {

}
