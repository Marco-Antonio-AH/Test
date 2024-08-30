package mx.marco.xaldigital.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import mx.marco.xaldigital.data.use_case.ListAllUserUseCaseImpl
import mx.marco.xaldigital.domain.repository.UserRepository
import mx.marco.xaldigital.domain.use_case.ListAllUserUseCase

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
    @Provides
    @ViewModelScoped
    fun provideUserDataUseCase(
        userRepository: UserRepository
    ): ListAllUserUseCase {
        return ListAllUserUseCaseImpl(
            userRepository
        )
    }


}