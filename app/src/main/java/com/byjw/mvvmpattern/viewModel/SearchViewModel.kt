package com.byjw.mvvmpattern.viewModel

import android.util.Log
import com.byjw.mvvmpattern.NotNullMutableLiveData
import com.byjw.mvvmpattern.model.api.SearchApi
import com.byjw.mvvmpattern.model.api.domain.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SearchViewModel(private val searchApi: SearchApi) : BaseViewModel() {

    private val _items: NotNullMutableLiveData<List<Repository>> =
        NotNullMutableLiveData(arrayListOf())
    val items: NotNullMutableLiveData<List<Repository>>
        get() = _items

    private var query: String = ""
        get() = if (field.isEmpty()) "" else field

    fun doSearch() {
        val params = mutableMapOf<String, String>().apply {
            this["q"] = query
            this["sort"] = "stars"
        }

        addToDisposable(searchApi.search(params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _items.value = it.repositories
                },
                {
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