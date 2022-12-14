package com.raul.appNewsKotlin.ui

import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.raul.appNewsKotlin.adapter.MainAdapter
import com.raul.appNewsKotlin.model.Article
import com.raul.appNewsKotlin.model.database.NewsDataSource
import com.raul.appNewsKotlin.presenter.ViewHome
import com.raul.appNewsKotlin.presenter.news.NewsPresenter
import com.raul.appnewskotlin.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AbstractActivity(), ViewHome.View {

    private val mainAdapter by lazy{
        MainAdapter()
    }

    private lateinit var presenter: NewsPresenter

    override fun getLayout(): Int = R.layout.activity_main

    override fun onInject() {

        val dataSource = NewsDataSource(this)
        presenter = NewsPresenter(this, dataSource)
        presenter.requestAll()
        configRecycler()
        clickAdapter()
    }

    private fun configRecycler(){
        with(rvNews){
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }



    }

    private fun clickAdapter(){
        mainAdapter.setOnClickListener { article ->
            val intent = Intent(this, ArticleActivity::class.java)
            intent.putExtra("article", article)
            startActivity(intent)
        }
    }


    override fun showPorgressBar() {

        rvProgressBar.visibility = View.VISIBLE
    }

    override fun showFailure(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun hideProgressBar() {
    rvProgressBar.visibility = View.INVISIBLE
    }

    override fun showArticles(articles: List<Article>) {
    mainAdapter.differ.submitList(articles.toList())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.search_menu -> {
                Intent(this, SearchActivity::class.java).apply{
                    startActivity(this)
                }
            }
            R.id.favorites_menu -> {
                Intent(this, FavoriteActivity::class.java).apply{
                    startActivity(this)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}