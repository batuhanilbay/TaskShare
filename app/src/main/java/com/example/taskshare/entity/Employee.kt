package com.example.taskshare.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName="employees")
data class Employee(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="employee_id")
    @NotNull
    val employee_id:Int,

    @ColumnInfo(name="employee_name")
    @NotNull
    val employee_name:String,

    @ColumnInfo(name="employee_surname")
    @NotNull
    val employee_surname:String): Serializable {}


