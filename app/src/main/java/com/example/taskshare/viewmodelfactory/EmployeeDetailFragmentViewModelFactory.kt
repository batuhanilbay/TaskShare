package com.example.taskshare.viewmodelfactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.taskshare.viewmodel.EmployeeDetailFragmentViewModel

class EmployeeDetailFragmentViewModelFactory(private val application: Application) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EmployeeDetailFragmentViewModel(application) as T

    }

}