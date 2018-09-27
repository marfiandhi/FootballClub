package divascion.marfiandhi.footballclub.presenter

import com.google.gson.Gson
import divascion.marfiandhi.footballclub.TestContextProvider
import divascion.marfiandhi.footballclub.model.ApiRepository
import divascion.marfiandhi.footballclub.model.TheSportDBApi
import divascion.marfiandhi.footballclub.model.data.Team
import divascion.marfiandhi.footballclub.model.data.TeamResponse
import divascion.marfiandhi.footballclub.view.TeamsView
import org.junit.Test
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * Created by Marfiandhi on 9/27/2018.
 */
class TeamsPresenterTest {

    @Test
    fun testGetTeamList() {
        val teams: MutableList<Team> = mutableListOf()
        val response = TeamResponse(teams)
        val league = "English Premiere League"

        `when`(gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTeams(league)),
                TeamResponse::class.java
        )).thenReturn(response)

        presenter.getTeamList(league)

        verify(view).showLoading()
        verify(view).showTeamList(teams)
        verify(view).hideLoading()
    }

    @Mock
    private
    lateinit var view: TeamsView

    @Mock
    private
    lateinit var gson: Gson

    @Mock
    private
    lateinit var apiRepository: ApiRepository

    private lateinit var presenter: TeamsPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = TeamsPresenter(view, apiRepository, gson, TestContextProvider())
    }

}