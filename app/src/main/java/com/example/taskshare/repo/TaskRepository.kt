package com.example.taskshare.repo

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.taskshare.entity.Task
import com.example.taskshare.room.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TaskRepository (var application: Application){

    private val taskDb: AppDatabase
    private val taskList : MutableLiveData<List<Task>>

    init{
        taskDb = AppDatabase.invoke(application)!!
        taskList = MutableLiveData()
    }

    fun getAllTask(){
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            taskList.value = taskDb.taskDao().allTask()
        }
    }

    fun shownTask():MutableLiveData<List<Task>>{
        return taskList
    }

    fun deleteTask(task:Task){
        val job:Job = CoroutineScope(Dispatchers.Main).launch {
            taskDb.taskDao().deleteTask(task)
            getAllTask()
        }
    }

    fun recordTask(task: Task){
        val job:Job = CoroutineScope(Dispatchers.Main).launch {
            taskDb.taskDao().addTask(task)
        }
    }

    fun updateTask(task: Task){
        val job:Job = CoroutineScope(Dispatchers.Main).launch {
            taskDb.taskDao().updateTask(task)
        }
    }

}