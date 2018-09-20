package id.smartdev.footballmatchschedule.View

import id.smartdev.footballmatchschedule.Model.LastMatchModel
import id.smartdev.footballmatchschedule.Model.TeamModel
import id.smartdev.footballmatchschedule.Model.MatchModel
import id.smartdev.footballmatchschedule.Model.NextMatchModel

interface MainContract {

    interface Presenter{
        fun showData()
    }

    interface MatchPresenter{
        fun showData(idEvent: String?)
    }

    interface TeamPresenter{
        fun showHomeBadge(idTeam: String?)
        fun showAwayBadge(idTeam: String?)
    }

    interface ViewLast{
        fun showLoading()
        fun hideLoading()
        fun showLastMatch(data:List<LastMatchModel>)
    }

    interface ViewNext{
        fun showLoading()
        fun hideLoading()
        fun showNextMatch(data:List<NextMatchModel>)
    }

    interface ViewTeam{
        fun showHomeBadge(data:List<TeamModel>)
        fun showAwayBadge(data:List<TeamModel>)
    }

    interface ViewMatch{
        fun showLoading()
        fun hideLoading()
        fun showMatch(data:List<MatchModel>)
    }
}