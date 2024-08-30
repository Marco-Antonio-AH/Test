package mx.marco.xaldigital.domain.repository


import mx.marco.xaldigital.domain.model.network.response.UserResponse
import mx.marco.xaldigital.util.Resource

interface UserRepository {
    suspend fun getListAllUser( name : String): Resource<UserResponse>
}