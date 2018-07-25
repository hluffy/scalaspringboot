package com.dk.springboot.result


class Result extends Serializable {
    var id:Long = _

    var data:Any = _

    var count:Long = _

    var message:String = _

    var status:Boolean = false

    override def toString: String = id + ":" + data + ":" + count + ":" + message + ":" + status



}
