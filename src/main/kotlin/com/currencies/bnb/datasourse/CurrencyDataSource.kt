package com.currencies.bnb.datasourse

import com.currencies.bnb.model.Currency

interface CurrencyDataSource {
    fun retrieveCurrencies(): Collection<Currency>
    fun retrieveCurrency(curId: Int): Currency
    fun createCurrency(currency: Currency): Currency
    fun updateCurrency(currency: Currency): Currency
    fun deleteCurrency(currencyId: Int)
}