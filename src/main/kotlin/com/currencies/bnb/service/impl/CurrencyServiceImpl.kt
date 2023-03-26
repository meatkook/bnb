package com.currencies.bnb.service.impl

import com.currencies.bnb.dto.CurrencyDto
import com.currencies.bnb.entity.CurrencyEntity
import com.currencies.bnb.repository.ICurrencyRepository
import com.currencies.bnb.service.ICurrencyService
import org.springframework.core.ParameterizedTypeReference
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class CurrencyServiceImpl(private val ICurrencyRepository: ICurrencyRepository) : ICurrencyService {



    override fun getAll(): List<CurrencyDto> {
        return ICurrencyRepository.findAll().map{it.toDto()}
    }


    override fun getOneById(id: Int): CurrencyDto {
        return ICurrencyRepository.findByIdOrNull(id)?.toDto()
            ?: throw RuntimeException("Currency with id $id not found")
    }

    override fun create(dto: CurrencyDto): Int {
        return ICurrencyRepository.save(dto.toEntity()).id
    }

    override fun update(id: Int, dto: CurrencyDto) {
        val existingCurrency = ICurrencyRepository.findByIdOrNull(id)
            ?: throw RuntimeException("Currency with id $id not found")

        existingCurrency.updateDataFrom(dto)
        ICurrencyRepository.save(existingCurrency)
    }

    override fun updateFromNet() {
        val currenciesFromApi: List<CurrencyDto> = RestTemplate().exchange(
            "https://www.nbrb.by/api/exrates/currencies",
            HttpMethod.GET,
            null,
            object : ParameterizedTypeReference<List<CurrencyDto>>() {}).body as List<CurrencyDto>
        var currencyEntity:CurrencyEntity
        for(currencyApi in currenciesFromApi){
            if(ICurrencyRepository.existsById(currencyApi.id)){
                currencyEntity = ICurrencyRepository.findByIdOrNull(currencyApi.id)!!
                currencyEntity.updateDataFrom(currencyApi)
                ICurrencyRepository.save(currencyEntity)
            }
            else{
                ICurrencyRepository.save(currencyApi.toEntity())
            }
        }
    }

    override fun delete(id: Int) {
        val existingCurrency = ICurrencyRepository.findByIdOrNull(id)
            ?: throw throw RuntimeException("Currency with id $id not found")
        ICurrencyRepository.delete(existingCurrency)
    }

    private fun CurrencyEntity.toDto():CurrencyDto = CurrencyDto(
        id = this.id,
        parentId = this.parentId,
        code = this.code,
        abbreviation = this.abbreviation,
        name = this.name,
        nameBel = this.nameBel,
        nameEng = this.nameEng,
        quotName = this.quotName,
        quotNameBel = this.quotNameBel,
        quotNameEng = this.quotNameEng,
        nameMulti = this.nameMulti,
        nameBelMulti = this.nameBelMulti,
        nameEngMulti = this.nameEngMulti,
        scale = this.scale,
        periodicity = this.periodicity,
        dateStart = this.dateStart,
        dateEnd = this.dateEnd
    )

    private fun CurrencyEntity.updateDataFrom(dto: CurrencyDto){
        this.parentId = dto.parentId
        this.code = dto.code
        this.abbreviation = dto.abbreviation
        this.name = dto.name
        this.nameBel = dto.nameBel
        this.nameEng = dto.nameEng
        this.quotName = dto.quotName
        this.quotNameBel = dto.quotNameBel
        this.quotNameEng = dto.quotNameEng
        this.nameMulti = dto.nameMulti
        this.nameBelMulti = dto.nameBelMulti
        this.nameEngMulti = dto.nameEngMulti
        this.scale = dto.scale
        this.periodicity = dto.periodicity
        this.dateStart = dto.dateStart
        this.dateEnd = dto.dateEnd
    }

    private fun CurrencyDto.toEntity(): CurrencyEntity{
        return CurrencyEntity(
            id = this.id,
            parentId = this.parentId,
            code = this.code,
            abbreviation = this.abbreviation,
            name = this.name,
            nameBel = this.nameBel,
            nameEng = this.nameEng,
            quotName = this.quotName,
            quotNameBel = this.quotNameBel,
            quotNameEng = this.quotNameEng,
            nameMulti = this.nameMulti,
            nameBelMulti = this.nameBelMulti,
            nameEngMulti = this.nameEngMulti,
            scale = this.scale,
            periodicity = this.periodicity,
            dateStart = this.dateStart,
            dateEnd = this.dateEnd
        )
    }

}