package com.thiagocontelli.infinitescrollexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thiagocontelli.infinitescrollexample.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var postsAdapter: PostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postsAdapter = PostsAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        preparePostsRecyclerView()

        loadPosts(0)

        onReachLastElement()
    }

    private fun loadPosts(skip: Int) {
        binding.progressCircular.visibility = View.VISIBLE
        lifecycleScope.launch {
            viewModel.getAllPosts(skip).collect {
                postsAdapter.setPosts(it)
                binding.progressCircular.visibility = View.GONE
            }
        }
    }

    private fun preparePostsRecyclerView() {
        binding.postsRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            adapter = postsAdapter
        }
    }

    private fun onReachLastElement() {
        binding.postsRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            var skip = 0

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?
                if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == linearLayoutManager.itemCount - 1) {
                    if (skip + 30 < viewModel.totalPosts.value!!) {
                        skip += 30
                        loadPosts(skip)
                    } else {
                        Toast.makeText(context, "The list is over", Toast.LENGTH_SHORT).show()
                    }
                }

                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }
}