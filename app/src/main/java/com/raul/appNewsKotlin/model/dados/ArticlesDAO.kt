package com.raul.appNewsKotlin.model.dados

import androidx.room.*
import com.raul.appNewsKotlin.model.Article

@Dao
interface ArticlesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateInsert(article: Article) : Long

        @Query("SELECT * FROM articles")
        fun getAll(): List<Article>

    @Delete
    suspend fun delete(article: Article)
}