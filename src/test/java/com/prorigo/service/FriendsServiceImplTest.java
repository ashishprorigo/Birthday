package com.prorigo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.prorigo.model.FriendsInfo;
import com.prorigo.repository.FriendRepository;

@SpringBootTest
public class FriendsServiceImplTest {

    @Mock
	private FriendRepository friendRepository;
	
	@InjectMocks
	private FriendServiceImpl friendService;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@BeforeEach
	void setUp() {
	friendRepository = mock(FriendRepository.class);
	friendService = new FriendServiceImpl();
	}
	

	
	
	@org.junit.jupiter.api.Test
	public void testGetAllFriends() {
		
		List<FriendsInfo> mockFriendList=new ArrayList<FriendsInfo>();
		
		mockFriendList.add(new FriendsInfo(1,"raj",new Date(),"waghashish0007@gmail.com"));
		mockFriendList.add(new FriendsInfo(2,"raM",new Date(),"waghashish0007@gmail.com"));
		mockFriendList.add(new FriendsInfo(3,"shyam",new Date(),"waghashish0007@gmail.com"));
		
		when(friendRepository.findAll()).thenReturn(mockFriendList);
		
		List<FriendsInfo> result=friendService.getAllFriends();
		
		assertEquals(mockFriendList,result);
	}
	
	@org.junit.jupiter.api.Test
	public void testSaveFriend() {
		
		FriendsInfo info=new FriendsInfo();
		info.setId(1L);
		info.setName("Munna");
		info.setDateOfBirth(new Date());
		info.setMail("wagha5624@gmail.com");
		String result=friendService.saveFriend(info);
		
		assertEquals("friend Saved Successfully", result);
		
		verify(friendRepository,times(1)).save(info);
		
	}
	

	@org.junit.jupiter.api.Test
	public void testDeleteFriendById() {
	
	long friendIdToDelete = 1L;
	when(friendRepository.existsById(friendIdToDelete)).thenReturn(true);
	 
	
	String result = friendService.deleteFriendById(friendIdToDelete);
	 
	
	assertEquals("deleted successfully", result);
	verify(friendRepository, times(1)).deleteById(friendIdToDelete);
	}
	
	@org.junit.jupiter.api.Test
	public void testDeleteFriendByIdNotFound() {
	
	long friendIdToDelete = 1L;
	when(friendRepository.existsById(friendIdToDelete)).thenReturn(false);
	 

	String result = friendService.deleteFriendById(friendIdToDelete);
	 
	
	assertEquals("No record Found", result);
	verify(friendRepository, never()).deleteById(friendIdToDelete);
	}
	 
	@org.junit.jupiter.api.Test
	public void testUpdateBirthday() {
	
	FriendsInfo updatedFriend = new FriendsInfo();
	updatedFriend.setId(1L);
	updatedFriend.setName("Munna");
	updatedFriend.setDateOfBirth(new Date());
	updatedFriend.setMail("wagha5624@gmail.com");
	when(friendRepository.save(updatedFriend)).thenReturn(updatedFriend);
	 
	
	FriendsInfo result = friendService.updateBirthday(updatedFriend);
	 
	
	assertEquals(updatedFriend, result);
	verify(friendRepository, times(1)).save(updatedFriend);
	}
	}
	

