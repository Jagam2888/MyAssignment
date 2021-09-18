package com.jagad.myassignment.remote

import com.jagad.myassignment.model.request.GetDetailReq
import com.jagad.myassignment.model.response.GetDetailResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by jagad on 9/18/2021
 */
interface APIEndPointInterface {

    @GET("GetDetails")
    suspend fun getDetails(@Query("code") code:String):Response<GetDetailResponse>
}