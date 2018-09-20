package id.smartdev.footballmatchschedule.Model.Presenter

import id.smartdev.footballmatchschedule.Api.ApiClient
import id.smartdev.footballmatchschedule.Api.Response.LastMatchResponse
import id.smartdev.footballmatchschedule.BuildConfig
import id.smartdev.footballmatchschedule.View.MainContract
import retrofit2.Call
import retrofit2.Response

class LastMatchPresenter(private val view: MainContract.ViewLast) : MainContract.Presenter {

    private var API_KEY: String? = BuildConfig.TSDB_API_KEY
    private var LEAGUE_ID: String? = "4328"

    override fun showData(){

        view.showLoading()

        val call = ApiClient().getInstance().getLastMatch(
                API_KEY,LEAGUE_ID
        )

        call.enqueue(object : retrofit2.Callback<LastMatchResponse>{

            override fun onFailure(call: Call<LastMatchResponse>?, t: Throwable?){

                view.hideLoading()
            }

            override fun onResponse(call: Call<LastMatchResponse>?, response: Response<LastMatchResponse>?){
                if (response != null){
                    if (response.isSuccessful){

                        val data = response.body()!!.data

                        view.showLastMatch(data)
                        view.hideLoading()
                    }else{
                        view.hideLoading()
                    }
                }
            }
        })
    }
}