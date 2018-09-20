package id.smartdev.footballmatchschedule.Model.Presenter

import id.smartdev.footballmatchschedule.Api.ApiClient
import id.smartdev.footballmatchschedule.Api.Response.MatchResponse
import id.smartdev.footballmatchschedule.BuildConfig
import id.smartdev.footballmatchschedule.View.MainContract
import retrofit2.Call
import retrofit2.Response

class MatchPresenter(private val view: MainContract.ViewMatch) : MainContract.MatchPresenter {

    private var API_KEY: String? = BuildConfig.TSDB_API_KEY

    override fun showData(idEvent: String?){

        view.showLoading()

        val call = ApiClient().getInstance().getMatch(
                API_KEY,idEvent
        )

        call.enqueue(object : retrofit2.Callback<MatchResponse>{

            override fun onFailure(call: Call<MatchResponse>?, t: Throwable?){

                view.hideLoading()
            }

            override fun onResponse(call: Call<MatchResponse>?, response: Response<MatchResponse>?){
                if (response != null){
                    if (response.isSuccessful){

                        val data = response.body()!!.data

                        view.showMatch(data)
                        view.hideLoading()
                    }else{
                        view.hideLoading()
                    }
                }
            }
        })
    }
}