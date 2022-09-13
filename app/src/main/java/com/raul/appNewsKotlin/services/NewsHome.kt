package com.raul.appNewsKotlin.services

import com.raul.appNewsKotlin.model.ResponseNews


interface NewsHome {

    interface Presenter{
        fun requestAll()
        fun onSuccess(newsResponse: ResponseNews)
        fun onError(message: String)
        fun onComplete()
    }
}