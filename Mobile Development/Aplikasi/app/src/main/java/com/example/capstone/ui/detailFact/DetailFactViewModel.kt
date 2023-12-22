package com.example.capstone.ui.detailFact

import androidx.lifecycle.*
import com.example.capstone.data.Repository.Repository
import com.example.capstone.data.response.DetailResponse
import kotlinx.coroutines.launch

class DetailFactViewModel (private val repository: Repository): ViewModel(){

    private val _itemDetail = MutableLiveData<DetailResponse>()
    val itemDetail: LiveData<DetailResponse> get() = _itemDetail

    fun getDetail(id: Int) {
        viewModelScope.launch {
            try {
                _itemDetail.value = repository.getDetailById(id)
            } catch (e: Exception) {
                throw e
            }
        }
    }




}

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailFactViewModel::class.java)) {
            return DetailFactViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}