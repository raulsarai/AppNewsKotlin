package com.raul.appNewsKotlin.ui

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.raul.appNewsKotlin.adapter.MainAdapter
import com.raul.appNewsKotlin.model.Article
import com.raul.appNewsKotlin.model.database.NewsDataSource
import com.raul.appNewsKotlin.presenter.ViewHome
import com.raul.appNewsKotlin.presenter.search.SearchPresenter
import com.raul.appNewsKotlin.utils.UtilQueryTextListener
import com.raul.appnewskotlin.R
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AbstractActivity(), ViewHome.View {

    private val mainAdapter by lazy {
        MainAdapter()
    }

    private lateinit var presenter: SearchPresenter

    override fun getLayout(): Int = R.layout.activity_search

    override fun onInject() {

        val dataSource = NewsDataSource(this)
        presenter = SearchPresenter(this, dataSource)
        configRecycler()
        search()
        clickAdapter()

    }

    private fun search(){
        searchNews.setOnQueryTextListener(
                UtilQueryTextListener(
                        this.lifecycle
                ){
                    newText -> newText?.let{
                    query ->
                    if(query.isNotEmpty()){
                        presenter.search(query)
                        rvProgressBarSearch.visibility = View.VISIBLE
                    }
                }
                }
        )
    }

    private fun configRecycler(){
        with(rvSearch){
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@SearchActivity)
            addItemDecoration(DividerItemDecoration(
                    this@SearchActivity, DividerItemDecoration.VERTICAL
            ))
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
        rvProgressBarSearch.visibility = View.VISIBLE

    }

    override fun showFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun hideProgressBar() {
        rvProgressBarSearch.visibility = View.INVISIBLE
    }

    override fun showArticles(articles: List<Article>) {
        mainAdapter.differ.submitList(articles.toList())
    }
}