package com.example.express

import android.app.DownloadManager.Query
import android.provider.CalendarContract
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.kwabenaberko.newsapilib.NewsApiClient
import com.kwabenaberko.newsapilib.models.Article
import com.kwabenaberko.newsapilib.models.request.EverythingRequest
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest
import com.kwabenaberko.newsapilib.models.response.ArticleResponse
import kotlinx.coroutines.launch
import kotlinx.coroutines.time.delay

class NewsViewModel: ViewModel() {

    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> = _articles

    init {
        fetchNewsTopHeadlines()
    }

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState> = _authState
    init {
        checkUserAuthentication()
    }

    private fun checkUserAuthentication() {
        if (auth.currentUser != null) {
            _authState.value = AuthState.Authenticated
        } else {
            _authState.value = AuthState.Unauthenticated
        }
    }

    fun fetchNewsTopHeadlines(category: String = "GENERAL"){
        val newsApiClient = NewsApiClient(Constant.APIKEY)
        val request = TopHeadlinesRequest.Builder().language("en").category(category).build()
        newsApiClient.getTopHeadlines(request, object : NewsApiClient.ArticlesResponseCallback {
            override fun onSuccess(response: ArticleResponse?) {
                response?.articles?.let {
                    _articles.postValue(it)
                }
            }
            override fun onFailure(throwable: Throwable?) {
                if (throwable != null) {
                     Log.i("NewsAPI Response Failed", throwable.localizedMessage)
                }
                }
            })
        }


fun fetchEverythingWithQuery(query : String){
    val newsApiClient = NewsApiClient(Constant.APIKEY)

    val request = EverythingRequest.Builder().language("en").q(query).build()

    newsApiClient.getEverything(request, object : NewsApiClient.ArticlesResponseCallback {
        override fun onSuccess(response: ArticleResponse?) {
            response?.articles?.let {
                _articles.postValue(it)
            }
        }
        override fun onFailure(throwable: Throwable?) {
            if (throwable != null) {
                Log.i("NewsAPI Response Failed", throwable.localizedMessage)
            }
        }
    })
}

    fun login(email: String, password: String) {

        if (email.isBlank() || password.isBlank()) {
            _authState.value = AuthState.Error("Email and password cannot be empty")
            return
        }
        _authState.value = AuthState.Loading
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _authState.value = AuthState.Authenticated
                } else {
                    _authState.value = AuthState.Error(task.exception?.message?:"Something Went Wrong")
                }
            }
    }

    fun signUp(email: String, password: String) {

        if (email.isBlank() || password.isBlank()) {
            _authState.value = AuthState.Error("Email and password cannot be empty")
            return
        }
        _authState.value = AuthState.Loading
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _authState.value = AuthState.Authenticated
                } else {
                    _authState.value = AuthState.Error(task.exception?.message?:"Something Went Wrong")
                }
            }
    }

    fun signOut() {
        auth.signOut()
        _authState.value = AuthState.Unauthenticated
    }

}
sealed class AuthState {
    data object Authenticated : AuthState()
    data object Unauthenticated : AuthState()
    data object Loading : AuthState()
    data class Error(val message: String) : AuthState()
}