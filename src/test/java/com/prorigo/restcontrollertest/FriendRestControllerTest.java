package com.prorigo.restcontrollertest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
import java.util.Arrays;
import java.util.Date;
import java.util.List;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prorigo.model.FriendsInfo;
import com.prorigo.restcontroller.FriendRestController;
import com.prorigo.service.FriendService;
 
//@RunWith(SpringRunner.class)
//@WebMvcTest(value=FriendRestController.class)
public class FriendRestControllerTest {
 

//@Autowired
//private MockMvc mvc;
//
//@MockBean
//private FriendService friendService;

@Mock
private FriendService friendService; //Assuming you have a FriendService to mock

@InjectMocks
private FriendRestController controller; //Assuming your controller is named YourController

//@Test
//public void testAddFriend() {
//	// Create a sample FriendInfo object for testing
//	FriendsInfo friendsInfo = new FriendsInfo();
//	// mock the behaviour of the friendService.saveFriend method
//	doNothing().when(friendService).saveFriend(friendsInfo);
//	
//	//call the controller method
//	ResponseEntity<FriendsInfo> response = controller.addFriend(friendsInfo);
//	
//	// verify that the saveFriend was called with the correct argument
//	verify(friendService, times(1)).saveFriend(friendsInfo);
//	
//	// verify the response has a status code of HttpStatus.CREATED
//	assertEquals(HttpStatus.CREATED, response.getStatusCode());
//	
//}
	
 
//@Test
//void testAddFriend() throws Exception {
//	FriendsInfo mockFriendsInfo=new FriendsInfo();
//	mockFriendsInfo.setId(1);
//	mockFriendsInfo.setName("raj");
//	mockFriendsInfo.setDateOfBirth(new Date());
//	mockFriendsInfo.setMail("abc@gmail.com");
//	
//	String inputInJson=this.mapToJson(mockFriendsInfo);
//	String URI="/savefriend";
//	//Mockito.when(friendService.saveFriend(Mockito.any(FriendsInfo.class))).thenReturn(mockFriendsInfo);
//	//Mockito.when(friendService.saveFriend(Mockito.any(FriendsInfo.class)))
//	//.thenReturn(new ResponseEntity<FriendsInfo>);
//
//	
//	RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON)
//			.content(inputInJson);
//	
//	MvcResult result=mvc.perform(requestBuilder).andReturn();
//	
//	MockHttpServletResponse response=result.getResponse();
//
//	String outputInJson =response.getContentAsString();
//	
//	assertThat(outputInJson).isEqualTo(inputInJson);
//	assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//	
//}




private String mapToJson(Object object) throws JsonProcessingException {
	ObjectMapper objectMapper=new ObjectMapper();
	return objectMapper.writeValueAsString(object);
}
 

}