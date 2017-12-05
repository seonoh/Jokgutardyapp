package com.seonoheam.jokgutardyapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.seonoheam.jokgutardyapp.R
import com.seonoheam.jokgutardyapp.model.User
import kotlinx.android.synthetic.main.input_fragment.view.*
import kotlinx.android.synthetic.main.item_list.view.*

/**
 * Created by seonoheam on 2017. 12. 4..
 */
class MainAdapter(var user : ArrayList<User>? ): RecyclerView.Adapter<MainViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainViewHolder = MainViewHolder(LayoutInflater
            .from(parent!!.context)!!
            .inflate(R.layout.item_list,parent,false))

    override fun getItemCount(): Int =user?.size ?: 0

    override fun onBindViewHolder(holder: MainViewHolder?, position: Int) {
        holder?.itemView?.name_tv?.text = user!![position].name
        holder?.itemView?.date_tv?.text = user!![position].date
        holder?.itemView?.reason_tv?.text = user!![position].reason

    }
}