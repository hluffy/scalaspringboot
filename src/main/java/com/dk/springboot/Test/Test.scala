package com.dk.springboot.Test

import com.dk.springboot.util.DBConnectionPool
import org.springframework.util.StringUtils


class Test {

}

object Test {
    def main(args: Array[String]): Unit = {
        val conn = DBConnectionPool.getConn()
        println(conn)

        println(StringUtils.isEmpty("    ".trim))
    }
}
