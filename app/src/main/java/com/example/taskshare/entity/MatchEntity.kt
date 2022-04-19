package com.example.taskshare.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "matchs")
data class MatchEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="match_id")
    @NotNull
    val matchId:Int,
    @NotNull
    @ColumnInfo(name = "match_employee_id")
    val employee_id:Int,
    @NotNull
    @ColumnInfo(name = "match_task_id")
    val task_id:Int,
    @NotNull
    @ColumnInfo(name = "day")
    val day:Int)