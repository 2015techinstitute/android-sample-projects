package com.example2.mvc.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example2.mvc.data.PostDataFromApi
import com.example2.mvc.data.PostDataFromApiObserve
import com.example2.mvc.data.PostRepository
import com.example2.mvc.data.PostRepositoryImpl
import com.example2.mvc.databinding.ActivityActiveMvcactivityBinding
import com.example2.mvc.network.RetrofitService
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*

class ActiveMVCActivity : AppCompatActivity(), Observer {

    private lateinit var binding : ActivityActiveMvcactivityBinding
    private lateinit var repository: PostRepository
    private var posts =  PostDataFromApiObserve(0, 0, "", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActiveMvcactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        repository = PostRepositoryImpl(RetrofitService.getInstance())

        posts.addObserver(this@ActiveMVCActivity)

        binding.btnGetPosts.setOnClickListener {
            runBlocking {
                launch {
                    val result = repository.getPostById((1..100).random())
                    delay(1000L)
                    val tempPosts = result.body() as PostDataFromApi
                    posts = PostDataFromApiObserve(tempPosts.userId, tempPosts.id, tempPosts.title, tempPosts.body)
                    posts.notifyObservers()
                    delay(1000L)
                    Toast.makeText(this@ActiveMVCActivity, posts.toString(), Toast.LENGTH_SHORT).show()
                    delay(1000L)
                    binding.txtPost.text = posts.toString()
                }
            }
        }
    }

    override fun update(p0: Observable?, p1: Any?) {
        Log.v("ActiveMVCActivity", p0.toString())
    }
}