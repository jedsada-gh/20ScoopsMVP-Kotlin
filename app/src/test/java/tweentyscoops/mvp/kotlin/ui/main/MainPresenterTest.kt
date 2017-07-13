package tweentyscoops.mvp.kotlin.ui.main

import com.google.gson.Gson
import com.hwangjr.rxbus.Bus
import com.hwangjr.rxbus.RxBus
import io.reactivex.Observable
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Matchers.anyString
import org.mockito.Matchers.eq
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.powermock.api.mockito.PowerMockito.*
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import retrofit2.Response
import tweentyscoops.mvp.kotlin.JsonMockUtility
import tweentyscoops.mvp.kotlin.RxSchedulersOverrideRule
import tweentyscoops.mvp.kotlin.api.model.UserInfoDao
import tweentyscoops.mvp.kotlin.api.repository.GithubApi
import tweentyscoops.mvp.kotlin.api.repository.GithupRepostitory

@RunWith(PowerMockRunner::class)
@PrepareForTest(RxBus::class, Gson::class)
class MainPresenterTest {

    @Rule @JvmField val rxSchedulerRule = RxSchedulersOverrideRule()

    @Mock private lateinit var mockGithubApi: GithubApi
    @Mock private lateinit var mockView: MainContract.View
    @Mock private lateinit var bus: Bus
    @Mock private lateinit var mockGson: Gson

    private var githubRepos: GithupRepostitory
    private var spyGithubRepos: GithupRepostitory
    private val jsonMockUtility = JsonMockUtility()
    private var presenter: MainPresenter

    init {
        MockitoAnnotations.initMocks(this)
        mockStatic(RxBus::class.java)
        githubRepos = GithupRepostitory(mockGithubApi)
        spyGithubRepos = spy(githubRepos)
        presenter = MainPresenter(mockGson, githubRepos)
        presenter.attachView(mockView)
        `when`(RxBus.get()).thenReturn(bus)
    }

    @Test
    fun registerRxBus() {
        presenter.onViewStart()
        verify(RxBus.get(), times(1)).register(presenter)
    }

    @Test
    fun unRegisterRxBus() {
        presenter.onViewStop()
        verify(RxBus.get(), times(1)).unregister(presenter)
    }

    @Test
    fun requestGithubApiUserInfo_should_be_success() {
        val mockResult = jsonMockUtility.getJsonToMock("user_info_success.json", UserInfoDao::class.java)
        val mockResponse = Response.success(mockResult)
        assertThat(mockResult.username, `is`("PondThaitay"))
        val mockObservable = Observable.just(mockResponse)
        `when`(spyGithubRepos.observableUserInfo(anyString())).thenReturn(mockObservable)
        presenter.requestUserInfo("pondthaitay")
        val testObserver = mockObservable.test()
        testObserver.awaitTerminalEvent()
        testObserver.assertNoErrors()
        testObserver.assertComplete()
        testObserver.assertValueCount(1)
        testObserver.assertResult(mockResponse)
        testObserver.assertValue { return@assertValue it.body() == mockResponse.body() }
        verify(mockView, times(1)).userInfoData(mockResult)
    }

    @Test
    fun requestGithubApiUserInfo_should_be_empty() {
        val mockResult = jsonMockUtility.getJsonToMock("user_info_success_empty.json", UserInfoDao::class.java)
        val mockResponse = Response.success(mockResult)
        Assert.assertThat(mockResult.username, `is`(""))
        val mockObservable = Observable.just(mockResponse)
        `when`(spyGithubRepos.observableUserInfo(anyString())).thenReturn(mockObservable)
        presenter.requestUserInfo("pondthaitay")
        val testObserver = mockObservable.test()
        testObserver.awaitTerminalEvent()
        testObserver.assertNoErrors()
        testObserver.assertComplete()
        testObserver.assertValueCount(1)
        testObserver.assertResult(mockResponse)
        testObserver.assertValue { return@assertValue it.body() == mockResponse.body() }
        verify(mockView, times(1)).userInfoData(mockResult)
    }

    @Test
    fun requestGithubApiUserInfo_should_be_error() {
        val throwable = Throwable("error")
        val mockObservable = Observable.error<Response<UserInfoDao>>(throwable)
        `when`(spyGithubRepos.observableUserInfo(anyString())).thenReturn(mockObservable)
        presenter.requestUserInfo("pondthaitay")
        val testObserver = mockObservable.test()
        testObserver.awaitTerminalEvent()
        testObserver.assertNotComplete()
        testObserver.assertErrorMessage(throwable.message)
        testObserver.assertError(throwable)
    }

    @Test
    fun heardText_test_should_be_test() {
        presenter.heardText("test")
        verify(mockView, times(1)).updateText(eq("test"))
    }
}