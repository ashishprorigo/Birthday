//package com.prorigo.emailservice;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import com.prorigo.model.FriendsInfo;
//import com.prorigo.repository.FriendRepository;
//
//import jakarta.mail.MessagingException;
//import jakarta.mail.internet.MimeMessage;
//
//
//public class BirthdayReminderService {
//
//    @Autowired
//    private FriendRepository friendRepository;
//
//    @Autowired
//    private JavaMailSender javaMailSender;
//    
//   @Autowired
//    private BirthdayReminder reminder;
//   
//   
//  
//
//	    @Autowired
//	 private BirthdayReminderService reminderService;
//
//	
//	   // @Scheduled(cron = "0 0 8 * * ?") // Schedule the task to run at 8:00 AM every day
//	    //@Scheduled(cron="*/10 * * * * *")
//	     @Scheduled(cron= "* * * * * *")
//	    public void sendBirthdayReminders() {
//	        reminder.sendBirthdayReminder();
//	    }
//	}
//
//   // @Scheduled(cron = "0 0 0 * * *") // Run at midnight every day
//    //@Scheduled(cron = "0 * * * * *")
////    @Scheduled(cron= "* * * * * *")
//      // @Scheduled(*/10 * * * * *) for every 10 sec
////    public void sendBirthdayReminders() {
////        List<FriendsInfo> upcomingBirthdays = reminder.checkUpcomingBirthdays();
////        
////        for (FriendsInfo friendsInfo : upcomingBirthdays) {
////        	reminder.sendEmailReminder();
////        }
////    }
//
////    private void sendReminderEmail(FriendsInfo friendsInfo) {
////        try {
////            MimeMessage message = javaMailSender.createMimeMessage();
////            MimeMessageHelper helper = new MimeMessageHelper(message, true);
////
////            helper.setTo(friendsInfo.getMail());
////            helper.setSubject("Birthday Reminder: " + friendsInfo.getName());
////            helper.setText("Wishing you a happy birthday, " + friendsInfo.getName() + "!", true);
////
////            javaMailSender.send(message);
////        } catch (MessagingException e) {
////            e.printStackTrace();
////        }
////    }
