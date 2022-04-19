package com.example.taskshare.viewmodelfactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.taskshare.viewmodel.DashBoardFragmentViewModel

class DashBoardFragmentViewModelFactory(private val application: Application) : ViewModelProvider.NewInstanceFactory() {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DashBoardFragmentViewModel(application) as T

    }


}