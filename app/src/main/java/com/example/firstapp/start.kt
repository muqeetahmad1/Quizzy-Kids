package com.example.firstapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.firstapp.databinding.ActivityStartBinding
import com.google.firebase.database.FirebaseDatabase

class start : AppCompatActivity() {
    lateinit var binding: ActivityStartBinding
    lateinit var quizmodellist: MutableList<QuizModel>
    lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        quizmodellist= mutableListOf()

        getdatafromfirebase()

    }

    private fun setupRecyclerview(){
        binding.progressBar.visibility=View.GONE
    adapter= Adapter(quizmodellist)
        binding.recyclerview.layoutManager=LinearLayoutManager(this)
       binding.recyclerview.adapter=adapter


    }

    private fun getdatafromfirebase(){
        binding.progressBar.visibility=View.VISIBLE
            FirebaseDatabase.getInstance().reference
                .get()
                .addOnSuccessListener { dataSnapshot ->
                    if (dataSnapshot.exists()){
                        for (snapshot in dataSnapshot.children){
                            val quizModel = snapshot.getValue(QuizModel::class.java)
                            if (quizModel != null) {
                                // Validate time
                                if (quizModel.time.isEmpty() || quizModel.time.toIntOrNull() == null) {
                                    Toast.makeText(this, "Invalid timer value in data", Toast.LENGTH_SHORT).show()
                                    continue}
                                quizmodellist.add(quizModel)
                            }
                        }
                    }
                    setupRecyclerview()
                }
        }}


