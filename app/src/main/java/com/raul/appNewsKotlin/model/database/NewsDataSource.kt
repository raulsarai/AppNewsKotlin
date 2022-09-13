package com.raul.appNewsKotlin.model.database

import android.content.Context
import com.raul.appNewsKotlin.model.Article
import com.raul.appNewsKotlin.presenter.favorites.FavoriteHome
import com.raul.appNewsKotlin.presenter.search.SearchHome
import com.raul.appNewsKotlin.services.NewsHome
import com.raul.appNewsKotlin.services.RetrofitInstance

import kotlinx.coroutines.*

class NewsDataSource (context: Context){

    private var db: ArticleDataBase = ArticleDataBase(context)
    private var newsRepository: NewsRepository = NewsRepository(db)

    fun getBreakingNews(callback: NewsHome.Presenter){

        GlobalScope.launch (Dispatchers.Main  ){
          val response =  RetrofitInstance.api.getBreakingNews("br")
            if(response.isSuccessful){
                response.body()?.let {newsResponse ->
                    callback.onSuccess(newsResponse)
                }
                callback.onComplete()
            }else{
                callback.onError(response.message())
                callback.onComplete()
            }

        }
    }

    fun searchNews(term: String, callback: SearchHome.Presenter){
        GlobalScope.launch(Dispatchers.Main) {
            val response = RetrofitInstance.api.searchNews(term)
            if(response.isSuccessful){
                response.body()?.let { responseNews ->
                    callback.onSuccess(responseNews)
                }
                callback.onComplete()
            }else{
                callback.onError(response.message())
                callback.onComplete()
            }
        }
    }

    fun saveArticle(article: Article){
      GlobalScope.launch (Dispatchers.Main) {
          newsRepository.updateInsert(article)
      }
    }

    fun getAllArticle(callback: FavoriteHome.Presenter){
        var allArticles: List<Article>
        CoroutineScope(Dispatchers.IO).launch {
            allArticles = newsRepository.getAll()
            withContext(Dispatchers.Main){
                callback.onSuccess(allArticles)
            }
        }
    }

    fun deleteArticle(article: Article?){
        GlobalScope.launch(Dispatchers.Main){
            article?.let{
                articleSafe ->
                newsRepository.delete(articleSafe)
            }
        }

    }
}