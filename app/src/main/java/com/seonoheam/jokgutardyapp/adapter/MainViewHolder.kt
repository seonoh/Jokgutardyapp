package com.seonoheam.jokgutardyapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.seonoheam.jokgutardyapp.MainActivity
import com.seonoheam.jokgutardyapp.model.User
import kotlinx.android.synthetic.main.item_list.view.*

/**
 * Created by seonoheam on 2017. 12. 4..
 */
class MainViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    var dataList = MainActivity.dataList

    fun toBind(holder: MainViewHolder, position:Int,dataList : ArrayList<User>?){
        holder?.itemView?.name_tv?.text = dataList!![position].name
        holder?.itemView?.date_tv?.text = dataList!![position].date
        holder?.itemView?.tardyCharge_tv?.text = dataList!![position].charge.toString()
        holder?.itemView?.reason_tv?.text = dataList!![position].reason



    }


}