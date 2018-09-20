package id.smartdev.footballmatchschedule.Api.Response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import id.smartdev.footballmatchschedule.Model.MatchModel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MatchResponse (
        @SerializedName("events")
        var data:List<MatchModel>
): Parcelable