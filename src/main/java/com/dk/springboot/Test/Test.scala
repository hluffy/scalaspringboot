package com.dk.springboot.Test

import com.dk.springboot.util.DBConnectionPool


class Test {

}

object Test {
    def main(args: Array[String]): Unit = {
        val conn = DBConnectionPool.getConn()
        println(conn)
    }
}
