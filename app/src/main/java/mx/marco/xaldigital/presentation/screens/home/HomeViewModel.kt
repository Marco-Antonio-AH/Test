package mx.marco.xaldigital.presentation.screens.home

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import mx.marco.xaldigital.data.local.insertRecord
import mx.marco.xaldigital.domain.use_case.ListAllUserUseCase
import mx.marco.xaldigital.presentation.viewmodel.BaseViewModel
import mx.marco.xaldigital.util.Resource
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    application: Application,
    private val listAllUserUseCase: ListAllUserUseCase,
) : BaseViewModel(application) {


    val context = getApplication<Application>().applicationContext
    var state by mutableStateOf(HomeViewState())
        private set

    private val _uiEvent = Channel<HomeUiEvent>()

    init {
        initViewState(HomeViewState())
        fetchListPokemon()

    }



    fun onEvent(event: HomeViewEvent) {
        when (event) {
            is HomeViewEvent.OnSearchTextChange -> onSearchTextChange(event.newSearchText)
            HomeViewEvent.OnSearchButtonClicked -> fetchListPokemon()
        }
    }

    private fun onSearchTextChange(newSearchText: String) {
        state = state.copy(
            searchText = newSearchText,
        )

    }

    private fun fetchListPokemon() {
        viewModelScope.launch {
            try {
                val searchText = state.searchText
                when (val response = searchText.let { listAllUserUseCase.invoke(name = it) }) {
                    is Resource.Error -> {
                        _uiEvent.send(HomeUiEvent.ShowSnackBar(response.message ?: ""))
                        println("$response hubo error")
                    }

                    is Resource.Success -> {

                        val resultData = response.data!!
                        insertRecord(context = context, resultData = resultData)
                        resultData.country.forEach { country ->
                            println("Country ID: ${country.countryId}, Probability: ${country.probability}")
                        }


                        state = state.copy(
                            user = resultData.copy(
                                count = resultData.count,
                                name = resultData.name,
                                country = resultData.country
                            )
                        )
                    }

                }
            } catch (e: Exception) {
                println("error: $e error")
            }
        }
    }


    /*private fun saveDb(resultData : UserResponse){
        val record = RecordEntity(name = resultData.name!!)
        val recordId =  recordDao.insertRecord()
    }*/


}

/*// Ejemplo de inserción
val user = User(name = "John Doe")
val userId = userDao.insertUser(user)

val post1 = Post(title = "Primer Post", content = "Contenido del primer post", userOwnerId = userId)
val post2 = Post(title = "Segundo Post", content = "Contenido del segundo post", userOwnerId = userId)

userDao.insertPost(post1)
userDao.insertPost(post2)

// Consultar usuario con sus posts
val userWithPosts = userDao.getUserWithPosts(userId)
println("Usuario: ${userWithPosts?.user?.name}")
userWithPosts?.posts?.forEach { post ->
    println("Post: ${post.title} - ${post.content}")
}*/
