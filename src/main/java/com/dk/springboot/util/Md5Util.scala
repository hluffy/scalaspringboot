package com.dk.springboot.util

import java.security.MessageDigest

import sun.misc.BASE64Encoder

object Md5Util {
    def md5String(str:String):String = {
        val md5 = MessageDigest.getInstance("MD5")
        val base64 = new BASE64Encoder
        base64.encode(md5.digest(str.getBytes("utf-8")))
    }

    def main(args: Array[String]): Unit = {
        val str = "admin"
        println(md5String(str))
    }

}
