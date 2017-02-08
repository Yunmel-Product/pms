package com.yunmel.biz.plan.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.yunmel.Application;

/**
 * Created by chen on 2017/2/8.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class TestPalnController {
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void test() throws Exception{
		String link = "/plan/getTaskByUserId";
		String result = this.mvc.perform(MockMvcRequestBuilders.post(link).param("userId", "a000001066702815")).andReturn().getResponse().getContentAsString();
		System.out.println(result);
	}
}



















