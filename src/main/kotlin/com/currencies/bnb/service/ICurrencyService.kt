package com.currencies.bnb.service

import com.currencies.bnb.dto.CurrencyDto

interface ICurrencyService {
    fun getAll(): List<CurrencyDto>
    fun getOneById(id:Int): CurrencyDto
    fun create(dto: CurrencyDto): Int
    fun update(id: Int, dto: CurrencyDto)
    fun updateFromNet()
    fun delete(id: Int)
}