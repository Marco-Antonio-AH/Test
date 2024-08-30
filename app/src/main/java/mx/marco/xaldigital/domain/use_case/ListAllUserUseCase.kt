package mx.marco.xaldigital.domain.use_case

import mx.marco.xaldigital.domain.model.network.response.UserResponse
import mx.marco.xaldigital.util.Resource


interface ListAllUserUseCase {
    suspend operator fun invoke( name : String): Resource<UserResponse>

}