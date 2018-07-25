package com.dk.springboot.Test

import com.dk.springboot.until.DBConnectionPool


class Test {

}

object Test {
    def main(args: Array[String]): Unit = {
        val conn = DBConnectionPool.getConn()
        println(conn)
    }
}
