package com.example.apicorona

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_item.view.*

class CoronaAdapter(val context: Context,var datalist : ArrayList<CoronaModel>?)
    : RecyclerView.Adapter<CoronaAdapter.MyViewHolder>() {
        class MyViewHolder ( view:View):RecyclerView.ViewHolder(view){
            val llMain = view.llmain
            val tvId = view.tvId
            val tvName = view.tvName
            val tvPositif = view.tvPositif
            val tvSembuh = view.tvSembuh
            val tvMeninggal = view.tvMeninggal
            val tvDirawat = view.tvDirawat
        }

    override fun getItemCount(): Int {
        return datalist!!.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_item,parent,false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = datalist!!.get(position)

        holder.tvId.text = (position + 1).toString()
        holder.tvName.text = item?.name.toString()
        holder.tvPositif.text = item?.positif.toString()
        holder.tvSembuh.text = item?.sembuh.toString()
        holder.tvMeninggal.text = item?.meninggal.toString()
        holder.tvDirawat.text = item?.dirawat.toString()

        if (position % 2 == 0){
            holder.llMain.setBackgroundColor(ContextCompat.getColor(context, R.color.orangemuda))
        } else {
            holder.llMain.setBackgroundColor(ContextCompat.getColor(context, R.color.white))
        }
    }


}