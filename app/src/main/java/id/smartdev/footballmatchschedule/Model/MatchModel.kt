package id.smartdev.footballmatchschedule.Model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MatchModel(
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
        @SerializedName("strHomeFormation")
        var homeFormation: String? = null,
        @SerializedName("strAwayFormation")
        var awayFormation: String? = null,
        @SerializedName("strHomeGoalDetails")
        var homeGoal: String? = null,
        @SerializedName("strAwayGoalDetails")
        var awayGoal: String? = null,
        @SerializedName("intHomeShots")
        var homeShots: String? = null,
        @SerializedName("intAwayShots")
        var awayShots: String? = null,
        @SerializedName("strHomeRedCards")
        var homeRedCard: String? = null,
        @SerializedName("strAwayRedCards")
        var awayRedCard: String? = null,
        @SerializedName("strHomeYellowCards")
        var homeYellowCard: String? = null,
        @SerializedName("strAwayYellowCards")
        var awayYellowCard: String? = null,
        @SerializedName("strHomeLineupGoalkeeper")
        var homeKeeper: String? = null,
        @SerializedName("strAwayLineupGoalkeeper")
        var awayKeeper: String? = null,
        @SerializedName("strHomeLineupDefense")
        var homeDefense: String? = null,
        @SerializedName("strAwayLineupDefense")
        var awayDefense: String? = null,
        @SerializedName("strHomeLineupMidfield")
        var homeMidfield: String? = null,
        @SerializedName("strAwayLineupMidfield")
        var awayMidfield: String? = null,
        @SerializedName("strHomeLineupForward")
        var homeFordward: String? = null,
        @SerializedName("strAwayLineupForward")
        var awayFordward: String? = null,
        @SerializedName("strHomeLineupSubstitutes")
        var homeSubstitutes: String? = null,
        @SerializedName("strAwayLineupSubstitutes")
        var awaySubstitutes: String? = null
) : Parcelable