package com.currencies.bnb.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Currency (

    @JsonProperty("Cur_ID")
    val id: Int,

    @JsonProperty("Cur_ParentID")
    val parentId: Int,

    @JsonProperty("Cur_Code: String")
    val code: String,

    @JsonProperty("Cur_Abbreviation")
    val abbreviation: String,

    @JsonProperty("Cur_Name")
    val name: String,

    @JsonProperty("Cur_Name_Bel")
    val nameBel: String,

    @JsonProperty("Cur_Name_Eng")
    val nameEng: String,

    @JsonProperty("Cur_QuotName")
    val quotName: String,

    @JsonProperty("Cur_QuotName_Bel")
    val quotNameBel: String,

    @JsonProperty("Cur_QuotName_Eng")
    val quotNameEng: String,

    @JsonProperty("Cur_NameMulti")
    val nameMulti: String,

    @JsonProperty("Cur_Name_BelMulti")
    val nameBelMulti: String,

    @JsonProperty("Cur_Name_EngMulti")
    val nameEngMulti: String,

    @JsonProperty("Cur_Scale")
    val scale: Int,

    @JsonProperty("Cur_Periodicity")
    val periodicity: Int,

    @JsonProperty("Cur_DateStart")
    val dateStart: String,

    @JsonProperty("Cur_DateEnd")
    val dateEnd: String
    )