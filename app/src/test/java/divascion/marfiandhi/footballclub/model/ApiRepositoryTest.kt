package divascion.marfiandhi.footballclub.model

import org.junit.Test

import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

/**
 * Created by Marfiandhi on 9/27/2018.
 */
class ApiRepositoryTest {
    @Test
    fun testDoRequest() {
        val apiRepository = mock(ApiRepository::class.java)
        val url = "https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?l=English%20Premier%20League"
        apiRepository.doRequest(url)
        verify(apiRepository).doRequest(url)
    }
}