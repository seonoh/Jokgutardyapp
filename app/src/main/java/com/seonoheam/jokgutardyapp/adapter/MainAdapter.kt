package com.seonoheam.jokgutardyapp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.seonoheam.jokgutardyapp.R
import com.seonoheam.jokgutardyapp.db.DBHelper
import com.seonoheam.jokgutardyapp.model.User
import kotlinx.android.synthetic.main.item_list.view.*

/**
 * Created by seonoheam on 2017. 12. 4..
 */
class MainAdapter(var dataList : ArrayList<User>?,var context:Context ): RecyclerView.Adapter<MainViewHolder>(){

    var mDBHelper: DBHelper = DBHelper(context,"seonoh.db",1,null)

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainViewHolder = MainViewHolder(LayoutInflater
            .from(parent!!.context)!!
            .inflate(R.layout.item_list,parent,false))

    override fun getItemCount(): Int =dataList?.size ?: 0

    override fun onBindViewHolder(holder: MainViewHolder?, position: Int) {
        holder?.toBind(holder,position,dataList)
        holder?.itemView?.delete_item?.setOnClickListener {
            Toast.makeText(holder.itemView.context,"$position 번째 아이템 클릭 확인", Toast.LENGTH_LONG).show()
            dataList?.removeAt(position)
//            mDBHelper.delete(holder?.itemView.name_tv.text.toString())
//            mDBHelper.delete(holder?.itemView.name_tv.text.toString())
            mDBHelper.delete(dataList!![position].id)
            dataList?.removeAt(position)
            notifyDataSetChanged()

        }

    }
}