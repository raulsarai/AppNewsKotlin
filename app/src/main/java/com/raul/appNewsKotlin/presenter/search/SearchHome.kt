package com.raul.appNewsKotlin.presenter.search
import com.raul.appNewsKotlin.model.ResponseNews


interface SearchHome {

    interface Presenter{
        fun search(term: String)
        fun onSuccess(newsResponseNews: ResponseNews)
        fun onError(message: String)
        fun onComplete()
    }
}