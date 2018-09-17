package divascion.marfiandhi.footballclub.view

import divascion.marfiandhi.footballclub.model.data.Team

/**
 * Created by Marfiandhi on 9/17/2018.
 */
interface TeamDetailView {
    fun showLoading()
    fun hideLoading()
    fun showTeamDetail(data: List<Team>)
}