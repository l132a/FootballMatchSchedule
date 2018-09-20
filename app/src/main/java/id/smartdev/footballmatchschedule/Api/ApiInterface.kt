package id.smartdev.footballmatchschedule.Api

import id.smartdev.footballmatchschedule.Api.Response.LastMatchResponse
import id.smartdev.footballmatchschedule.Api.Response.TeamResponse
import id.smartdev.footballmatchschedule.Api.Response.MatchResponse
import id.smartdev.footballmatchschedule.Api.Response.NextMatchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("api/v1/json/{api_key}/eventspastleague.php")
    fun getLastMatch(
            @Path("api_key") path: String?,
            @Query("id") parameter: String?
    ): Call<LastMatchResponse>

    @GET("api/v1/json/{api_key}/eventsnextleague.php")
    fun getNextMatch(
            @Path("api_key") path: String?,
            @Query("id") parameter: String?
    ): Call<NextMatchResponse>

    @GET("api/v1/json/{api_key}/lookupevent.php")
    fun getMatch(
        @Path("api_key") path: String?,
        @Query("id") parameter: String?
    ): Call<MatchResponse>

    @GET("api/v1/json/{api_key}/lookupteam.php")
    fun getTeam(
        @Path("api_key") path: String?,
        @Query("id") parameter: String?
    ):Call<TeamResponse>
}