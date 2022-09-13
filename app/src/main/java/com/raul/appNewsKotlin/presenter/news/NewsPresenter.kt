package com.raul.appNewsKotlin.presenter.news

import com.raul.appNewsKotlin.model.ResponseNews
import com.raul.appNewsKotlin.model.database.NewsDataSource
import com.raul.appNewsKotlin.presenter.ViewHome
import com.raul.appNewsKotlin.services.NewsHome


class NewsPresenter (val view: ViewHome.View,
                     private val dataSource: NewsDataSource
) : NewsHome.Presenter  {
    override fun requestAll() {
    this.view.showPorgressBar()
        this.dataSource.getBreakingNews(this)
    }

    override fun onSuccess(newsResponse: ResponseNews) {
    this.view.showArticles(newsResponse.articles)
    }

    override fun onError(message: String) {
    this.view.showFailure(message)
    }

    override fun onComplete() {
    this.view.hideProgressBar()
    }


}