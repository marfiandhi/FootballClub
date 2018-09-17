package divascion.marfiandhi.footballclub.view

import divascion.marfiandhi.footballclub.model.data.Team

/**
 * Created by Marfiandhi on 9/4/2018.
 */
interface TeamsView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}