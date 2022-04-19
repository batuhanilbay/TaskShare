package com.example.taskshare


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.main_bottom_navigation_view)
        val navController = findNavController(R.id.main_nav_host)


        bottomNavigationView.setupWithNavController(navController)

       // val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment,R.id.employeeDetailFragment,R.id.taskDetailFragment))

     //   setupActionBarWithNavController(navController,appBarConfiguration)





    }

/*
    private fun init() {

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.employee -> {
                    openFragment(EmployeeRegistrationFragment())
                    true
                }
                R.id.task -> {
                    openFragment(TaskRegistrationFragment())
                    true
                }
                R.id.home -> {
                    openFragment(HomeFragment())
                    true
                }
                else -> false
            }
        }

    }

    fun openFragment(fragment: Fragment?) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_nav, fragment!!)
        transaction.addToBackStack(null)
        transaction.commit()
    }

*/



}