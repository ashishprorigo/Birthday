package com.prorigo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prorigo.model.FriendsInfo;
import com.prorigo.service.FriendService;

//@Controller
public class FriendController {

	@Autowired
	private FriendService friendService;
	
	// display List of friends
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listFriend", friendService.getAllFriends());
		return "index";
	}
	@GetMapping("/newFriend")
	public String addNewFriend(Model model) {
		FriendsInfo friendInfo=new FriendsInfo();
		model.addAttribute("friendsInfo", friendInfo);
		return "new_friend";
	}
	@PostMapping("/saveFriend")
	public String saveFriend(@ModelAttribute("friendsInfo") FriendsInfo friendInfo) {
		friendService.saveFriend(friendInfo);
		return "new_friend";
	}
	@GetMapping("/all")
	public String viewAllFriend(Model model) {
		model.addAttribute("listFriend", friendService.getAllFriends());
		return "all_Friends";
	}
	
	@GetMapping("/deleteFriend/{id}")
	public String deleteFriendInfo(@PathVariable (value="id") long id) {
		friendService.deleteFriendById(id);
		return "redirect:/";
		
	}
	
	@GetMapping("/updateFriend/{id}")
	public String showFormForUpdateFriend(@PathVariable (value="id") long id,Model model) {
		
		FriendsInfo info =friendService.getFriendById(id);
		model.addAttribute("friendsInfo",info );
		return "update_friend";
	}
}
