package com.baomidou.samples.metainfo;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.ibatis.annotations.Select;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.samples.metainfo.entity.User;
import com.baomidou.samples.metainfo.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * 自动填充测试
 *
 * @author nieqiurong 2018-08-10 23:47:02.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoFillTest {

	@Resource
	private UserMapper userMapper;

	@Test
	public void test() {
		User user = new User(null, "Tom", 1, "tom@qq.com", null);
		userMapper.insert(user);
//        log.info("query user:{}", userMapper.selectById(user.getId()));
//        User beforeUser = userMapper.selectById(user.getId());
//        log.info("before user:{}", beforeUser);
//        beforeUser.setAge(12);
//        userMapper.updateById(beforeUser);
//        log.info("query user:{}", userMapper.selectById(user.getId()));

		User user1 = new User();
		user1.setId(user.getId());
		user1.setAge(10);
		user1.setEmail("11111");
		LambdaUpdateWrapper<User> wrapper = Wrappers.<User>lambdaUpdate().set(User::getName, null);
		userMapper.update(user1, wrapper);

		log.info("query user:{}", userMapper.selectById(user.getId()));
	}
}
