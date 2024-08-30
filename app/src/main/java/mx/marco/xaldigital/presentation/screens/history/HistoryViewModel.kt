package mx.marco.xaldigital.presentation.screens.history

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dagger.hilt.android.lifecycle.HiltViewModel
import mx.marco.xaldigital.data.local.viewData
import mx.marco.xaldigital.domain.use_case.ListAllUserUseCase
import mx.marco.xaldigital.presentation.viewmodel.BaseViewModel
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

