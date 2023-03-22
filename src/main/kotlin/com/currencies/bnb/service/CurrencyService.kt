package com.currencies.bnb.service

import com.currencies.bnb.datasourse.CurrencyDataSource
import com.currencies.bnb.model.Currency
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class CurrencyService (@Qualifier("network") private val dataSource: CurrencyDataSource){

    fun getCurrencies(): Collection<Currency> = dataSource.retrieveCurrencies()

    fun getCurrency(currencyId: Int): Currency {
        return  dataSource.retrieveCurrency(currencyId)
    }

    fun addCurrency(currency: Currency): Currency{
        return dataSource.createCurrency(currency)
    }

    fun updateCurrency(currency: Currency): Currency {
        return dataSource.updateCurrency(currency)
    }

    fun deleteCurrency(currencyId: Int) {
        return dataSource.deleteCurrency(currencyId)
    }
}