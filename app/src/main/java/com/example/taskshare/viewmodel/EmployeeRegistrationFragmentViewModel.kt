package com.example.taskshare.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.taskshare.entity.Employee
import com.example.taskshare.repo.EmployeeRepository


class EmployeeRegistrationFragmentViewModel(application: Application) : AndroidViewModel(application){

     val repository = EmployeeRepository(application)

    fun  buttonRegister(employee:Employee){
        repository.recordEmployee(employee)
    }

}