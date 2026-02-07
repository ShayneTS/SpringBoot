package com.bootcamp.demo_mtr.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AppScheduler {

  // ! Until the task complete, count 3 seconds
  // @Scheduled(fixedDelay = 3000)
  // public void sayHello() throws Exception {
  // System.out.println("before=" + System.currentTimeMillis());
  // System.out.println("hello world");
  // Thread.sleep(4000L); // Pretend the task required 4 seconds
  // System.out.println("after=" + System.currentTimeMillis());
  // }

  // ! Fix Rate = fixed times required to complete within a timeframe
  // Actual schedule need to catch up the required schedule
  @Scheduled(fixedRate = 4000)
  public void sayGoodbye() throws Exception {
    System.out.println("before=" + System.currentTimeMillis());
    System.out.println("hello world");
    Thread.sleep(5000L); // Pretend the task required 5 seconds
    System.out.println("after=" + System.currentTimeMillis());
  }


  // TBC
  @Scheduled(cron = "0 12 20 * * MON-FRI", zone = "Asia/Hong_Kong") 
  public void runTask() {
    System.out.println("Testing Cron Job");
  }
}