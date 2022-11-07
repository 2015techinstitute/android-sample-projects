package com.example2.mvc.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example2.mvc.data.PostDataFromApi
import com.example2.mvc.data.PostRepository
import com.example2.mvc.data.PostRepositoryImpl
import com.example2.mvc.databinding.ActivityMvcBinding
import com.example2.mvc.network.RetrofitService
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MVCActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMvcBinding

    private lateinit var repository: PostRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        repository = PostRepositoryImpl(RetrofitService.getInstance())

        binding.btnGetPosts.setOnClickListener {
            runBlocking {
                launch {
                    val result = repository.getPostById(2)
                    val posts = result.body() as PostDataFromApi
                    binding.txtPost.text = posts.toString()
                }
            }
        }
    }

}

