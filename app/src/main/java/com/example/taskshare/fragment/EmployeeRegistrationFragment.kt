package com.example.taskshare.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.taskshare.R
import com.example.taskshare.databinding.FragmentEmployeeRegistrationBinding
import com.example.taskshare.entity.Employee
import com.example.taskshare.viewmodel.EmployeeRegistrationFragmentViewModel
import com.example.taskshare.viewmodelfactory.EmployeeRegistrationFragmentViewModelFactory


class EmployeeRegistrationFragment : Fragment() {

    private lateinit var binding: FragmentEmployeeRegistrationBinding
    private lateinit var viewModel:EmployeeRegistrationFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_employee_registration,container,false)
        binding.employeeRegisterFragment = this
        binding.employeeRegisterToolbarTitle = "Employee Register"

        viewModel = ViewModelProvider(this).get(EmployeeRegistrationFragmentViewModel::class.java)




        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel:EmployeeRegistrationFragmentViewModel by viewModels(){
            EmployeeRegistrationFragmentViewModelFactory(requireActivity().application)
        }
        viewModel = tempViewModel
    }

    fun buttonClickRegisterEmployee(employee_name:String, employee_surname:String){
        val newEmployee = Employee(0,employee_name,employee_surname)
        viewModel.buttonRegister(newEmployee)
        Toast.makeText(this.context,"Employee Added",Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.employeeDetailFragment)
    }






}