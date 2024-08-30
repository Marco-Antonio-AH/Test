package mx.marco.xaldigital.domain.model.network.response

import com.google.gson.annotations.SerializedName

data class CountryResponse (

    @SerializedName("country_id"  ) var countryId   : String? = null,
    @SerializedName("probability" ) var probability : Double? = null

)