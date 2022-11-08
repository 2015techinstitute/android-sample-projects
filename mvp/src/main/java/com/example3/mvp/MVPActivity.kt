package com.example3.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mvp.databinding.ActivityMvpBinding
import com.example3.mvp.data.PostDataFromApi
import com.example3.mvp.data.PostRepository
import com.example3.mvp.data.PostRepositoryImpl
import com.example3.mvp.network.RetrofitService
import com.example3.mvp.presenter.MainContract
import com.example3.mvp.presenter.MainPresenter

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
        Toast.makeText(this@MVPActivity, posts.toString(), Toast.LENGTH_SHORT).show()
        binding.txtPost.text = posts.toString()
    }

    override fun displaySinglePost(post: PostDataFromApi) {
        Toast.makeText(this@MVPActivity, post.toString(), Toast.LENGTH_SHORT).show()
        binding.txtPost.text = post.toString()
    }
}