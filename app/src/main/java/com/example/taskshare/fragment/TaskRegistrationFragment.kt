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
import com.example.taskshare.databinding.FragmentTaskRegistrationBinding
import com.example.taskshare.entity.Task
import com.example.taskshare.viewmodel.TaskRegistrationFragmentViewModel
import com.example.taskshare.viewmodelfactory.TaskRegistrationFragmentViewModelFactory


class TaskRegistrationFragment : Fragment() {

    private lateinit var binding: FragmentTaskRegistrationBinding
    private lateinit var viewModel : TaskRegistrationFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_task_registration,container,false)
        binding.taskRegisterFragment = this
        binding.taskRegisterToolbarTitle = "Task Register"

        viewModel = ViewModelProvider(this).get(TaskRegistrationFragmentViewModel::class.java)


        //binding.textViewTaskLevel.text = binding.textViewTaskLevel.toString()

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel: TaskRegistrationFragmentViewModel by viewModels(){
            TaskRegistrationFragmentViewModelFactory(requireActivity().application)
        }
        viewModel = tempViewModel
    }

    fun buttonClickRegisterTask(task_name:String,task_level:String){

        val newTask = Task(0,task_name,task_level.toInt())
        viewModel.buttonTaskRegister(newTask)
        Toast.makeText(this.context,"Task Added", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.taskDetailFragment)
    }


}