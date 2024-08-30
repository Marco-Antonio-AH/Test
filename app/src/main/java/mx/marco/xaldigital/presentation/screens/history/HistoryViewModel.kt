package mx.marco.xaldigital.presentation.screens.history

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import mx.marco.xaldigital.data.local.insertRecord
import mx.marco.xaldigital.data.local.viewData
import mx.marco.xaldigital.domain.use_case.ListAllUserUseCase
import mx.marco.xaldigital.presentation.viewmodel.BaseViewModel
import mx.marco.xaldigital.util.Resource
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    application: Application,
    private val listAllUserUseCase: ListAllUserUseCase,
) : BaseViewModel(application) {


    val context = getApplication<Application>().applicationContext
    var state by mutableStateOf(HistoryViewState())
        private set

    init {
        seeHistory()
    }

    private fun seeHistory() {
        state = state.copy(
            recordWithProbability = viewData(context),
        )
        println(state.recordWithProbability)

    }
}

