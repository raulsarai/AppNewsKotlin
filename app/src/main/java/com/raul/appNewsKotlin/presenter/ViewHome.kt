package com.raul.appNewsKotlin.presenter

import com.raul.appNewsKotlin.model.Article


interface ViewHome {

    interface View{
        fun showPorgressBar()
        fun showFailure(message: String)
        fun hideProgressBar()
        fun showArticles(articles: List<Article>)
    }

    interface  Favorite {
        fun showArticles(articles: List<Article>)
    }
}