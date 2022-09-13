package com.raul.appNewsKotlin.presenter.favorites

import com.raul.appNewsKotlin.model.Article


interface FavoriteHome {
    interface Presenter{

        fun onSuccess(articles: List<Article>)
    }

}