package mx.marco.xaldigital.presentation.screens.home

sealed class HomeViewEvent{

    data class OnSearchTextChange(val newSearchText: String):HomeViewEvent()
    object OnSearchButtonClicked : HomeViewEvent()
}