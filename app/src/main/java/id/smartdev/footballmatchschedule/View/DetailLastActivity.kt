package id.smartdev.footballmatchschedule.View

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.ProgressBar
import id.smartdev.footballmatchschedule.R
import android.widget.TextView
import com.squareup.picasso.Picasso
import id.smartdev.footballmatchschedule.Model.MatchModel
import id.smartdev.footballmatchschedule.Model.Presenter.MatchPresenter
import id.smartdev.footballmatchschedule.Model.Presenter.TeamPresenter
import id.smartdev.footballmatchschedule.Model.TeamModel
import id.smartdev.footballmatchschedule.Util.Tools
import id.smartdev.footballmatchschedule.Util.invisible
import id.smartdev.footballmatchschedule.Util.visible
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView
import android.view.MenuItem


class DetailLastActivity: AppCompatActivity(),MainContract.ViewMatch, MainContract.ViewTeam {

    private lateinit var progressBar: ProgressBar
    private lateinit var teamPresenter: TeamPresenter
    private lateinit var matchPresenter: MatchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DetailUI().setContentView(this)

        matchPresenter = MatchPresenter(this)
        teamPresenter = TeamPresenter(this)

        progressBar = find(R.id.pb_loading)

        val i = intent
        val idEvent: String? = i.getStringExtra("idEvent")
        val idHomeTeam: String? = i.getStringExtra("idHomeTeam")
        val idAwayTeam: String? = i.getStringExtra("idAwayTeam")
        val eventName: String? = i.getStringExtra("eventName")

        matchPresenter.showData(idEvent)
        teamPresenter.showHomeBadge(idHomeTeam)
        teamPresenter.showAwayBadge(idAwayTeam)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(eventName)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun showLoading(){
        progressBar.visible()
    }
    override fun hideLoading(){
        progressBar.invisible()
    }

    override fun showMatch(data: List<MatchModel>){

        val timeEvent = find<TextView>(R.id.tv_time_event)
        val awayTeam = find<TextView>(R.id.tv_away_team)
        val dateEvent = find<TextView>(R.id.tv_date_event)
        val homeScore = find<TextView>(R.id.tv_home_score)
        val awayScore = find<TextView>(R.id.tv_away_score)
        val homeTeam = find<TextView>(R.id.tv_home_team)
        val tvVs = find<TextView>(R.id.tv_vs_match)
        val homeFormation =  find<TextView>(R.id.tv_home_formation)
        val awayFormation = find<TextView>(R.id.tv_away_formation)
        val tvGoals = find<TextView>(R.id.tv_goals)
        val tvShots = find<TextView>(R.id.tv_shots)
        val homeShots = find<TextView>(R.id.tv_home_shots)
        val awayShots = find<TextView>(R.id.tv_away_shots)
        val homeGoals = find<TextView>(R.id.tv_home_goals)
        val awayGoals = find<TextView>(R.id.tv_away_goals)
        val tvLineups = find<TextView>(R.id.tv_lineups)
        val tvKeeper = find<TextView>(R.id.tv_keeper)
        val homeKeeper = find<TextView>(R.id.tv_home_keeper)
        val awayKeeper = find<TextView>(R.id.tv_away_keeper)
        val tvDefense = find<TextView>(R.id.tv_defense)
        val homeDefense = find<TextView>(R.id.tv_home_defense)
        val awayDefense = find<TextView>(R.id.tv_away_defense)
        val tvMidfield = find<TextView>(R.id.tv_midfield)
        val homeMidfield = find<TextView>(R.id.tv_home_midfield)
        val awayMidfield = find<TextView>(R.id.tv_away_midfield)
        val tvForwoard = find<TextView>(R.id.tv_forwoard)
        val homeForwoard = find<TextView>(R.id.tv_home_forwoard)
        val awayForwoard = find<TextView>(R.id.tv_away_forwoard)
        val tvSubstitutes = find<TextView>(R.id.tv_substitutes)
        val homeSubstitutes = find<TextView>(R.id.tv_home_substitutes)
        val awaySubstitutes = find<TextView>(R.id.tv_away_substitutes)
        val tvRedCard = find<TextView>(R.id.tv_red_card)
        val homeRedCard = find<TextView>(R.id.tv_home_red_card)
        val awayRedCard = find<TextView>(R.id.tv_away_red_card)
        val tvYellowCard = find<TextView>(R.id.tv_yellow_card)
        val homeYellowCard = find<TextView>(R.id.tv_home_yellow_card)
        val awayYellowCard = find<TextView>(R.id.tv_away_yellow_card)

        data.forEach {
            dateEvent.text = Tools.dateFormat(it.dateEvent)
            timeEvent.text = Tools.timeFormat(it.timeEvent)
            homeScore.text = it.homeScore
            awayScore.text = it.awayScore
            homeTeam.text = it.homeTeam
            awayTeam.text = it.awayTeam
            homeFormation.text = it.homeFormation
            awayFormation.text = it.awayFormation
            homeGoals.text = Tools.dataSplit(it.homeGoal)
            awayGoals.text = Tools.dataSplit(it.awayGoal)
            homeShots.text = it.homeShots
            awayShots.text = it.awayShots
            homeKeeper.text = Tools.dataSplit(it.homeKeeper)
            awayKeeper.text = Tools.dataSplit(it.awayKeeper)
            homeDefense.text = Tools.dataSplit(it.homeDefense)
            awayDefense.text = Tools.dataSplit(it.awayDefense)
            homeMidfield.text = Tools.dataSplit(it.homeMidfield)
            awayMidfield.text = Tools.dataSplit(it.awayMidfield)
            homeForwoard.text = Tools.dataSplit(it.homeFordward)
            awayForwoard.text = Tools.dataSplit(it.awayFordward)
            homeSubstitutes.text = Tools.dataSplit(it.homeSubstitutes)
            awaySubstitutes.text = Tools.dataSplit(it.awaySubstitutes)
            homeRedCard.text = Tools.dataSplit(it.homeRedCard)
            awayRedCard.text = Tools.dataSplit(it.homeRedCard)
            homeYellowCard.text = Tools.dataSplit(it.homeYellowCard)
            awayYellowCard.text = Tools.dataSplit(it.awayYellowCard)
        }
        tvVs.text = getString(R.string.vs)
        tvGoals.text = getString(R.string.goals)
        tvShots.text = getString(R.string.shots)
        tvLineups.text = getString(R.string.lineups)
        tvKeeper.text = getString(R.string.goal_keeper)
        tvDefense.text = getString(R.string.defense)
        tvMidfield.text = getString(R.string.midfield)
        tvForwoard.text = getString(R.string.fordwoard)
        tvSubstitutes.text = getString(R.string.substitutes)
        tvYellowCard.text = getString(R.string.yellow_card)
        tvRedCard.text = getString(R.string.red_card)
    }

    override fun showHomeBadge(data: List<TeamModel>){
        val homeBadge: ImageView = find(R.id.iv_home_badge)
        data.forEach {
            Picasso.get().load(it.teamBadge).into(homeBadge)
        }
    }

    override fun showAwayBadge(data: List<TeamModel>){
        val awayBadge: ImageView = find(R.id.iv_away_badge)
        data.forEach {
            Picasso.get().load(it.teamBadge).into(awayBadge)
        }
    }
}