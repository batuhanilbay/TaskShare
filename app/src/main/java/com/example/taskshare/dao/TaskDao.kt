package com.example.taskshare.dao

import androidx.room.*
import com.example.taskshare.entity.Task


@Dao
interface TaskDao {

    @Query("SELECT * FROM tasks")
    suspend fun allTask() : List<Task>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)


}