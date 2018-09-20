package id.smartdev.footballmatchschedule.Util

import java.text.SimpleDateFormat
import java.util.*

class Tools {

    companion object {

        fun timeFormat(time: String?): String{
            if (time.isNullOrBlank()) {
                return time.orEmpty()
            }else{
                return time!!.substring(0,8)
            }
        }

        fun dateFormat(data: String?): String {
            if (data.isNullOrBlank()) {
                return data.orEmpty()
            }else {
                val dateFormat = SimpleDateFormat("yyyy-MM-d", Locale.getDefault())
                val date: Date = dateFormat.parse(data)
                val df = SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault())
                val stringDate = df.format(date)
                return stringDate
            }
        }

        fun dataSplit(data: String?): String{
            if (data.isNullOrBlank()) {
                return data.orEmpty()
            }else{
                val separate = data!!.replace(";", "\n").split(";")
                return separate.joinToString()
            }
        }
    }

}