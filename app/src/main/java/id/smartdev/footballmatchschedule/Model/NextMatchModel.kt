package id.smartdev.footballmatchschedule.Model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NextMatchModel (
        @SerializedName("idEvent")
        var idEvent: String? = null,
        @SerializedName("strEvent")
        var eventName: String? = null,
        @SerializedName("strHomeTeam")
        var homeTeam: String? = null,
        @SerializedName("strAwayTeam")
        var awayTeam: String? = null,
        @SerializedName("intHomeScore")
        var homeScore: String? = null,
        @SerializedName("intAwayScore")
        var awayScore: String? = null,
        @SerializedName("dateEvent")
        var dateEvent: String? = null,
        @SerializedName("strTime")
        var timeEvent: String? = null,
        @SerializedName("idHomeTeam")
        var idHomeTeam: String? = null,
        @SerializedName("idAwayTeam")
        var idAwayTeam: String? = null
): Parcelable