package mx.marco.xaldigital.data.use_case

import mx.marco.xaldigital.domain.model.network.response.UserResponse
import mx.marco.xaldigital.domain.repository.UserRepository
import mx.marco.xaldigital.domain.use_case.ListAllUserUseCase
import mx.marco.xaldigital.util.Resource

class ListAllUserUseCaseImpl(
    private val userRepository: UserRepository
) : ListAllUserUseCase {

    override suspend fun invoke(name : String): Resource<UserResponse> {
        return userRepository.getListAllUser(name )
    }

}