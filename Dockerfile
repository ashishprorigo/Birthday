FROM openjdk:17
EXPOSE 9090
ADD target/BirthdayReminderApp-0.0.1-SNAPSHOT.jar BirthdayReminderApp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/BirthdayReminderApp-0.0.1-SNAPSHOT.jar"]