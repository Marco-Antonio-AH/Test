package mx.marco.xaldigital.presentation.screens.home

import mx.marco.xaldigital.data.model.home.ResultData
import mx.marco.xaldigital.domain.model.network.response.CountryResponse
import mx.marco.xaldigital.domain.model.network.response.UserResponse
import mx.marco.xaldigital.presentation.viewstate.ViewState


data class HomeViewState(
    val user: UserResponse = UserResponse(),
    val searchText: String = "",
    val cardDataList: List<ResultData> = listOf(
        ResultData(
            count = 1,
            name = "Hola",
            country = arrayListOf(
                CountryResponse(
                    countryId = "1",
                    probability = 23.1
                )
            ),
        ),
        ),
) : ViewState()