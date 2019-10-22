package com.byjw.mvvmpattern.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.byjw.mvvmpattern.model.api.SearchApi
import com.byjw.mvvmpattern.model.retrofit.domain.Item
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SearchViewModel(private val searchApi: SearchApi) : BaseViewModel() {

    private val _items: MutableLiveData<List<Item>> = MutableLiveData(arrayListOf())
    val items: LiveData<List<Item>>
        get() = _items

    private var query: String = ""
        get() = if (field.isEmpty()) "" else field

    private var isUserSearch: Boolean = true

    fun search() {
        if (isUserSearch) {
            searchUser()
        } else {
            searchRepository()
        }
    }

    fun searchRepository() {
        isUserSearch = false

        val params = mutableMapOf<String, String>().apply {
            this["q"] = query
            this["sort"] = "stars"
        }

        addToDisposable(searchApi.searchRepository(params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _items.value = it.repositories
                }, {
                    // Error Handle
                    Log.e("JW_TEST", "error : $it")
                }
            )
        )
    }

    fun searchUser() {
        isUserSearch = true

        val params = mutableMapOf<String, String>().apply {
            this["q"] = query
            this["sort"] = "followers"
        }

        addToDisposable(searchApi.searchUser(params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _items.value = it.users
                }, {
                    // Error Handle
                    Log.e("JW_TEST", "error : $it")
                }
            )
        )
    }

    fun onQueryChange(query: CharSequence) {
        this.query = query.toString()
    }

}