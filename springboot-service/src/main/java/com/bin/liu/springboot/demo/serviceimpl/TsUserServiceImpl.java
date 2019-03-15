package com.bin.liu.springboot.demo.serviceimpl;

import com.bin.liu.springboot.demo.entity.TsUser;
import com.bin.liu.springboot.demo.mapper.TsUserDao;
import com.bin.liu.springboot.demo.service.TsUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bin.liu123
 * @since 2019-03-15
 */
@Service
public class TsUserServiceImpl extends ServiceImpl<TsUserDao, TsUser> implements TsUserService {

}
