package com.seonoheam.jokgutardyapp.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.seonoheam.jokgutardyapp.MainActivity
import com.seonoheam.jokgutardyapp.model.User

/**
 * Created by seonoheam on 2017. 12. 5..
 */
class DBHelper : SQLiteOpenHelper {
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    constructor(context: Context, name:String, version:Int, factory: SQLiteDatabase.CursorFactory?) :
            super(context, name, factory, version)

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE SEONOH (_id INTEGER PRIMARY KEY, name TEXT,  date TEXT, charge INTEGER, reason TEXT);")
    }

    fun insert(name:String,date: String, charge: Int, reason: String) {
        // DB에 입력한 값으로 행 추가
        writableDatabase.execSQL("INSERT INTO SEONOH VALUES(null,'"+name+"','"+ date +"', "+ charge +",'"+ reason +"');")
        writableDatabase.close()
    }

    fun update(name: String, age: Int,phoneNum: String) {
        //  입력한 이름과 동일한 항목의 phoneNum을 수정
        writableDatabase.execSQL("UPDATE SEONOH SET phoneNum='"+phoneNum+"' WHERE name='"+name+"';")
        writableDatabase.close()
    }

    fun delete(name: String) {
        // 입력한 이름의 데이터 삭제
        writableDatabase.execSQL("DELETE FROM SEONOH WHERE name='"+name+"';")
        writableDatabase.close()
    }

    fun getResult(): ArrayList<User> {
        // 읽기가 가능하게 DB 열기
        var result = ""
        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        val cursor = readableDatabase.rawQuery("SELECT * FROM SEONOH", null)
        Log.e("SEONOH","${cursor.count}")

        while (cursor.moveToNext()) {
           MainActivity.dataList.add(User(cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getString(4)))
        }

        return MainActivity.dataList
    }
}