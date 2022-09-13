package com.raul.appNewsKotlin.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.raul.appNewsKotlin.model.Article
import com.raul.appnewskotlin.R
import kotlinx.android.synthetic.main.item_news.view.*
import java.util.*


class MainAdapter : RecyclerView.Adapter<MainAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object: DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
           return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder =
     ArticleViewHolder(
         LayoutInflater.from(parent.context)
             .inflate(R.layout.item_news, parent, false)

     )

    override fun getItemCount(): Int = differ.currentList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this)
                .load(article.urlToImage)
                .into(ivArticleImage)
            tvTitle.text = article.source?.name ?: article.title
            tvSource.text = article.source?.name ?: article.author
            tvDescription.text = article.description

            val text1: String = article.publishedAt.toString()
            val splitWeb = text1.split("T".toRegex()).toTypedArray()
            val listTag: MutableList<String> = ArrayList()
            listTag.addAll(Arrays.asList(*splitWeb))

            val string2 = listTag[0]
            val splitWeb2 = string2.split("-".toRegex()).toTypedArray()
            val listTag2: MutableList<String> = ArrayList()
            listTag2.addAll(Arrays.asList(*splitWeb2))

            val string3 = listTag[1]
            val splitWeb3 = string3.split(":".toRegex()).toTypedArray()
            val listTag3: MutableList<String> = ArrayList()
            listTag3.addAll(Arrays.asList(*splitWeb3))

            tvPublishedAt.text = "Publicado ${listTag2[2]}/${listTag2[1]}/${listTag2[0]} às ${listTag3[0]}:${listTag3[1]}"

            setOnClickListener {
                onItemClickListener?.let {
                    click ->
                    click(article)
                }
            }
        }

    }

    fun getsplit(){

    }




    private var onItemClickListener: ((Article) -> Unit)? = null
            fun setOnClickListener(listener: (Article) -> Unit){
            onItemClickListener = listener
            }


}
