package com.dk.springboot.newresult

import scala.beans.BeanProperty

class Result {
    @BeanProperty
    var id:Long = _

    @BeanProperty
    var status:Boolean = false

    @BeanProperty
    var message:String = _

    @BeanProperty
    var data:Any = _

    @BeanProperty
    var count:Long = 1

}
