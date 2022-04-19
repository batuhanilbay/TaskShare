package com.example.taskshare.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.taskshare.entity.Employee
import com.example.taskshare.entity.MatchEntity
import com.example.taskshare.entity.Task
import com.example.taskshare.repo.EmployeeRepository
import com.example.taskshare.repo.MatchEntityRepository
import com.example.taskshare.repo.TaskRepository

class DashBoardFragmentViewModel(application: Application) : AndroidViewModel(application) {


    var employeeList = MutableLiveData<List<Employee>>()
    var taskList     = MutableLiveData<List<Task>>()
    var matchList = MutableLiveData<List<MatchEntity>>()
    var matchEntity = MutableLiveData<List<MatchEntity>>()
    val matchDao = MatchEntityRepository(application)
    val taskDao = TaskRepository(application)
    val employeeDao = EmployeeRepository(application)

    init {
        uploadNote()
        taskDao.getAllTask()
        taskList = taskDao.shownTask()
        employeeDao.allGetEmployee()
        employeeList=employeeDao.shownEmployee()
    }

    fun uploadNote(){
        matchDao.allGetMatches()
    }

    fun buttonMatchRegister(matchEntity: List<MatchEntity>) {
        matchDao.recordMatch(matchEntity)
        matchDao.allGetMatches()
        matchList.value = matchDao.shownMatch().value
    }
    fun deleteMatchTable(){
        matchDao.deleteMatchTable()
    }

}