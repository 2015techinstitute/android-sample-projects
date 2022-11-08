package com.example3.mvp.presenter

import com.example3.mvp.data.PostDataFromApi
import com.example3.mvp.data.PostRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainPresenter(private var viewInterface: MainContract.ViewInterface, private var repository: PostRepository) :
    MainContract.PresenterInterface {

    override fun onGetPostsClicked(id: Int) {
        runBlocking {
            launch {
                val result = repository.getPostById(id)
                delay(1000L)
                val posts = result.body() as PostDataFromApi
                delay(1000L)
                viewInterface.displaySinglePost(posts)
            }
        }
    }
}