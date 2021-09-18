package com.jagad.myassignment.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import com.jagad.myassignment.R
import com.jagad.myassignment.databinding.FragmentDetailBinding
import com.jagad.myassignment.network.Resource
import com.jagad.myassignment.utils.toast
import com.jagad.myassignment.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var detailBinding:FragmentDetailBinding
    private val detailViewModel:DetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailBinding = FragmentDetailBinding.bind(view)
        infoPanelObserver()
        responseObserver()

    }

    private fun infoPanelObserver(){
        detailViewModel.candidateInfo.observe(viewLifecycleOwner,{
            detailBinding.response = it
        })
    }

    private fun responseObserver(){
        detailViewModel.postResponse.observe(viewLifecycleOwner,{
            when(it){
                is Resource.Failure -> {
                    context?.toast(it.message!!)
                }
                else -> ""
            }
        })
    }
}