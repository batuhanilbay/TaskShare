package com.example.taskshare.dao

import androidx.room.*
import com.example.taskshare.entity.Employee


@Dao
interface EmployeeDao {

   @Query("SELECT * FROM employees")
   suspend fun allEmployee() : List<Employee>

   @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun addEmployee(employee: Employee)

   @Update
   suspend fun updateEmployee(employee: Employee)

   @Delete
   suspend fun deleteEmployee(employee: Employee)

}