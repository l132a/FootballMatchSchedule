package id.smartdev.footballmatchschedule.Model.Presenter

import id.smartdev.footballmatchschedule.Api.ApiClient
import id.smartdev.footballmatchschedule.Api.Response.TeamResponse
import id.smartdev.footballmatchschedule.BuildConfig
import id.smartdev.footballmatchschedule.View.MainContract
import retrofit2.Call
import retrofit2.Response

class TeamPresenter(private val view: MainContract.ViewTeam) : MainContract.TeamPresenter {

    private var API_KEY: String? = BuildConfig.TSDB_API_KEY

    override fun showHomeBadge(idTeam: String?){

        val call = ApiClient().getInstance().getTeam(
                API_KEY,idTeam
        )

        call.enqueue(object : retrofit2.Callback<TeamResponse>{

            override fun onFailure(call: Call<TeamResponse>?, t: Throwable?){

            }

            override fun onResponse(call: Call<TeamResponse>?, response: Response<TeamResponse>?){
                if (response != null){
                    if (response.isSuccessful){

                        val data = response.body()!!.data

                        view.showHomeBadge(data)
                    }
                }
            }
        })
    }

    override fun showAwayBadge(idTeam: String?){

        val call = ApiClient().getInstance().getTeam(
                API_KEY,idTeam
        )

        call.enqueue(object : retrofit2.Callback<TeamResponse>{

            override fun onFailure(call: Call<TeamResponse>?, t: Throwable?){

            }

            override fun onResponse(call: Call<TeamResponse>?, response: Response<TeamResponse>?){
                if (response != null){
                    if (response.isSuccessful){

                        val data = response.body()!!.data

                        view.showAwayBadge(data)
                    }
                }
            }
        })
    }
}