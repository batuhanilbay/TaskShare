package com.example.taskshare.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taskshare.entity.MatchEntity

@Dao
interface MatchDao {

    @Query("SELECT * FROM matchs")
    suspend fun getMatchButton() : List<MatchEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMatch(matchEntity:List<MatchEntity>)

    @Query("DELETE FROM matchs")
    suspend fun deleteTable()
}