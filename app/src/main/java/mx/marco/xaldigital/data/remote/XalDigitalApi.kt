package mx.marco.xaldigital.data.remote

import mx.marco.xaldigital.domain.model.network.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface XalDigitalApiService {

    @GET("/")
    suspend fun getListAllUser(
       @Query("name") name: String
    ): UserResponse

}
