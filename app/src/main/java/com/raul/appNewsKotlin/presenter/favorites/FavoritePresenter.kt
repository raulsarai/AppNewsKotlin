package com.raul.appNewsKotlin.presenter.favorites

import com.raul.appNewsKotlin.model.Article
import com.raul.appNewsKotlin.model.database.NewsDataSource
import com.raul.appNewsKotlin.presenter.ViewHome


class FavoritePresenter (
    val view: ViewHome.Favorite,
    private val dataSource: NewsDataSource
): FavoriteHome.Presenter{

    fun getAll(){
     this.dataSource.getAllArticle(this)
    }

    fun saveArticle(article: Article){
        this.dataSource.saveArticle(article)
    }

    fun deleteArticle(article: Article){
        this.dataSource.deleteArticle(article)
    }

    override fun onSuccess(articles: List<Article>) {
        this.view.showArticles(articles)
    }
}