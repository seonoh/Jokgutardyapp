package com.seonoheam.jokgutardyapp

import com.squareup.otto.Bus

/**
 * Created by seonoheam on 2017. 12. 4..
 */
object Bus {
    private val bus: Bus? = Bus()
    fun getDataBus(): Bus? {
        return bus
    }
}