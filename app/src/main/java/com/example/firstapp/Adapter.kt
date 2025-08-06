package com.example.firstapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.databinding.RecyclerViewItemBinding


class Adapter(private val quizmodellist : List<QuizModel> ) : RecyclerView.Adapter<Adapter.viewholder>() {
    class viewholder(private val binding: RecyclerViewItemBinding)  : RecyclerView.ViewHolder(binding.root){
        fun bind(model: QuizModel){
            binding.apply {
           titleText.text=model.title
            subtitleText.text=model.subtitle
            timeText.text=model.time
            root.setOnClickListener{
                val obj=Intent(root.context,MainActivity2::class.java)
                MainActivity2.questionModelList=model.questionlist
                MainActivity2.time=model.time
                root.context.startActivity(obj)


            }
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
      val binding= RecyclerViewItemBinding.inflate(
          LayoutInflater.from(parent.context),
          parent,
          false
      )

        return viewholder(binding)
    }

    override fun getItemCount(): Int {
        return quizmodellist.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.bind(quizmodellist[position])
    }
}