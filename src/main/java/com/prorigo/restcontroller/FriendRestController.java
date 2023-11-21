package com.prorigo.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prorigo.model.FriendsInfo;

import com.prorigo.service.FriendService;

@RestController
public class FriendRestController {

	private static final Logger logger=LoggerFactory.getLogger(FriendRestController.class);
	
	@Autowired
	private FriendService friendService;
	
	
	

	@PostMapping("/savefriend")
	public ResponseEntity<String> addFriend(@RequestBody FriendsInfo friendInfo) {
		logger.info("Recieved Request to add friend : {}",friendInfo.toString()); 
		friendService.saveFriend(friendInfo);
		 return new ResponseEntity<>("Friend saved ",HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<FriendsInfo>> getAllFriends(){
		logger.info("Recieved Request to get all friend"); 
		List<FriendsInfo> info=friendService.getAllFriends();
		return new ResponseEntity<>(info,HttpStatus.OK);
	}
	

	
	@PutMapping("update/{id}")
	public ResponseEntity<FriendsInfo> updateBirthday(@PathVariable Long id, @RequestBody FriendsInfo updatedBirthday) {
		logger.info("Recieved Request to update friend by with ID {},{}",id,updatedBirthday); 
		FriendsInfo existingBirthday = friendService.getBirthdayById(id);
 
		if (existingBirthday == null) {
			
			logger.warn("Friend with ID {} not found for update",id);
			return ResponseEntity.notFound().build();
		}
 
		existingBirthday.setName(updatedBirthday.getName());
		existingBirthday.setDateOfBirth(updatedBirthday.getDateOfBirth());
		existingBirthday.setMail(updatedBirthday.getMail());
 
		// Save the updated birthday
		friendService.updateBirthday(existingBirthday);
        logger.info("Friend with ID{} updated successfully",id);
		return ResponseEntity.ok(existingBirthday);
	
}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteFriendInfo(@PathVariable Long id){
		logger.info("Received request to delete friend with ID {}",id);
		String status =friendService.deleteFriendById(id);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
}
