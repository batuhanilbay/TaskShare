package com.example.taskshare.room

import android.content.Context
import androidx.room.*
import com.example.taskshare.dao.EmployeeDao
import com.example.taskshare.dao.MatchDao
import com.example.taskshare.dao.TaskDao
import com.example.taskshare.entity.*

@Database(entities = [Employee::class, Task::class,MatchEntity::class], version = 3, exportSchema = false)
@TypeConverters(MatchListConverter::class)
abstract class AppDatabase() : RoomDatabase() {

    abstract fun employeeDao() : EmployeeDao
    abstract fun taskDao() : TaskDao
    abstract fun matchDao() : MatchDao

    //Static olarak başka yerlerden ulaşmak için
    companion object{

        //Volatile -> farklı threadlerde görünür hale getiriyoruz.
        @Volatile private var instance : AppDatabase? = null

        private val lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock){
            instance ?: makeDatabase(context).also{
                instance = it
            }
        }



        private fun makeDatabase(context: Context) = Room.databaseBuilder(context.applicationContext,
            AppDatabase::class.java,
            "task_share.sqlite").fallbackToDestructiveMigration().build()
     }





}


