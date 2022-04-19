package com.example.taskshare.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName="tasks")
data class Task (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="task_id")
    @NotNull
    val task_id:Int,

    @ColumnInfo(name="task_name")
    @NotNull
    val task_name:String,

    @ColumnInfo(name="task_level")
    @NotNull
    val task_level:Int) : Serializable {}

