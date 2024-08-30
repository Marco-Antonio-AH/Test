package mx.marco.xaldigital.data.repository

import android.util.Log
import mx.marco.xaldigital.data.remote.XalDigitalApiService
import mx.marco.xaldigital.domain.model.network.response.UserResponse
import mx.marco.xaldigital.domain.repository.UserRepository
import mx.marco.xaldigital.util.Resource

class UserRepositoryImpl(
    private val api: XalDigitalApiService,
) : UserRepository {
    override suspend fun getListAllUser( name : String
    ): Resource<UserResponse> {
        return try {
            val response = api.getListAllUser(name)
            Resource.Success(response)
        } catch (e: Exception) {
            Log.e("apiError", e.message ?: "Error")
            Resource.Error(e.message ?: "Error")
        }
    }
}