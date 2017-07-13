package tweentyscoops.mvp.kotlin.ui.main.fragment

import com.hwangjr.rxbus.Bus
import com.hwangjr.rxbus.RxBus
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.powermock.api.mockito.PowerMockito.`when`
import org.powermock.api.mockito.PowerMockito.mockStatic
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
@PrepareForTest(RxBus::class)
class MainPresenterTest {

    @Mock lateinit var mockView: MainContract.View
    @Mock lateinit var bus: Bus

    private val presenter: MainPresenter

    init {
        MockitoAnnotations.initMocks(this)
        mockStatic(RxBus::class.java)
        presenter = MainPresenter()
        presenter.attachView(mockView)
        `when`(RxBus.get()).thenReturn(bus)
    }

    @Test
    fun onViewStart() {
        presenter.onViewStart()
        Mockito.verify(RxBus.get()).register(presenter)
    }

    @Test
    fun onViewStop() {
        presenter.onViewStop()
        Mockito.verify(RxBus.get()).unregister(presenter)
    }

    @Test
    fun sendText() {
        val message  = "test"
        presenter.sendText(message)
        Mockito.verify(RxBus.get(), Mockito.times(1)).post("text", message)
    }
}