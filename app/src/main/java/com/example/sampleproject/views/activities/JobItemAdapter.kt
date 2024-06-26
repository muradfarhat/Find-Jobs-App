package com.example.sampleproject.views.activities

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleproject.R
import com.example.sampleproject.interfaces.OnItemClickListener

class JobItemAdapter(private val data: List<Item>, private val listener: OnItemClickListener) : RecyclerView.Adapter<JobItemAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTittle)
        val tvCompany: TextView = itemView.findViewById(R.id.tvCompany)
        val partTimeId: TextView = itemView.findViewById(R.id.partTimeId)
        val remoteId: TextView = itemView.findViewById(R.id.remoteId)
        val juniorId: TextView = itemView.findViewById(R.id.juniorId)
        val matchText: TextView = itemView.findViewById(R.id.matchText)
        val postDayId: TextView = itemView.findViewById(R.id.postDayId)
        val salaryId: TextView = itemView.findViewById(R.id.salaryId)
        val jobCard: LinearLayout = itemView.findViewById(R.id.jobCard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycleview_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]

        // Set the data for each view
        holder.tvTitle.text = item.tvTitle
        holder.tvCompany.text = item.tvCompany
        holder.partTimeId.text = item.partTime
        holder.remoteId.text = item.remote
        holder.juniorId.text = item.junior
        holder.matchText.text = item.matchText
        holder.postDayId.text = item.postDay
        holder.salaryId.text = item.salary
        holder.jobCard.setOnClickListener {
            listener.onItemClick(position)
        }
    }

    override fun getItemCount() = data.size
    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }
}
