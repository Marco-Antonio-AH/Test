package mx.marco.xaldigital.presentation.screens.history

import mx.marco.xaldigital.data.local.entity.RecordWithProbability
import mx.marco.xaldigital.domain.model.network.response.UserResponse
import mx.marco.xaldigital.presentation.viewstate.ViewState


data class HistoryViewState(
    val user: UserResponse = UserResponse(),
    val recordWithProbability : List<RecordWithProbability> = emptyList()
) : ViewState()