package br.edu.ifsp.scl.sdm.currencyconverter.model.api

import br.edu.ifsp.scl.sdm.currencyconverter.model.domain.ConversionResult
import br.edu.ifsp.scl.sdm.currencyconverter.model.domain.CurrencyList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

private const val CURRENCY_CONVERTER_URL = "currency-converter5.p.rapidapi.com"
private const val RAPID_API_KEY = "770bcc6964msh075d1dfb1da1019p1006fcjsn76e959c43f90"

interface CurrencyConverterApiService {
    @Headers(
        "x-rapidapi-host: $CURRENCY_CONVERTER_URL",
        "x-rapidapi-key: $RAPID_API_KEY",
    )
    @GET("list")
    fun getCurrencies(): Call<CurrencyList>

    @Headers(
        "x-rapidapi-host: $CURRENCY_CONVERTER_URL",
        "x-rapidapi-key: $RAPID_API_KEY",
    )
    @GET("convert")
    fun convert(
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("amount") amount: String,
    ): Call<ConversionResult>
}
