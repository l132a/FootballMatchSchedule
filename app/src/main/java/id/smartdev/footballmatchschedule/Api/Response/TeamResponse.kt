package id.smartdev.footballmatchschedule.Api.Response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import id.smartdev.footballmatchschedule.Model.TeamModel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TeamResponse(
        @SerializedName("teams")
        var data:List<TeamModel>
):Parcelable