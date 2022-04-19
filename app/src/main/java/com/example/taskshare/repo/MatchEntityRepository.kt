package com.example.taskshare.repo

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.taskshare.entity.MatchEntity
import com.example.taskshare.room.AppDatabase
import kotlinx.coroutines.*

class MatchEntityRepository (var application: Application){

    private val vt : AppDatabase
    private val matchEntityList : MutableLiveData<List<MatchEntity>>

    init {
        vt = AppDatabase.invoke(application)!!
        matchEntityList = MutableLiveData()

    }

    fun shownMatch():MutableLiveData<List<MatchEntity>>{
        return matchEntityList
    }


    fun allGetMatches(){
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            matchEntityList.value = vt.matchDao().getMatchButton()
        }
    }


    fun recordMatch(matchEntity:List<MatchEntity>) {
           CoroutineScope(Dispatchers.Main).launch {
                vt.matchDao().addMatch(matchEntity)
           }
    }

    fun deleteMatchTable(){
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            vt.matchDao().deleteTable()
        }
    }
}
