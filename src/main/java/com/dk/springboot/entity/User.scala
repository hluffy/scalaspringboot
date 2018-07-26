package com.dk.springboot.entity

import java.util.Date
import javax.persistence._

import org.hibernate.validator.constraints.NotBlank
import org.springframework.format.annotation.DateTimeFormat

import scala.beans.BeanProperty


@Entity(name = "users")
@Table(name="users")
class User extends Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @BeanProperty
    var id:Long = _

    @BeanProperty
    @NotBlank
    var name:String = _

    @BeanProperty
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var birthday:Date = _

    @BeanProperty
    var telephone:String = _

    @BeanProperty
    @NotBlank
    var password:String = _

    override def toString: String = id+":"+name+":"+birthday+":"+telephone+":"+password

}
