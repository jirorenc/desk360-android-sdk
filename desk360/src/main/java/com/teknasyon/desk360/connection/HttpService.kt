package com.teknasyon.desk360.connection

import com.teknasyon.desk360.model.MessageResponse
import com.teknasyon.desk360.model.TickeMessage
import com.teknasyon.desk360.model.TicketListResponse
import com.teknasyon.desk360.model.TicketResponse
import retrofit2.Call
import retrofit2.http.*

interface HttpService {
    @POST("api/v1/tickets")
    fun addTicket(@Body ticketResponse: TicketResponse): Call<Any>

    @GET("api/v1/tickets")
    fun getTicket(): Call<TicketListResponse>

    @GET("api/v1/tickets/{ticket_id}")
    fun getMessages(@Path("ticket_id") ticket_id: Int): Call<TickeMessage>

    @POST("api/v1/tickets/{ticket_id}/messages")
    fun addMessage(@Path("ticket_id") ticket_id: Int, @Query("message") message: String): Call<MessageResponse>

    @GET("api/v1/tickets/types/list")
    fun getTypeList(): Call<Any>
}
