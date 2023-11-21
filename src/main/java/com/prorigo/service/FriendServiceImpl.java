package com.prorigo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prorigo.model.FriendsInfo;
import com.prorigo.repository.FriendRepository;

@Service
public class FriendServiceImpl implements FriendService {
	
	private static final Logger logger=LoggerFactory.getLogger(FriendServiceImpl.class);
	
	@Autowired
	private FriendRepository friendRepository;

	

	@Override
	public List<FriendsInfo> getAllFriends() {
		
		logger.info("Fetching all friends");
		return friendRepository.findAll();
	}

	@Override
	public String saveFriend(FriendsInfo friendInfo) {
		friendRepository.save(friendInfo);
		logger.info("Friend Saved Successfully: {}",friendInfo.toString());
		return "friend Saved Successfully";
	}

	@Override
	public String deleteFriendById(long id) {
		if (friendRepository.existsById(id)) {
			friendRepository.deleteById(id);
			logger.info("Friend deleted successfully with ID: {}",id);
			return "deleted successfully";
		} else {
			logger.warn("No record found for ID: {}",id);
			return "No record Found";
	}
	}



	public FriendsInfo getBirthdayById(long id) {
		FriendsInfo friendsInfo=friendRepository.findById(id).orElse(null);
		logger.info("Birthday retrieved for ID {}: {}",id,friendsInfo);
		return friendsInfo;
		
	}

	@Override
	public FriendsInfo updateBirthday(FriendsInfo updatedBirthday) {
		FriendsInfo friendInfo=friendRepository.save(updatedBirthday);
		logger.info("Birthday Updated Successfully: {}",friendInfo);
		return friendInfo;
	}

}
