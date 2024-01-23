package com.example.crudassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecordsAdapter(
    private var recordsList: List<RecordItem>, private var listener: (position: Int) -> Unit
) : RecyclerView.Adapter<RecordsAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        var item: TextView = view.findViewById(R.id.edtName)
        var description: TextView = view.findViewById(R.id.edtDescription)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener(adapterPosition)
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.record_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val recordItem = recordsList[position]
        holder.item.text = recordItem.name
        holder.description.text = recordItem.description
    }

    override fun getItemCount(): Int {
        return recordsList.size
    }
}
