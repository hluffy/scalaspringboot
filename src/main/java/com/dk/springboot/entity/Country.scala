package com.dk.springboot.entity

import javax.persistence._

import scala.beans.BeanProperty

/**
  * 国家
  */
@Entity(name="country")
@Table(name="country")
class Country {
    @Id
    @GeneratedValue
    @Column(name="code")
    @BeanProperty
    var code:Long = _

    @Column(name="name")
    @BeanProperty
    var name:String = _

    @Column(name="polygon")
    @BeanProperty
    var polygon:String = _

//    @OneToMany(mappedBy = "country",cascade = Array(CascadeType.ALL),fetch = FetchType.LAZY)
//    @Transient
//    var city:List[City] = _

}
