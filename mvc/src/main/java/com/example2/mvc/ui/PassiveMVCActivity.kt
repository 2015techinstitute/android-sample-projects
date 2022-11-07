package com.example2.mvc.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example2.mvc.data.PostDataFromApi
import com.example2.mvc.data.PostRepository
import com.example2.mvc.data.PostRepositoryImpl
import com.example2.mvc.databinding.ActivityMvcBinding
import com.example2.mvc.network.RetrofitService
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class PassiveMVCActivity : AppCompatActivity() {

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
                    delay(1000L)
                    val posts = result.body() as PostDataFromApi
                    delay(1000L)
                    Toast.makeText(this@PassiveMVCActivity, posts.toString(), Toast.LENGTH_SHORT).show()
                    delay(1000L)
                    binding.txtPost.text = posts.toString()
                }
            }
        }
    }

}

