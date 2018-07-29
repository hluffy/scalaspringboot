package com.dk.springboot.entity

import javax.persistence._

import scala.beans.BeanProperty

/**
  * 市
  */
@Entity(name="city")
@Table(name="city")
class City {
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

//    @Column(name="provincecode")
//    @BeanProperty
//    var provinceCode:Long = _

    @Column(name="polygon")
    @BeanProperty
    var polygon:String = _

    @Transient
    @BeanProperty
    var countryName:String = "中国"

    @Transient
    @BeanProperty
    var provinceName:String = _

//    @Transient
//    @BeanProperty
//    var province:Province = new Province

    @ManyToOne(cascade = Array(CascadeType.MERGE,CascadeType.REFRESH),optional = false)
    @JoinColumn(name="provincecode")
    @BeanProperty
    var province:Province = _

    @ManyToOne(cascade = Array(CascadeType.MERGE,CascadeType.REFRESH),optional = false)
    @JoinColumn(name="countrycode",insertable = false,updatable = false)
    @BeanProperty
    var country:Country = _

}
