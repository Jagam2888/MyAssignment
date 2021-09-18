package com.jagad.myassignment.repositary

import com.jagad.myassignment.model.response.GetDetailResponse
import com.jagad.myassignment.network.SafeApiRequest
import com.jagad.myassignment.remote.APIEndPointInterface
import javax.inject.Inject

/**
 * Created by jagad on 9/18/2021
 */
class DetailRepositary @Inject constructor(
    private val apiEndPointInterface: APIEndPointInterface
):SafeApiRequest() {

    suspend fun getDetail(code:String):GetDetailResponse{
        return apiRequest {
            apiEndPointInterface.getDetails(code)
        }
    }
}