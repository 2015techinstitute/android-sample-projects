package com.example3.mvp

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainPresenter(private var viewInterface: MainContract.ViewInterface, private var repository: PostRepository) : MainContract.PresenterInterface {

    override fun onGetPostsClicked(id: Int) {
        runBlocking {
            launch {
                val result = repository.getPostById(id)
                val posts = result.body() as PostDataFromApi
                viewInterface.displaySinglePost(posts)
            }
        }
    }
}