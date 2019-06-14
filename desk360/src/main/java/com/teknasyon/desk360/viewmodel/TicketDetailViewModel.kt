package com.teknasyon.desk360.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.teknasyon.desk360.connection.BaseCallback
import com.teknasyon.desk360.connection.RetrofitFactory
import com.teknasyon.desk360.model.Message
import com.teknasyon.desk360.model.MessageResponse
import com.teknasyon.desk360.model.TickeMessage
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

/**
 * Created by seyfullah on 28,May,2019
 *
 */

/**
 * Example local unit test, which will execute on the development machine (host).
 * @author seyfullah polat
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

open class TicketDetailViewModel(val ticketId: Int = -1) : ViewModel() {

    var ticketDetailList: MutableLiveData<ArrayList<Message>>? = MutableLiveData()
    var addMessageItem: MutableLiveData<Message> = MutableLiveData()

    init {
        GlobalScope.launch {
            delay(300)
            getTicketById()
        }
    }

    private fun getTicketById() {
        if (ticketId == -1)
            return
        RetrofitFactory.instance.httpService.getMessages(ticketId)
            .enqueue(object : BaseCallback<TickeMessage>() {
                override fun onResponseSuccess(call: Call<TickeMessage>, response: Response<TickeMessage>) {
                    if (response.isSuccessful && response.body() != null) {
                        ticketDetailList?.value = response.body()!!.data?.messages
                    } else {
                        ticketDetailList?.value = null
                    }
                }
            })
    }

    fun addMessage(id: Int, message: String) {
        RetrofitFactory.instance.httpService.addMessage(id, message)
            .enqueue(object : BaseCallback<MessageResponse>() {
                override fun onResponseSuccess(call: Call<MessageResponse>, response: Response<MessageResponse>) {
                    if (response.isSuccessful && response.body() != null) {
                        if (response.body()!!.meta?.success == true) {
                            addMessageItem.postValue(response.body()!!.data)
                        }
                    } else {
                        ticketDetailList?.value = null
                    }
                }
            })
    }
}