package com.example3.mvp.presenter

import com.example3.mvp.data.PostDataFromApi

class MainContract {
    interface PresenterInterface {
       fun onGetPostsClicked(id: Int)
    }

    interface ViewInterface {
        fun displayPosts(posts: List<PostDataFromApi>)
        fun displaySinglePost(post : PostDataFromApi)
    }
}