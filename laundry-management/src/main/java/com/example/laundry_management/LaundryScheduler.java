package com.example.laundry_management;

import com.example.laundry_management.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


@Component
public class LaundryScheduler implements CommandLineRunner {

        @Autowired
        private StudentService studentService;

        private Map<Integer, LocalDate> floorSchedule = new HashMap<>();

        @Override
        public void run(String... args) throws Exception {
            for (int i = 1; i <= 17; i++) {
                floorSchedule.put(i, LocalDate.now().minusDays(i));
            }
        }

        @Scheduled(cron = "0 0 0 * * ?")
        public void scheduleLaundry() {
            LocalDate today = LocalDate.now();
            for (int i = 1; i <= 17; i++) {
                if (floorSchedule.get(i).plusDays(15).isBefore(today)) {
                    System.out.println("Today's laundry for floor: " + i);
                    floorSchedule.put(i, today);
                }
            }
        }
    }

