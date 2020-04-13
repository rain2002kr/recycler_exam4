package com.example.recycler_exam4

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_model.view.*


class Adapter(val list: MutableList<Model>,val layout:Int,val context:Context) : RecyclerView.Adapter<ViewHolder>(){
    val selectionList = mutableListOf<Long>()
    val onItemClickListener : ((MutableList<Long>) -> Unit)?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_model,parent,false)
        view.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val id = v?.tag
                if(selectionList.contains(id)) selectionList.remove(id)
                else selectionList.add(id as Long)
                notifyDataSetChanged()
                onItemClickListener?.let{it(selectionList)}
            }
        })
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.containerView.textView.text = list[position].name
        holder.containerView.textView2.text = list[position].number.toString()
        holder.containerView.tag = getItemId(position)
        holder.containerView.isActivated = selectionList.contains(getItemId(position))

        holder.btn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d("sss","Test btn${list[position].number}")
                if(list.isNotEmpty())
                list.remove(list[position])
                notifyDataSetChanged()

            }
        })
        holder.chkBox.setOnCheckedChangeListener(object :CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {

                if(isChecked){
                    Log.d("sss","Check btn ON${list[position].number}")
                    Toast.makeText(context,"Check btn ON${list[position].number}",Toast.LENGTH_LONG).show()

                }else {
                    Log.d("sss","Check btn OFF${list[position].number}")
                    Toast.makeText(context,"Check btn OFF${list[position].number}",Toast.LENGTH_LONG).show()

                }
            }
        })

    }
}
