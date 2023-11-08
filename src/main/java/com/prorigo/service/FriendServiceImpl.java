package com.prorigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prorigo.model.FriendsInfo;
import com.prorigo.repository.FriendRepository;

@Service
public class FriendServiceImpl implements FriendService{

	@Autowired
	private FriendRepository friendRepository;
	 
	@Override
	public List<FriendsInfo> getAllFriends() {
		return friendRepository.findAll();
		
	}

	@Override
	public String saveFriend(FriendsInfo friendInfo) {
		friendRepository.save(friendInfo);
		return "friend Saved Successfully";
	}

	@Override
	public String deleteFriendById(long id) {
		if(friendRepository.existsById(id)){
			friendRepository.deleteById(id);
			return "deleted successfully";
		}else
		return "No record Found";
	}

	@Override
	public FriendsInfo getFriendById(long id) {
		Optional<FriendsInfo> optional= friendRepository.findById(id);
		FriendsInfo info=null;
		if(optional.isPresent()) {
			info=optional.get();
		}else throw new RuntimeException("Friend Not Found For Id :: "+id);
		
		return info;
	}
	
		public FriendsInfo getBirthdayById(Long id) {
			return friendRepository.findById(id).orElse(null);
		}
	 
	   @Override
		public FriendsInfo updateBirthday(FriendsInfo updatedBirthday) {
			return friendRepository.save(updatedBirthday);
		}

}
