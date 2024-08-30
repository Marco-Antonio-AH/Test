package mx.marco.xaldigital.presentation.screens.home

sealed class HomeUiEvent {
    data class ShowSnackBar(val message: String) : HomeUiEvent()
}