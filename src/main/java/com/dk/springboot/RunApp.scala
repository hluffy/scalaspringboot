package com.dk.springboot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class RunApp {

}

object RunApp {
    def main(args: Array[String]): Unit = {
        SpringApplication.run(classOf[RunApp], args:_*)
    }
}
