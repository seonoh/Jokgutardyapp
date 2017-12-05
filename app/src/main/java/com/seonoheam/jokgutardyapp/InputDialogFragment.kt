package com.seonoheam.jokgutardyapp

import android.app.Activity
import android.app.DialogFragment
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import com.seonoheam.jokgutardyapp.db.DBHelper
import com.seonoheam.jokgutardyapp.model.User
import kotlinx.android.synthetic.main.input_fragment.view.*

/**
 * Created by seonoheam on 2017. 12. 4..
 */
class InputDialogFragment : DialogFragment() {



    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        Log.e("SEONOH","onAttach")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
         var mDBHelper = DBHelper(activity.applicationContext,"seonoh.db",1,null)

        var view =inflater!!.inflate(R.layout.input_fragment, container, false)

        view.confirm_btn.setOnClickListener {

            mDBHelper.insert(     view.input_name_et.text.toString(),view.input_date_et.text.toString()
                                                ,view.input_charge_et.text.toString().toInt(),view.input_reason_et.text.toString() )

            val user = User(  view.input_name_et.text.toString(),view.input_date_et.text.toString()
                    ,view.input_charge_et.text.toString().toInt(),view.input_reason_et.text.toString())
            MainActivity.dataList.add(user)

            Toast.makeText(activity,"confirm clicked!! ${view.input_name_et.text}",Toast.LENGTH_LONG).show()
            this.dismiss()
        }

        view.cancle_btn.setOnClickListener {
            Toast.makeText(activity,"cancle clicked!! ",Toast.LENGTH_LONG).show()
            this.dismiss()}

        return view
    }

    override fun onStart() {
        super.onStart()
        Log.e("SEONOH","onStart")
        var window : Window= dialog.window
        window.setLayout(900,1200)
        window.setGravity(Gravity.CENTER)

    }

}