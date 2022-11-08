package com.example3.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvp.R
import com.example.mvp.databinding.ActivityMvpBinding

class MVPActivity : AppCompatActivity(), MainContract.ViewInterface {

    private lateinit var presenter: MainPresenter
    private lateinit var repository: PostRepository
    private lateinit var binding : ActivityMvpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        repository = PostRepositoryImpl(RetrofitService.getInstance())
        presenter = MainPresenter(this, repository)

        binding.btnGetPosts.setOnClickListener {
            presenter.onGetPostsClicked((1..100).random())
        }
    }

    override fun displayPosts(posts: List<PostDataFromApi>) {
        binding.txtPost.text = posts.toString()
    }

    override fun displaySinglePost(post: PostDataFromApi) {
        binding.txtPost.text = post.toString()
    }
}