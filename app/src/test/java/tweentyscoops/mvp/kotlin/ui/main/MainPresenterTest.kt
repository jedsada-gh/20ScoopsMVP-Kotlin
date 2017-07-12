package tweentyscoops.mvp.kotlin.ui.main

import com.nhaarman.mockito_kotlin.*
import io.reactivex.Observable
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.MockitoAnnotations
import retrofit2.Response
import tweentyscoops.mvp.kotlin.JsonMockUtility
import tweentyscoops.mvp.kotlin.RxSchedulersOverrideRule
import tweentyscoops.mvp.kotlin.api.model.UserInfoDao
import tweentyscoops.mvp.kotlin.api.repository.GithubApi
import tweentyscoops.mvp.kotlin.api.repository.GithupRepostitory

@RunWith(JUnit4::class)
class MainPresenterTest {

    @Rule @JvmField val rxSchedulerRule = RxSchedulersOverrideRule()

    private val mockGithubApi = mock<GithubApi> { }
    private val mockView = mock<MainContract.View>()
    private val githubRepos = GithupRepostitory(mockGithubApi)
    private val spyGithubRepos = spy(githubRepos)

    private val jsonMockUtility = JsonMockUtility()
    private val presenter = MainPresenter(githubRepos)

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter.attachView(mockView)
    }

    @Test
    fun requestGithubApiUserInfo_should_be_success() {
        val mockResult = jsonMockUtility.getJsonToMock("user_info_success.json", UserInfoDao::class.java)
        val mockResponse = Response.success(mockResult)
        Assert.assertEquals(mockResult.username, "PondThaitay")
        val mockObservable = Observable.just(mockResponse)
        whenever(spyGithubRepos.observableUserInfo(anyVararg())).thenReturn(mockObservable)
        presenter.test()
        val testObserver = mockObservable.test()
        testObserver.awaitTerminalEvent()
        testObserver.assertNoErrors()
        testObserver.assertComplete()
        testObserver.assertValueCount(1)
        testObserver.assertResult(mockResponse)
        testObserver.assertValue { return@assertValue it.body() == mockResponse.body() }
        verify(mockView, times(1)).test()
    }

    @Test
    fun requestGithubApiUserInfo_should_be_error() {
        val throwable = Throwable("error")
        val mockObservable = Observable.error<Response<UserInfoDao>>(throwable)
        whenever(spyGithubRepos.observableUserInfo(anyVararg())).thenReturn(mockObservable)
        presenter.test()
        val testObserver = mockObservable.test()
        testObserver.awaitTerminalEvent()
        testObserver.assertNotComplete()
        testObserver.assertErrorMessage(throwable.message)
        testObserver.assertError(throwable)
    }
}