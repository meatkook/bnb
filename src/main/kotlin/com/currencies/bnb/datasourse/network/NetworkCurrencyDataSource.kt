package com.currencies.bnb.datasourse.network

import com.currencies.bnb.datasourse.CurrencyDataSource
import com.currencies.bnb.datasourse.network.dto.CurrencyList
import com.currencies.bnb.model.Currency
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import java.io.IOException

@Repository("network")
class NetworkCurrencyDataSource(
    @Autowired val restTemplate: RestTemplate
): CurrencyDataSource {
    override fun retrieveCurrencies(): Collection<Currency> {
        val response: ResponseEntity<CurrencyList> =
        restTemplate.getForEntity<CurrencyList>("https://www.nbrb.by/api/exrates/currencies")

        return response.body?.result
            ?: throw IOException("Couldn't fetch currencies from the network")
    }

    override fun retrieveCurrency(curId: Int): Currency {
        val response: ResponseEntity<Currency> =
            restTemplate.getForEntity<Currency>("https://www.nbrb.by/api/exrates/currencies/${curId}")
        return response.body
            ?: throw IOException("Couldn't fetch currencies from the network")
    }

    override fun createCurrency(currency: Currency): Currency {
        TODO("Not yet implemented")
    }

    override fun updateCurrency(currency: Currency): Currency {
        TODO("Not yet implemented")
    }

    override fun deleteCurrency(currencyId: Int) {
        TODO("Not yet implemented")
    }
}