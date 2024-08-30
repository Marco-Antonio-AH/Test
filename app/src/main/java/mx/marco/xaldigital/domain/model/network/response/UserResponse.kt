package mx.marco.xaldigital.domain.model.network.response

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("count"   ) var count   : Int?               = null,
    @SerializedName("name"    ) var name    : String?            = null,
    @SerializedName("country" ) var country : ArrayList<CountryResponse> = arrayListOf()
)
