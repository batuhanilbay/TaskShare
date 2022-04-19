package com.example.taskshare.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.taskshare.entity.Employee
import com.example.taskshare.repo.EmployeeRepository

class EmployeeDetailFragmentViewModel(application: Application) : AndroidViewModel(application) {

    var employeeList = MutableLiveData<List<Employee>>()
    val employeeDao = EmployeeRepository(application)

    init {
        downloadEmployee()
        employeeList = employeeDao.shownEmployee()

    }
    fun downloadEmployee(){
        employeeDao.allGetEmployee()
    }


    fun employeeDelete(employee:Employee){
        employeeDao.deleteEmployee(employee)
    }

}