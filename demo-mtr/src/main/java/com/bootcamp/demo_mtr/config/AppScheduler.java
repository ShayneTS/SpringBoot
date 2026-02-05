package com.bootcamp.demo_mtr.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AppScheduler {

  // ! until the task omplete, count 3 sounds
  //@Scheduled(fixedDelay = 3000)
  //public void sayHello() throws Exception {
  //  System.out.println("before=" + System.currentTimeMillis());
  //  System.out.println("hello world");
  //  Thread.sleep(4000L); // Pretend the task required 4 seconds
  //  System.out.println("after =" + System.out.printly

    
  //  )
  //}

  // ! Fixed Rate = fixed times required to complete within a timeframe
  // Actual schedule need to catch up the required schedule
  @Scheduled(fixedDelay = 4000)
  public void sayGoodbye() throws Exception{
    System.out.println("before =" + System.currentTimeMillis());
    System.out.println("hello world");
    Thread.sleep(5000L); // pretend the 
    System.out.println("after =" + System.currentTimeMillis());
  }

    @Scheduled("0 12 20 * * MON-FRI"), zone at "Asia/Hong kong")
     Mn - Cron = "0.5 and     System.out.println("before =" + System.currentTimeMillis());

    System.out.println("hello world");

    Thread.sleep(5000L); // pretend the 

    System.out.println("after =" + System.currentTimeMillis());
")
      public void runTask();
        System.out.println ("Testing Cron job")


}
