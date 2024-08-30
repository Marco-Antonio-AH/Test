package mx.marco.xaldigital.data.model.home


import mx.marco.xaldigital.domain.model.network.response.CountryResponse

data class ResultData(
    val count: Int = 0,
    val name: String = "",
    val country: ArrayList<CountryResponse> = arrayListOf()
)


