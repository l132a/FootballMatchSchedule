package id.smartdev.footballmatchschedule.Api.Response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import id.smartdev.footballmatchschedule.Model.LastMatchModel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LastMatchResponse (
    @SerializedName("events")
    var data: List<LastMatchModel>
): Parcelable