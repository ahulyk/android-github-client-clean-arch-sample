package net.hulyk.githubclient.feature

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.launch
import net.hulyk.githubclient.domain.GetAllReposUseCase
import net.hulyk.githubclient.domain.GetEvenIdReposUseCase
import net.hulyk.githubclient.domain.base.Result
import net.hulyk.githubclient.viewmodel.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(private val getAllReposUseCase: GetAllReposUseCase,
                                        private val getEvenIdReposUseCase: GetEvenIdReposUseCase
) : BaseViewModel() {

    private val _loading = MutableLiveData<Boolean>()
            .apply { value = false }
    private val _repoInfo = MutableLiveData<String>()
            .apply { value = "Press button to load data" }

    val loading: LiveData<Boolean> = _loading
    val repoInfo: LiveData<String> = _repoInfo

    fun loadAllRepoData() {
        _loading.value = true
        _repoInfo.value = ""
        launch {
            when (val result = getAllReposUseCase("kotlin")) {
                is Result.Success -> _repoInfo.value = result.data.toString()
                is Result.Error -> _repoInfo.value = result.exception.message
            }
            _loading.value = false
        }
    }

    fun loadEvenRepoData() {
        _loading.value = true
        _repoInfo.value = ""
        launch {
            when (val result = getEvenIdReposUseCase("kotlin")) {
                is Result.Success -> _repoInfo.value = result.data.toString()
                is Result.Error -> _repoInfo.value = result.exception.message
            }
            _loading.value = false
        }
    }


}