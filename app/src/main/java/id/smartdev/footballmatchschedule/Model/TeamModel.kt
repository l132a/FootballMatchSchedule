package id.smartdev.footballmatchschedule.Model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TeamModel (
        @SerializedName("strTeamBadge")
        var teamBadge: String? = null
):Parcelable
