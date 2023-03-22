package com.currencies.bnb.controller

import com.currencies.bnb.model.Currency
import com.currencies.bnb.service.CurrencyService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/currencies")
class CurrencyController(private val service: CurrencyService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String>{
        return ResponseEntity(e.message, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleNotFound(e: IllegalArgumentException): ResponseEntity<String>{
        return ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
    }

    @GetMapping
    fun getCurrencies(): Collection<Currency>{
        return service.getCurrencies()
    }

    @GetMapping("/{currencyId}")
    fun getCurrency(@PathVariable currencyId: Int): Currency{
        return service.getCurrency(currencyId)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addCurrency(@RequestBody currency: Currency): Currency = service.addCurrency(currency)

    @PatchMapping
    fun updateCurrency(@RequestBody currency: Currency): Currency = service.updateCurrency(currency)

    ///////////questions
    @DeleteMapping("/{currencyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCurrency(@PathVariable currencyId: Int): Unit = service.deleteCurrency(currencyId)
}