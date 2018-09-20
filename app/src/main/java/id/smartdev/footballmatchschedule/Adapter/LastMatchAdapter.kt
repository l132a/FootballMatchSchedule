package id.smartdev.footballmatchschedule.Adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import id.smartdev.footballmatchschedule.Model.LastMatchModel
import id.smartdev.footballmatchschedule.Model.Presenter.TeamPresenter
import id.smartdev.footballmatchschedule.Model.TeamModel
import id.smartdev.footballmatchschedule.R
import id.smartdev.footballmatchschedule.Util.Tools
import id.smartdev.footballmatchschedule.View.MainContract
import id.smartdev.footballmatchschedule.View.MatchUI
import org.jetbrains.anko.*

class LastMatchAdapter (private val lastmatch: List<LastMatchModel>, private val listener:(LastMatchModel)->Unit)
    :RecyclerView.Adapter<LastMatchViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LastMatchViewHolder {
        return LastMatchViewHolder(MatchUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: LastMatchViewHolder, position: Int) {
        holder.bindItem(lastmatch[position], listener)
    }

    override fun getItemCount(): Int = lastmatch.size
}

class LastMatchViewHolder(view: View): RecyclerView.ViewHolder(view), MainContract.ViewTeam {

    private val dateEvent = view.find<TextView>(R.id.tv_date_event)
    private val homeTeam = view.find<TextView>(R.id.tv_home_team)
    private val awayTeam = view.find<TextView>(R.id.tv_away_team)
    private val homeScore = view.find<TextView>(R.id.tv_home_score)
    private val awayScore = view.find<TextView>(R.id.tv_away_score)
    private val homeBadge: ImageView = view.find(R.id.iv_home_badge)
    private val awayBadge: ImageView = view.find(R.id.iv_away_badge)
    private lateinit var teamPresenter: TeamPresenter

    fun bindItem(lastmatch: LastMatchModel, listener: (LastMatchModel) -> Unit){
        dateEvent.text = Tools.dateFormat(lastmatch.dateEvent)
        homeTeam.text = lastmatch.homeTeam
        awayTeam.text = lastmatch.awayTeam
        homeScore.text = lastmatch.homeScore
        awayScore.text = lastmatch.awayScore
        val idHomeTeam: String? = lastmatch.idHomeTeam
        val idAwayTeam: String? = lastmatch.idAwayTeam

        itemView.setOnClickListener{listener(lastmatch)}

        teamPresenter = TeamPresenter(this)
        teamPresenter.showHomeBadge(idHomeTeam)
        teamPresenter.showAwayBadge(idAwayTeam)

    }

    override fun showHomeBadge(data: List<TeamModel>) {
        data.forEach {
            Picasso.get().load(it.teamBadge).into(homeBadge)
        }
    }

    override fun showAwayBadge(data: List<TeamModel>) {
        data.forEach {
            Picasso.get().load(it.teamBadge).into(awayBadge)
        }
    }
}
