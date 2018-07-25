package com.dk.springboot.entity

import java.util.Date
import javax.persistence.{Entity, GeneratedValue, Id, Table}

import org.springframework.format.annotation.DateTimeFormat

import scala.beans.BeanProperty


@Entity(name = "users")
@Table(name="users")
class User extends Serializable {
    @Id
    @GeneratedValue
    @BeanProperty
    var id:Long = _

    @BeanProperty
    var name:String = _

    @BeanProperty
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var birthday:Date = _

    @BeanProperty
    var telephone:String = _

    override def toString: String = id+":"+name+":"+birthday+":"+telephone

}
