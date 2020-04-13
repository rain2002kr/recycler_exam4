package com.example.recycler_exam4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    val list :MutableList<Model> by lazy {
        mutableListOf<Model>()
    }
    var number = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = Adapter(list,R.layout.item_model,this)
        recyclerView.adapter = adapter
        recyclerView.hasFixedSize()
        recyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false   )

        bt_insert.setOnClickListener{
            val name = editText.text.toString()
            number = adapter.itemCount
            list.add(Model(name, number++))
            adapter.notifyDataSetChanged()
        }

        bt_delete.setOnClickListener{
            number = adapter.itemCount
            if(number==0){
                number = 0
            }else {
                number--
            }
            if(list.isNotEmpty())
            list.remove(list.last())
            adapter.notifyDataSetChanged()
        }




    }
}
