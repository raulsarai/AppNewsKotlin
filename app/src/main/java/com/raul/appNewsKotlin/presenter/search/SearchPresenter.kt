package com.raul.appNewsKotlin.presenter.search

import com.raul.appNewsKotlin.model.ResponseNews
import com.raul.appNewsKotlin.model.database.NewsDataSource
import com.raul.appNewsKotlin.presenter.ViewHome
import com.raul.appNewsKotlin.presenter.search.SearchHome


class SearchPresenter(val view: ViewHome.View,
                      private val dataSource: NewsDataSource
): SearchHome.Presenter {
    override fun search(term: String) {
        this.view.showPorgressBar()
        this.dataSource.searchNews(term, this)
    }

    override fun onSuccess(newsResponseNews: ResponseNews) {
        this.view.showArticles(newsResponseNews.articles)
    }

    override fun onError(message: String) {
        this.view.showFailure(message)

    }

    override fun onComplete() {
        this.view.hideProgressBar()
    }

}
