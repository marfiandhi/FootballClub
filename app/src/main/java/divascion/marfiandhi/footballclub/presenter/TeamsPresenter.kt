package divascion.marfiandhi.footballclub.presenter

import com.google.gson.Gson
import divascion.marfiandhi.footballclub.model.ApiRepository
import divascion.marfiandhi.footballclub.model.TheSportDBApi
import divascion.marfiandhi.footballclub.model.data.TeamResponse
import divascion.marfiandhi.footballclub.view.TeamsView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by Marfiandhi on 9/4/2018.
 */
class TeamsPresenter(private val view: TeamsView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson) {
    fun getTeamList(league: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getTeams(league)),
                    TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)
            }
        }
    }
}