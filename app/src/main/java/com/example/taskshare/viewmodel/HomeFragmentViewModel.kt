package com.example.taskshare.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.taskshare.entity.Employee
import com.example.taskshare.entity.Task
import com.example.taskshare.repo.EmployeeRepository
import com.example.taskshare.repo.TaskRepository

class HomeFragmentViewModel(application: Application) : AndroidViewModel(application){

    var employeeList = MutableLiveData<List<Employee>>()
    var taskList     = MutableLiveData<List<Task>>()

    val employeDao = EmployeeRepository(application)
    val taskDao   = TaskRepository(application)


    init {
        uploadNote()
        employeeList = employeDao.shownEmployee()
        taskList = taskDao.shownTask()
    }


    fun uploadNote(){
        employeDao.allGetEmployee()
        taskDao.getAllTask()

    }

    fun deleteNote(employe:Employee,task:Task){
        employeDao.deleteEmployee(employe)
        taskDao.deleteTask(task)
    }

}