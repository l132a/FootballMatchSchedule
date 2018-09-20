package id.smartdev.footballmatchschedule.Adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import id.smartdev.footballmatchschedule.Model.NextMatchModel
import id.smartdev.footballmatchschedule.Model.Presenter.TeamPresenter
import id.smartdev.footballmatchschedule.Model.TeamModel
import id.smartdev.footballmatchschedule.R
import id.smartdev.footballmatchschedule.Util.Tools
import id.smartdev.footballmatchschedule.View.MainContract
import id.smartdev.footballmatchschedule.View.MatchUI
import org.jetbrains.anko.*

class NextMatchAdapter(private val nextmatch: List<NextMatchModel>, private val listener: (NextMatchModel)->Unit)
    :RecyclerView.Adapter<NextMatchViewHolver>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NextMatchViewHolver {
        return NextMatchViewHolver(MatchUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: NextMatchViewHolver, position: Int) {
        holder.bindItem(nextmatch[position], listener)
    }

    override fun getItemCount(): Int = nextmatch.size
}

class NextMatchViewHolver(view: View):RecyclerView.ViewHolder(view), MainContract.ViewTeam {

    private val dateEvent = view.find<TextView>(R.id.tv_date_event)
    private val homeTeam = view.find<TextView>(R.id.tv_home_team)
    private val awayTeam = view.find<TextView>(R.id.tv_away_team)
    private val homeScore = view.find<TextView>(R.id.tv_home_score)
    private val awayScore = view.find<TextView>(R.id.tv_away_score)
    private val homeBadge: ImageView = view.find(R.id.iv_home_badge)
    private val awayBadge: ImageView = view.find(R.id.iv_away_badge)
    private lateinit var teamPresenter: TeamPresenter

    fun bindItem(nextmatch: NextMatchModel, listener: (NextMatchModel) -> Unit){

        dateEvent.text = Tools.dateFormat(nextmatch.dateEvent)
        homeTeam.text = nextmatch.homeTeam
        awayTeam.text = nextmatch.awayTeam
        homeScore.text = nextmatch.homeScore
        awayScore.text = nextmatch.awayScore

        val idHomeTeam: String? = nextmatch.idHomeTeam
        val idAwayTeam: String? = nextmatch.idAwayTeam

        itemView.setOnClickListener{listener(nextmatch)}

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
