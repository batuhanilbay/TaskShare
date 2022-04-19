package com.example.taskshare.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskshare.databinding.CardDesignBinding
import com.example.taskshare.entity.MatchEntity
import com.example.taskshare.viewmodel.DashBoardFragmentViewModel


//Görev paylaşımı için Card Adapteri

class TaskShareAdapter(var mContext: Context, var shareList:List<MatchEntity>, var viewModel:DashBoardFragmentViewModel)
    : RecyclerView.Adapter<TaskShareAdapter.CardDesignShareHolder>(){


    inner class CardDesignShareHolder(cardDesignBinding: CardDesignBinding) : RecyclerView.ViewHolder(cardDesignBinding.root){

     var cardDesignBinding : CardDesignBinding
        init {
        this.cardDesignBinding = cardDesignBinding
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignShareHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding = CardDesignBinding.inflate(layoutInflater,parent,false)
        return CardDesignShareHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignShareHolder, position: Int) {
        val shares = shareList.get(position)
        val t = holder.cardDesignBinding
        t.textViewEmployeeId.text = shares.employee_id.toString()
        t.textViewTaskId.text = shares.task_id.toString()
        t.textDay.text= shares.day.toString()
    }


    override fun getItemCount(): Int {
       return shareList.size
    }


}


