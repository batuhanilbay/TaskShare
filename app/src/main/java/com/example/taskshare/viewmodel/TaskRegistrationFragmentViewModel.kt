package com.example.taskshare.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.taskshare.entity.Task
import com.example.taskshare.repo.TaskRepository


class TaskRegistrationFragmentViewModel(application: Application) : AndroidViewModel(application) {

    val repository = TaskRepository(application)

    fun  buttonTaskRegister(task:Task){
        repository.recordTask(task)
    }






}