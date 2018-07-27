package com.dk.springboot.entity

import javax.persistence._

import scala.beans.BeanProperty

@Entity(name="province")
@Table(name="province")
class Province extends Serializable {
    @Id
    @GeneratedValue
    @Column(name="code")
    @BeanProperty
    var code:Long = _

    @Column(name="name")
    @BeanProperty
    var name:String = _

    @Column(name="countrycode")
    @BeanProperty
    var countryCode:Long = _

    @Column(name="polygon")
    @BeanProperty
    var polygon:String = _

    @Transient
    @BeanProperty
    var countryName:String = "中国"

    @Transient
    @BeanProperty
    var page:Int = _

    override def toString: String = code+":"+name+":"+countryCode+":"+polygon+":"+page

}
