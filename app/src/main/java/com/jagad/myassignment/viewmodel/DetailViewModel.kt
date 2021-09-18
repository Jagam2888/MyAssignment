package com.jagad.myassignment.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jagad.myassignment.model.request.GetDetailReq
import com.jagad.myassignment.model.response.GetDetailResponse
import com.jagad.myassignment.network.Resource
import com.jagad.myassignment.repositary.DetailRepositary
import com.jagad.myassignment.utils.APIException
import com.jagad.myassignment.utils.NoInternetException
import com.jagad.myassignment.utils.PassParams
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by jagad on 9/18/2021
 */
@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repositary: DetailRepositary
):ViewModel() {

    var _candidateInfo:MutableLiveData<GetDetailResponse> = MutableLiveData()
    val candidateInfo:LiveData<GetDetailResponse>
    get() = _candidateInfo

    private val _postResponse:MutableLiveData<Resource> = MutableLiveData()
    val postResponse:LiveData<Resource>
        get() = _postResponse

    init {
       getDetail()
    }

    private fun getDetail() = viewModelScope.launch {
        try {
            val response = repositary.getDetail(PassParams.CODE)
            _candidateInfo.value = response
            _postResponse.value = Resource.Success("Success")
        }catch (e:NoInternetException){
            _postResponse.value = Resource.Failure(e.message!!)
        }catch (e:APIException){
            _postResponse.value = Resource.Failure(e.message!!)
        }
    }
}