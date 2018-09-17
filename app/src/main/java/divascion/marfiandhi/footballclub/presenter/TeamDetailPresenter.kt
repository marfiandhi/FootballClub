package divascion.marfiandhi.footballclub.presenter

import com.google.gson.Gson
import divascion.marfiandhi.footballclub.model.ApiRepository
import divascion.marfiandhi.footballclub.model.TheSportDBApi
import divascion.marfiandhi.footballclub.model.data.TeamResponse
import divascion.marfiandhi.footballclub.view.TeamDetailView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by Marfiandhi on 9/17/2018.
 */
class TeamDetailPresenter(private val view: TeamDetailView,
                          private val apiRepository: ApiRepository,
                          private val gson: Gson) {

    fun getTeamDetail(teamId: String) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getTeamDetail(teamId)),
                    TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamDetail(data.teams)
            }
        }
    }
}