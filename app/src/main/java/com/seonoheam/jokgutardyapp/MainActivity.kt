package com.seonoheam.jokgutardyapp

import android.app.FragmentManager
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.seonoheam.jokgutardyapp.adapter.MainAdapter
import com.seonoheam.jokgutardyapp.db.DBHelper
import com.seonoheam.jokgutardyapp.model.User
import com.squareup.otto.Subscribe
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var user : ArrayList<User>? = null
    var mDBHelper: DBHelper = DBHelper(this,"seonoh.db",1,null)

    companion object {
        var dataList = ArrayList<User>()

    }

    override fun onResume() {
        super.onResume()
        user_list_recyclerView.adapter = null
        user_list_recyclerView.adapter = MainAdapter(dataList)
        user_list_recyclerView.adapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Bus.getDataBus()?.register(this)
        setContentView(R.layout.activity_main)
        setSupportActionBar(main_toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false);
        getSupportActionBar()?.setDisplayShowTitleEnabled(false);
        mDBHelper.getResult()


         var adapter = MainAdapter(dataList)
         var manager = LinearLayoutManager(this)
        user_list_recyclerView.adapter = adapter
        user_list_recyclerView.layoutManager = manager


    }

    @Subscribe
    fun receiveData(receiveData:User){
        Toast.makeText(this,"success data ${receiveData.name}",Toast.LENGTH_LONG).show()
//        dataList.add(receiveData)
//        user = dataList
        user_list_recyclerView.adapter = null
        user_list_recyclerView.adapter = MainAdapter(dataList)
        user_list_recyclerView.adapter.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.toolbar_add->{ Toast.makeText(this,"add clicked!!",Toast.LENGTH_LONG).show()
                var fm = fragmentManager
                var rootView =layoutInflater.inflate(R.layout.input_fragment,null)

                var dialogFragment = InputDialogFragment()

                dialogFragment.show(fm,"fragment dialog test")

            }
        }
        return super.onOptionsItemSelected(item)
    }
}
