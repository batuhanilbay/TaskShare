package com.example.taskshare.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskshare.databinding.CardEmployeeDesignBinding
import com.example.taskshare.entity.Employee
import com.example.taskshare.viewmodel.EmployeeDetailFragmentViewModel


//Çalışanlar için Card Tasarımı Adapter'ı

class EmployeeAdapter(var mContext: Context, var employeeList:List<Employee>, var viewModel: EmployeeDetailFragmentViewModel)
    : RecyclerView.Adapter<EmployeeAdapter.CardDesignEmployeeHolder>() {


    inner class CardDesignEmployeeHolder(cardDesignBinding: CardEmployeeDesignBinding)
        : RecyclerView.ViewHolder(cardDesignBinding.root){


        var cardEmployeeDesignBinding: CardEmployeeDesignBinding
        init{
            this.cardEmployeeDesignBinding = cardDesignBinding
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignEmployeeHolder {

        val layoutInflater = LayoutInflater.from(mContext)
        val binding = CardEmployeeDesignBinding.inflate(layoutInflater,parent,false)
        return CardDesignEmployeeHolder(binding)

    }

    //Card Üzerinde Silme İşlemi ve Card içerisindeki TextViewleri Gösterme
    override fun onBindViewHolder(holder: CardDesignEmployeeHolder, position: Int) {
        val employees = employeeList.get(position)
        val t = holder.cardEmployeeDesignBinding
        t.employeeCardObject = employees

        t.textViewEmployeeName.text = employees.employee_name
        t.tvEmployeeSurname.text = employees.employee_surname
        t.tVEmployeeID.text=employees.employee_id.toString()

        t.deleteEmployeeImage.setOnClickListener{
            viewModel.employeeDelete(employees)

        }

    }

    override fun getItemCount(): Int {
       return employeeList.size
    }
}