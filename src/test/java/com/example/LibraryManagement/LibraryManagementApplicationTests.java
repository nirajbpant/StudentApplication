package com.example.LibraryManagement;

import com.example.LibraryManagement.controller.LibraryController;
import com.example.LibraryManagement.controller.UserController;
import com.example.LibraryManagement.model.library.Library;
import com.example.LibraryManagement.model.library.LibraryService;
import com.example.LibraryManagement.model.user.User;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class LibraryManagementApplicationTests {

	@InjectMocks
	LibraryController libraryController;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(libraryController).build();
	}

	@Test
	public void testGetBooks() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get("/books")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.BOOK_NAME", Matchers.is("Introduction to Algorithm")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.imageURL", Matchers.is("assets/images/books/book.png")));


	}
}
