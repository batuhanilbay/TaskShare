package com.example.taskshare.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskshare.R
import com.example.taskshare.adapter.TaskShareAdapter
import com.example.taskshare.databinding.FragmentDashBoardBinding
import com.example.taskshare.entity.MatchEntity
import com.example.taskshare.viewmodel.DashBoardFragmentViewModel
import com.example.taskshare.viewmodelfactory.DashBoardFragmentViewModelFactory
import kotlin.collections.ArrayList
import kotlin.random.Random


class DashBoardFragment : Fragment() {

    private lateinit var binding: FragmentDashBoardBinding
    private lateinit var viewModel: DashBoardFragmentViewModel
    private lateinit var taskShareAdapter: TaskShareAdapter

    private var randomSelector = ArrayList<Int>()
    private var matchesList = ArrayList<MatchEntity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_dash_board,container,false)

        binding.dashBoardToolbarTitle = "DASHBOARD"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarDashboard)

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel : DashBoardFragmentViewModel by viewModels(){
            DashBoardFragmentViewModelFactory(requireActivity().application)

        }

        viewModel = tempViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonGenerate.setOnClickListener{
            buttonClickMatch()
            Log.e("Kayit","Butona basildi...")
        }
        viewModel.matchList.observe(viewLifecycleOwner) {
            taskShareAdapter = TaskShareAdapter(requireContext(), it, viewModel)
            binding.rvDashboard.apply {
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                adapter = taskShareAdapter
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.uploadNote()
    }

    fun buttonClickMatch(){

        viewModel.deleteMatchTable()
        matchesList.clear()
        viewModel.taskList.value!!.sortedBy {
                it.task_level

        }
        for(i in 0 until viewModel.employeeList.value!!.size){
           randomSelector.add(i)
        }

        for(i in 0 until viewModel.taskList.value!!.size){
            var number = Random.nextInt(0,randomSelector.size)
            var randomSelectorNumber= randomSelector[number]
            randomSelector.removeAt(number)

            for (j in 0 until  viewModel.taskList.value!!.size){
                    var day = i+1
                    var second = (j+randomSelectorNumber) % 6
                    var data = MatchEntity(0,task_id = viewModel.taskList.value!!.get(j).task_id, employee_id = viewModel.employeeList.value!![second].employee_id, day = day)

                    matchesList.add(data)
                }




        }
        viewModel.buttonMatchRegister(matchesList)


    }




}