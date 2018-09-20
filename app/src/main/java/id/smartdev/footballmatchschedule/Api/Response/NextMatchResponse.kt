package id.smartdev.footballmatchschedule.Api.Response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import id.smartdev.footballmatchschedule.Model.NextMatchModel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NextMatchResponse (
    @SerializedName("events")
    var data:List<NextMatchModel>
): Parcelable