package com.baomidou.samples.metainfo;

import com.baomidou.samples.metainfo.entity.School;
import com.baomidou.samples.metainfo.service.ISchoolService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author dawn
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SchoolTest {

	@Resource
	private ISchoolService schoolService;

	@Test
	public void fill() {
		School school = new School();
		school.setName("上海闵行一中");
		school.setLocation("闵行");
		assert schoolService.save(school);
		System.out.println(school);
		schoolService.updateById(school);
	}

	@Test
	public void insertStrategy() {
		School school = new School();
		school.setName("");
		school.setLocation("");
		assert schoolService.save(school);
		System.out.println(school);
	}

	@Test
	public void updateStrategy() {
		School school = new School();
		school.setId(1311219614360829953L);
		school.setName("");
		school.setLocation("");
		assert schoolService.updateById(school);
		System.out.println(school);
	}

}
