package com.raul.appNewsKotlin.model.database

import android.content.Context
import androidx.room.*
import com.raul.appNewsKotlin.model.Article
import com.raul.appNewsKotlin.model.dados.ArticlesDAO


@Database(entities = [Article::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ArticleDataBase  : RoomDatabase() {

    abstract fun getArticleDao(): ArticlesDAO

    companion object{

        @Volatile //garvacoes nesse campo serao visiveis para outros encadeamentos
        private var instance: ArticleDataBase? = null
        private val lock = Any() //tratamento de excessoes

        operator  fun invoke(context: Context) = instance ?: synchronized(lock){ //impede acesso por outras threads
         instance ?: createdDataBase(context).also{articleDataBase ->
             instance = articleDataBase
         }

        }

        private fun createdDataBase(context: Context) =
            Room.databaseBuilder(
                    context.applicationContext,
                    ArticleDataBase::class.java,
                    "article_db.db"
            ).build()

    }
}