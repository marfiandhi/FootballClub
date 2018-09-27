package divascion.marfiandhi.footballclub.presenter

import divascion.marfiandhi.footballclub.model.ApiRepository
import divascion.marfiandhi.footballclub.model.TheSportDBApi
import divascion.marfiandhi.footballclub.model.data.TeamResponse
import divascion.marfiandhi.footballclub.CoroutineContextProvider
import divascion.marfiandhi.footballclub.view.TeamsView
import com.google.gson.Gson
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

/**
 * Created by Marfiandhi on 9/4/2018.
 */
class TeamsPresenter(private val view: TeamsView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson, private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getTeamList(league: String?) {
        view.showLoading()

        async(context.main){
            val data = bg {
                gson.fromJson(apiRepository
                        .doRequest(TheSportDBApi.getTeams(league)),
                        TeamResponse::class.java
                )
            }
            view.showTeamList(data.await().teams)
            view.hideLoading()
        }
    }
}