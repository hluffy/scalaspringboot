package com.dk.springboot.task

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

/**
  * 定时任务
  */
@Component
class ScheduledTask {

    @Scheduled(cron = "0/5 * * * * *")
    def scheduledTash = println("定时任务，现在时间"+System.currentTimeMillis())

}
