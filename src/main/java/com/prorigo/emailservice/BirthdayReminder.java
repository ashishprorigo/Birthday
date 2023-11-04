package com.prorigo.emailservice;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import com.prorigo.model.FriendsInfo;
import com.prorigo.repository.FriendRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Configuration
@EnableScheduling
public class BirthdayReminder {
	
	@Autowired
    private JavaMailSender javaMailSender;

	  @Autowired
	    private FriendRepository friendRepository;
         
//	    // @Scheduled(cron = "0 * * * * *")
//	    //@Scheduled(cron = "0 0 0 * * *") // This example runs at midnight every day
//	    public List<FriendsInfo> checkUpcomingBirthdays() {
//	        LocalDate today = LocalDate.now();
//	        List<FriendsInfo> upcoming = friendRepository.findByDOB(today);
//
//	        for (FriendsInfo friendInfo : upcoming) {
//	            // Send birthday reminders or perform any necessary actions
//	            System.out.println("Birthday Reminder: " +friendInfo.getName() + " has a birthday today!");
//	        }
//	        return upcoming;
//	    }
	  
	 
//	  public void sendBirthdayReminders() {
//	        sendBirthdayReminder();
//	    }
//	    
	  //@Scheduled(cron= "* * * * * *") for Every second
	 // @Scheduled(cron = "0 0 0 * * *")at 12 midnight
	  // @Scheduled(cron="*/10 * * * * *") //for every 10 sec.
	    public void sendBirthdayReminder() {
	        // Get the current date
	        Calendar currentDate = Calendar.getInstance();
	        int currentMonth = currentDate.get(Calendar.MONTH) + 1;
	        int currentDay = currentDate.get(Calendar.DAY_OF_MONTH);

	        // Find people with birthdays today
	        List<FriendsInfo> peopleWithBirthdays = friendRepository.findByDateOfBirthMonthAndDateOfBirthDay(currentMonth, currentDay);

	        for (FriendsInfo friendsInfo : peopleWithBirthdays) {
	            // Calculate remaining days until the next birthday
	            int remainingDays = calculateRemainingDaysUntilNextBirthday(friendsInfo.getDateOfBirth());

	            // Send email reminder
	            sendEmailReminder(friendsInfo, remainingDays);
	        }
	    }

//	    private int calculateRemainingDaysUntilNextBirthday(LocalDate dateOfBirth) {
//			// TODO Auto-generated method stub
//			return 0;
//		}

		public int calculateRemainingDaysUntilNextBirthday(Date DOB) {
	        // Implement the remaining days calculation logic (similar to the previous example).
	        // ...
	    	   Calendar birthDate = new GregorianCalendar();
	           birthDate.setTime(DOB);

	           // Get the current date
	           Calendar currentDate = Calendar.getInstance();

	           // Calculate the next birthday's year
	           int currentYear = currentDate.get(Calendar.YEAR);
	           int birthYear = birthDate.get(Calendar.YEAR);
	           int nextBirthdayYear = currentYear;

	           if (birthDate.get(Calendar.DAY_OF_YEAR) > currentDate.get(Calendar.DAY_OF_YEAR)) {
	               // The birthday is still upcoming this year
	               nextBirthdayYear = currentYear;
	           } else {
	               // The birthday has already passed this year, so calculate for the next year
	               nextBirthdayYear = currentYear + 1;
	           }

	           birthDate.set(Calendar.YEAR, nextBirthdayYear);

	           // Calculate the next birthday date
	           Date nextBirthday = birthDate.getTime();

	           // Calculate the remaining days until the next birthday
	           long diffInMilliseconds = nextBirthday.getTime() - currentDate.getTimeInMillis();
	           int remainingDays = (int) (diffInMilliseconds / (24 * 60 * 60 * 1000));


	        return remainingDays;
	    }

//	    public void sendEmailReminder(FriendsInfo friendsInfo, int remainingDays) {
//	    	
//	    	   try {
//	               MimeMessage message = javaMailSender.createMimeMessage();
//	               MimeMessageHelper helper = new MimeMessageHelper(message, true);
//
//	               helper.setTo(friendsInfo.getMail());
//	               helper.setSubject("Birthday Reminder: " + friendsInfo.getName());
//	               helper.setText("Wishing you a happy birthday, " + friendsInfo.getName() + "!", true);
//	               
//
//	               javaMailSender.send(message);
//	           } catch (MessagingException e) {
//	               e.printStackTrace();
//	           }
//	      
//	    }
//		
		public void sendEmailReminder(FriendsInfo friendInfo,int remainingDays) {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("wagha5624@gmail.com");;
			message.setTo(friendInfo.getMail());
			message.setSubject("Birthday Reminder: " + friendInfo.getName());
			message.setText("Wishing you a Happy Birthday, " + friendInfo.getName() + "!");
			 javaMailSender.send(message);
			 System.out.println("mail sent successfully");
		}
		
	}

