package com.dk.springboot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableScheduling

//允许使用定时任务
//@EnableScheduling
@SpringBootApplication
class RunApp {

}

object RunApp {
    def main(args: Array[String]): Unit = {
        SpringApplication.run(classOf[RunApp], args:_*)
    }
}
