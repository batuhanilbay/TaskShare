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
import com.example.taskshare.adapter.TaskAdapter
import com.example.taskshare.databinding.FragmentTaskDetailBinding
import com.example.taskshare.viewmodel.TaskDetailFragmentViewModel
import com.example.taskshare.viewmodelfactory.TaskDetailFragmentViewModelFactory


class TaskDetailFragment : Fragment() {

    private lateinit var binding:FragmentTaskDetailBinding
    private lateinit var viewModel: TaskDetailFragmentViewModel
    private lateinit var adapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_task_detail,container,false)
        binding.taskDetailToolbarTitle = "Task Detail"
        binding.taskDetailFragment = this


        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarTaskDetail)

        viewModel.taskList.observe(viewLifecycleOwner) {
            adapter = TaskAdapter(requireContext(), it, viewModel)
            binding.taskAdapter = adapter
        }


        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: TaskDetailFragmentViewModel by viewModels(){
            TaskDetailFragmentViewModelFactory(requireActivity().application)
        }

        viewModel = tempViewModel
    }
    override fun onResume() {
        super.onResume()
        viewModel.downloadTask()
    }


}