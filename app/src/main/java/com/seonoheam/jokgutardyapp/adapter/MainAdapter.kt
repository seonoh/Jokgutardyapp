package com.seonoheam.jokgutardyapp.adapter

import android.content.Context
import android.database.Cursor
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

    lateinit var cursor:Cursor
    var mDBHelper: DBHelper = DBHelper(context,"seonoh.db",1,null)

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainViewHolder = MainViewHolder(LayoutInflater
            .from(parent!!.context)!!
            .inflate(R.layout.item_list,parent,false))

    override fun getItemCount(): Int =dataList?.size ?: 0

    override fun onBindViewHolder(holder: MainViewHolder?, position: Int) {
        holder?.toBind(holder,position,dataList)
        holder?.itemView?.delete_item?.setOnClickListener {
            Toast.makeText(holder.itemView.context,"$position 번째 아이템 클릭 확인", Toast.LENGTH_LONG).show()
            cursor = mDBHelper.readableDatabase.rawQuery("SELECT * FROM SEONOH", null)

            while (cursor.moveToNext()){
                if(cursor.getInt(0) == dataList!![position].id){
                    mDBHelper.delete(cursor.getInt(0))
                    dataList?.removeAt(position)
                }
            }
            notifyDataSetChanged()

        }

    }
}