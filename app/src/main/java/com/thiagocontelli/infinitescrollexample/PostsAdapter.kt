package com.thiagocontelli.infinitescrollexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thiagocontelli.infinitescrollexample.databinding.PostBinding

class PostsAdapter : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {

    private var posts: List<Post> = emptyList()

    fun setPosts(posts: List<Post>) {
        this.posts += posts
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        return PostsViewHolder(
            PostBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val post = posts[position]
        holder.binding.titleTextView.text = post.title
        holder.binding.bodyTextView.text = post.body
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    class PostsViewHolder(var binding: PostBinding) : RecyclerView.ViewHolder(binding.root)
}