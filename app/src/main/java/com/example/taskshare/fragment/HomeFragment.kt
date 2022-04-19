package com.example.taskshare.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.taskshare.R
import com.example.taskshare.databinding.FragmentHomeBinding
import com.example.taskshare.viewmodel.HomeFragmentViewModel
import com.example.taskshare.viewmodelfactory.HomeFragmentViewModelFactory


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel:HomeFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)

        binding.homeFragment = this
        binding.homeToolbarTitle = "HOME"

        binding.buttonGoEmployeeRegister.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.goEmployeeRegister)
        }
        binding.buttonGoTaskRegister.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.goTaskRegister)

        }
        binding.buttonDashboard.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.goDashBoard)
        }



        return binding.root
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomeFragmentViewModel by viewModels(){
            HomeFragmentViewModelFactory(requireActivity().application)
        }

        viewModel = tempViewModel
    }



}