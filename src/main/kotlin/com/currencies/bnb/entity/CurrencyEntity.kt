package com.currencies.bnb.entity

import javax.persistence.*

@Entity
@Table(name = "currency")
class CurrencyEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int = 0,

    @Column(name = "parent_id")
    var parentId: Int = 0,

    @Column(name = "code")
    var code: String = "",

    @Column(name = "abbreviation")
    var abbreviation: String = "",

    @Column(name = "name")
    var name: String = "",

    @Column(name = "name_bel")
    var nameBel: String = "",

    @Column(name = "name_eng")
    var nameEng: String = "",

    @Column(name = "quot_name")
    var quotName: String = "",

    @Column(name = "quot_name_bel")
    var quotNameBel: String = "",

    @Column(name = "quot_name_eng")
    var quotNameEng: String = "",

    @Column(name = "name_multi")
    var nameMulti: String = "",

    @Column(name = "name_bel_multi")
    var nameBelMulti: String = "",

    @Column(name = "name_eng_multi")
    var nameEngMulti: String = "",

    @Column(name = "scale")
    var scale: Int = 0,

    @Column(name = "periodicity")
    var periodicity: Int = 0,

    @Column(name = "date_start")
    var dateStart: String = "",

    @Column(name = "date_end")
    var dateEnd: String = ""

)