package com.example.taskshare.repo

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.taskshare.entity.Employee
import com.example.taskshare.room.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class EmployeeRepository (var application: Application){

    private val vt : AppDatabase
    private val employeeList : MutableLiveData<List<Employee>>

    init {
        vt = AppDatabase.invoke(application)!!
        employeeList = MutableLiveData()
    }

    fun shownEmployee():MutableLiveData<List<Employee>>{
        return employeeList
    }

    fun allGetEmployee(){
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            employeeList.value = vt.employeeDao().allEmployee()
        }
    }


    fun deleteEmployee(employee: Employee){
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            vt.employeeDao().deleteEmployee(employee)
            allGetEmployee()
        }
    }

    fun recordEmployee(employee: Employee){
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            vt.employeeDao().addEmployee(employee)



        }
    }

    fun updateEmployee(employee: Employee){
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            vt.employeeDao().updateEmployee(employee)


        }
    }




}