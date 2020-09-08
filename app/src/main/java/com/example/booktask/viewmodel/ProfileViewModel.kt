package com.example.booktask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.distinctUntilChanged
import androidx.lifecycle.map
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.example.booktask.model.repo.FinishedBooksRepository
import com.example.booktask.model.repo.ProfileRepository
import com.example.booktask.model.types.db.Profile
import com.example.booktask.utils.toLiveData
import kotlinx.coroutines.Job
import kotlinx.coroutines.async

class ProfileViewModel(
	private val profileRepository: ProfileRepository,
	private val finishedBooksRepository: FinishedBooksRepository
) : ViewModel() {

	init {
		update()
	}

	private val _error: MutableLiveData<Throwable> = MutableLiveData()
	val error: LiveData<Throwable> = _error

	val profile: LiveData<Profile> = profileRepository.data()
		.distinctUntilChanged()
		.switchMap { result ->
			result.toLiveData(this::showError)
		}

	val finishedBooksNumber: LiveData<Int> = finishedBooksRepository.data()
		.distinctUntilChanged()
		.switchMap { result ->
			result.toLiveData(this::showError).map {
				it.count()
			}
		}

	/**
	 * Обновляет данные профиля
	 */
	fun update(): Job {
		return viewModelScope.async {
			profileRepository.refresh()
			finishedBooksRepository.refresh()
		}
	}

	private fun showError(t: Throwable) {
		_error.value = t
	}
}
