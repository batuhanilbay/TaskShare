package com.example.taskshare.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskshare.databinding.CardTaskDesignBinding
import com.example.taskshare.entity.Task
import com.example.taskshare.viewmodel.TaskDetailFragmentViewModel


//Görevler için Card Tasarımı Adapter'ı


class TaskAdapter(var mContext: Context, var taskList:List<Task>, var viewModel: TaskDetailFragmentViewModel)
    : RecyclerView.Adapter<TaskAdapter.CardDesignTaskHolder>() {



    inner class CardDesignTaskHolder(cardDesignBinding: CardTaskDesignBinding)
        : RecyclerView.ViewHolder(cardDesignBinding.root){


        var cardTaskDesignBinding: CardTaskDesignBinding
        init{
            this.cardTaskDesignBinding = cardDesignBinding
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignTaskHolder {

        val layoutInflater = LayoutInflater.from(mContext)
        val binding = CardTaskDesignBinding.inflate(layoutInflater,parent,false)
        return CardDesignTaskHolder(binding)

    }

    //Card Üzerinde Silme İşlemi ve Card içerisindeki TextViewleri Gösterme

    override fun onBindViewHolder(holder: CardDesignTaskHolder, position: Int) {
        val tasks = taskList.get(position)
        val t = holder.cardTaskDesignBinding
        t.taskCardObject = tasks

        t.tVTaskName.text = tasks.task_name
        t.tVTaskLevel.text = tasks.task_level.toString()
        t.tVTaskID.text = tasks.task_id.toString()

        t.imageViewTaskDelete.setOnClickListener{
            viewModel.taskDelete(tasks)

        }

    }

    override fun getItemCount(): Int {
        return taskList.size
    }


}