package com.example.booktask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.example.booktask.data.repo.FinishedBooksRepository
import com.example.booktask.data.repo.ProfileRepository
import com.example.booktask.data.types.Profile
import com.example.booktask.utils.StringResource
import com.example.booktask.utils.toLiveData
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val profileRepository: ProfileRepository,
    private val finishedBooksRepository: FinishedBooksRepository
) : ViewModel() {

	init {
		update()
	}

	val _error: MutableLiveData<StringResource> = MutableLiveData()
	val error: LiveData<StringResource> = _error

	// TODO: проверить сколько раз вызывается. Не дергать если данные пришли те же самые
	val profile: LiveData<Profile> = profileRepository.data().switchMap { result ->
        result.toLiveData(this::showError)
	}
	val finishedBooksNumber: LiveData<Int> = finishedBooksRepository.data().switchMap { result ->
        result.toLiveData(this::showError).map { it.count() }
	}

	/**
	 * Обновляет данные профиля
	 */
	private fun update() {
		viewModelScope.launch {
			profileRepository.refresh()
            finishedBooksRepository.refresh()
		}
	}

	private fun showError() {
		_error.value = com.example.booktask.R.string.error
	}
}
