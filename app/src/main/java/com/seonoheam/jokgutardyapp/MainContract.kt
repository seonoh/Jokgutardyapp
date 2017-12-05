package com.seonoheam.jokgutardyapp

/**
 * Created by seonoheam on 2017. 12. 4..
 */
interface MainContract {
    interface View{}
    interface Model{
        fun addItem()
    }
    interface Presenter{}
}