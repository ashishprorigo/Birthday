package com.prorigo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prorigo.model.FriendsInfo;

@Repository
public interface FriendRepository extends JpaRepository<FriendsInfo, Long> {

	//List<FriendsInfo> findByDOB(int month, int day);
	
	@Query("SELECT f from FriendsInfo f where MONTH(f.dateOfBirth)= :month AND DAY(f.dateOfBirth) = :day")
    List<FriendsInfo> findByDateOfBirthMonthAndDateOfBirthDay(int month, int day);

}
 