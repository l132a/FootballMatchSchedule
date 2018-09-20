package id.smartdev.footballmatchschedule.Model.Presenter

import id.smartdev.footballmatchschedule.Api.ApiClient
import id.smartdev.footballmatchschedule.Api.Response.NextMatchResponse
import id.smartdev.footballmatchschedule.BuildConfig
import id.smartdev.footballmatchschedule.View.MainContract
import retrofit2.Call
import retrofit2.Response

class NextMatchPresenter(private val view: MainContract.ViewNext) : MainContract.Presenter {

    private var API_KEY: String? = BuildConfig.TSDB_API_KEY
    private var LEAGUE_ID: String? = "4328"

    override fun showData(){

        view.showLoading()

        val call = ApiClient().getInstance().getNextMatch(
                API_KEY,LEAGUE_ID
        )

        call.enqueue(object : retrofit2.Callback<NextMatchResponse>{

            override fun onFailure(call: Call<NextMatchResponse>?, t: Throwable?){

                view.hideLoading()
            }

            override fun onResponse(call: Call<NextMatchResponse>?, response: Response<NextMatchResponse>?){
                if (response != null){
                    if (response.isSuccessful){

                        val data = response.body()!!.data

                        view.showNextMatch(data)
                        view.hideLoading()
                    }else{
                        view.hideLoading()
                    }
                }
            }
        })
    }
}