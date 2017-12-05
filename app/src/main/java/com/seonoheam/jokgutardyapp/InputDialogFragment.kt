package com.seonoheam.jokgutardyapp

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import com.seonoheam.jokgutardyapp.model.User
import kotlinx.android.synthetic.main.input_fragment.*
import kotlinx.android.synthetic.main.input_fragment.view.*
import kotlinx.android.synthetic.main.item_list.*

/**
 * Created by seonoheam on 2017. 12. 4..
 */
class InputDialogFragment : DialogFragment() {

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        Log.e("SEONOH","onAttach")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {


        Log.e("SEONOH","onCreateView")
        var view =inflater!!.inflate(R.layout.input_fragment, container, false)

        view.confirm_btn.setOnClickListener {

           var user = User(view.input_name_et.text.toString(),view.input_date_et.text.toString(),view.input_reason_et.text.toString())

        Toast.makeText(activity,"confirm clicked!! ${view.input_name_et.text}",Toast.LENGTH_LONG).show()
            Bus.getDataBus()?.post(user)
        this.dismiss()}

        view.cancle_btn.setOnClickListener {
            Toast.makeText(activity,"cancle clicked!! ",Toast.LENGTH_LONG).show()
            this.dismiss()}

        return view
    }

    override fun onStart() {
        super.onStart()
        Log.e("SEONOH","onStart")
        var window : Window= dialog.window
        window.setLayout(900,900)
        window.setGravity(Gravity.CENTER)

    }

//    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//
//        var rootView =activity.layoutInflater.inflate(R.layout.input_fragment,null)
//        var mBuilder  = AlertDialog.Builder(activity)
//        var layoutInflater = activity.layoutInflater
//        mBuilder.setView(layoutInflater.inflate(R.layout.input_fragment,null))
//
//        rootView.confirm_btn.setOnClickListener {
//                        Toast.makeText(activity,"confirm clicked!!",Toast.LENGTH_LONG).show()
//        }


//        mBuilder.setPositiveButton("확인",DialogInterface.OnClickListener { dialogInterface, i ->
//            Toast.makeText(activity.applicationContext,"confirm clicked!!",Toast.LENGTH_LONG).show()
//            Log.e("SEONOH",rootView.input_name_et.text.toString())
//
//        })
//
//        mBuilder.setNegativeButton("취소",DialogInterface.OnClickListener { dialogInterface, i ->
//            Toast.makeText(activity.applicationContext,"cancle clicked!!",Toast.LENGTH_LONG).show()
//        })

//        return mBuilder.create()
//    }

}