package id.smartdev.footballmatchschedule.View

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import id.smartdev.footballmatchschedule.Adapter.LastMatchAdapter
import id.smartdev.footballmatchschedule.Model.LastMatchModel
import id.smartdev.footballmatchschedule.R.color.colorAccent
import id.smartdev.footballmatchschedule.R
import id.smartdev.footballmatchschedule.Util.invisible
import id.smartdev.footballmatchschedule.Util.visible
import id.smartdev.footballmatchschedule.Model.Presenter.LastMatchPresenter
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.*

class LastMatchFragment : Fragment(), AnkoComponent<Context>, MainContract.ViewLast {

    private var lastmatch: MutableList<LastMatchModel> = mutableListOf()
    private lateinit var adapter: LastMatchAdapter
    private lateinit var matchEvent: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var progressBar: ProgressBar
    private lateinit var presenter: LastMatchPresenter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = LastMatchAdapter(lastmatch){

            startActivity<DetailLastActivity>(
                    "idEvent" to "${it.idEvent}",
                    "idHomeTeam" to "${it.idHomeTeam}",
                    "idAwayTeam" to "${it.idAwayTeam}",
                    "eventName" to "${it.eventName}"
            )
        }

        presenter = LastMatchPresenter(this)
        presenter.showData()
        swipeRefreshLayout.onRefresh {
            presenter.showData()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return createView(AnkoContext.create(ctx))
    }

    override fun createView(ui: AnkoContext<Context>): View = with(ui){
        linearLayout {
            lparams(width = matchParent, height = wrapContent)
            orientation = LinearLayout.VERTICAL
            topPadding = dip(4)
            leftPadding = dip(4)
            rightPadding = dip(4)

            swipeRefreshLayout = swipeRefreshLayout {
                setColorSchemeResources(colorAccent,
                        android.R.color.holo_green_light,
                        android.R.color.holo_orange_light,
                        android.R.color.holo_red_light
                )
                relativeLayout {
                    lparams(width = matchParent, height = wrapContent)
                    matchEvent = recyclerView {
                        id = R.id.rv_last_match_event
                        lparams(width = matchParent, height = wrapContent)
                        layoutManager = LinearLayoutManager(ctx)
                    }
                    progressBar = progressBar {

                    }.lparams {
                        centerHorizontally()
                    }

                }
            }
        }
    }

    override fun showLoading(){
        progressBar.visible()
    }
    override fun hideLoading(){
        progressBar.invisible()
    }
    override fun showLastMatch(data: List<LastMatchModel>){
        swipeRefreshLayout.isRefreshing = false
        lastmatch.clear()
        lastmatch.addAll(data)
        adapter.notifyDataSetChanged()
        matchEvent.adapter = adapter

    }
}