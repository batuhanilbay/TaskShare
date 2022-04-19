package com.example.taskshare.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.taskshare.R
import com.example.taskshare.adapter.EmployeeAdapter
import com.example.taskshare.databinding.FragmentEmployeeDetailBinding
import com.example.taskshare.viewmodel.EmployeeDetailFragmentViewModel
import com.example.taskshare.viewmodelfactory.EmployeeDetailFragmentViewModelFactory


class EmployeeDetailFragment : Fragment() {

    private lateinit var binding: FragmentEmployeeDetailBinding
    private lateinit var viewModel: EmployeeDetailFragmentViewModel
    private lateinit var adapter: EmployeeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_employee_detail,container,false)
        binding.employeeDetailToolbarTitle = "Employee Detail"
        binding.employeeDetailFragment = this


        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarEmployeeDetail)

        viewModel.employeeList.observe(viewLifecycleOwner) {
            adapter = EmployeeAdapter(requireContext(), it, viewModel)
            binding.employeeAdapter = adapter
        }


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: EmployeeDetailFragmentViewModel by viewModels(){
            EmployeeDetailFragmentViewModelFactory(requireActivity().application)
        }
        viewModel = tempViewModel
    }
    override fun onResume() {
        super.onResume()
        viewModel.downloadEmployee()
    }

}