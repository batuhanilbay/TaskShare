package com.example.taskshare.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.taskshare.entity.Task
import com.example.taskshare.repo.TaskRepository

class TaskDetailFragmentViewModel(application: Application) : AndroidViewModel(application) {

    var taskList = MutableLiveData<List<Task>>()
    val taskDao = TaskRepository(application)

    init {
        downloadTask()
        taskList = taskDao.shownTask()

    }
    fun downloadTask(){
        taskDao.getAllTask()
    }


    fun taskDelete(task: Task){
        taskDao.deleteTask(task)
    }


}