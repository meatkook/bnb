package com.currencies.bnb.datasourse.mock

import com.currencies.bnb.datasourse.CurrencyDataSource
import com.currencies.bnb.model.Currency
import org.springframework.stereotype.Repository

@Repository("Mock")
class MockCurrencyDataSource: CurrencyDataSource {

    val currencies = mutableListOf(
        Currency(id = 1,
            parentId = 1,
            code = "008",
            abbreviation = "ALL",
            name = "Албанский лек",
            nameBel = "Албанскі лек",
            nameEng = "Albanian Lek",
            quotName = "1 Албанский лек",
            quotNameBel = "1 Албанскі лек",
            quotNameEng = "1 Albanian Lek",
            nameMulti = "",
            nameBelMulti = "",
            nameEngMulti = "",
            scale = 1,
            periodicity = 1,
            dateStart = "1991-01-01T00:00:00",
            dateEnd = "2007-11-30T00:00:00"),
        Currency(id = 2,
            parentId = 2,
            code = "012",
            abbreviation = "DZD",
            name = "Алжирский динар",
            nameBel = "Алжырскі дынар",
            nameEng = "Algerian Dinar",
            quotName = "1 Алжирский динар",
            quotNameBel = "1 Алжырскі дынар",
            quotNameEng = "1 Algerian Dinar",
            nameMulti = "",
            nameBelMulti = "",
            nameEngMulti = "",
            scale = 1,
            periodicity = 1,
            dateStart = "1991-01-01T00:00:00",
            dateEnd = "2016-06-30T00:00:00")
    )

    override fun retrieveCurrencies(): Collection<Currency> = currencies
    override fun retrieveCurrency(curId: Int): Currency {
        return currencies.firstOrNull{it.id == curId}
            ?: throw NoSuchElementException("Could not find a currency with id $curId")
    }

    override fun createCurrency(currency: Currency): Currency {

        if (currencies.any{it.id == currency.id}){
            throw IllegalArgumentException("Currency with ID ${currency.id} already exist")
        }
        currencies.add(currency)
        return currency
    }

    override fun updateCurrency(currency: Currency): Currency {
        val currentCurrency = currencies.firstOrNull{it.id == currency.id}
            ?: throw NoSuchElementException("Could not find a currency with id ${currency.id}")
        currencies.remove(currentCurrency)
        currencies.add(currency)

        return currency
    }

    override fun deleteCurrency(currencyId: Int) {
        val currentCurrency = currencies.firstOrNull{it.id == currencyId}
            ?: throw NoSuchElementException("Could not find a currency with id $currencyId")
        currencies.remove(currentCurrency)
    }
}