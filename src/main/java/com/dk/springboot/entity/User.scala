package com.dk.springboot.entity


import java.util.Date
import javax.persistence.{Entity, GeneratedValue, Id, Table}

import org.hibernate.validator.constraints.NotBlank
import org.springframework.format.annotation.DateTimeFormat

import scala.beans.BeanProperty

@Table(name="users")
@Entity
class User {
    @Id
    @GeneratedValue
    @BeanProperty
    var id:Long = _

    @BeanProperty
    @NotBlank
    var name:String = _

    @BeanProperty
    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var birthday:Date = _

    @BeanProperty
    @NotBlank
    var telephone:String = _

    override def toString: String = "id = " + id + ",name = " + name + ",birthday = " + birthday + ",telephone = " + telephone


}
