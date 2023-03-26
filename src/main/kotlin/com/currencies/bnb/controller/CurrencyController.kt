package com.currencies.bnb.controller

import com.currencies.bnb.dto.CurrencyDto
import com.currencies.bnb.service.ICurrencyService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/currencies")
class CurrencyController(private val ICurrencyService: ICurrencyService) {


    @GetMapping
    fun getAll(): List<CurrencyDto>{
        return ICurrencyService.getAll()
    }

    @GetMapping("/{id}")
    fun getOneByID(@PathVariable("id") id: Int): CurrencyDto{
        return ICurrencyService.getOneById(id)
    }

    @PostMapping
    fun create(@RequestBody dto:CurrencyDto): Int{
        return ICurrencyService.create(dto)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Int, @RequestBody dto: CurrencyDto){
        ICurrencyService.update(id, dto)
    }

    @PutMapping("/download")
    fun updateDbFromApiBnbrb(){
        ICurrencyService.updateFromNet()
    }


    @DeleteMapping
    fun delete(@PathVariable("id") id: Int){
        ICurrencyService.delete(id)
    }

}