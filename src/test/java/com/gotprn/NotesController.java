package com.gotprn;

import static org.junit.Assert.assertEquals;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gotprn.service.NotesService;



/**
Author Abhishek Uniyal
Created Date May 16, 2018
Created Time 1:36:02 PM
*/

@RunWith(SpringRunner.class)
@WebMvcTest(value = NotesController.class, secure = false)
public class NotesController {

	@Autowired
	private MockMvc mockMvc;

	@MockBean(name = "notesService")
	private NotesService notesService;

	@Before
	public void setup() throws JsonProcessingException {
		// this.restTemplate = restTemplateManager.getTemplate();

	}

	@Test
	public void getNotesByUserIdAndNotesId(Long userId, Long notesId) throws Exception {

		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/notesService//user/3/notes/1")
				.accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();

		MockHttpServletResponse response = result.getResponse();

		System.out.println(response.getContentAsString());

		System.out.println(response.getContentType());

		assertEquals("Content Type is not Equal", "application_json;charset=UTF-8",
				response.getContentType());

	}
}
