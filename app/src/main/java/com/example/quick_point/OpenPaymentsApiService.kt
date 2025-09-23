package com.example.quick_point

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface OpenPaymentsApiService {
    @GET
    suspend fun getWalletAddressInfo(@Url walletAddressUrl: String): Response<WalletAddressInfo>
}

data class WalletAddressInfo(
    val id: String,
    val publicName: String,
    val assetCode: String,
    val assetScale: Int,
    val authServer: String
)