package com.currencies.bnb.repository

import com.currencies.bnb.entity.CurrencyEntity
import org.springframework.data.repository.CrudRepository

interface ICurrencyRepository: CrudRepository<CurrencyEntity, Int>