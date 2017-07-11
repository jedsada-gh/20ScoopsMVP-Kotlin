package tweentyscoops.mvp.kotlin.ui.exception

class MvpNotSetLayoutException : RuntimeException("getLayoutView() not return 0")

class MvpPresenterNotCreateException : RuntimeException(
        "Please call createPresenter() before requesting data to the Presenter"
)

class MvpViewNotAttachedException : RuntimeException(
        "Please call Presenter.attachView(MvpBaseView) before" + " requesting data to the View"
)