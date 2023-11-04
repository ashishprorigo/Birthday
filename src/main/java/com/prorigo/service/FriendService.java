package com.prorigo.service;

import java.util.List;

import com.prorigo.model.FriendsInfo;

public interface FriendService {

	List<FriendsInfo> getAllFriends();
	public String saveFriend(FriendsInfo friendInfo);
	public String deleteFriendById(long id);
	public FriendsInfo getFriendById(long id);
}   
