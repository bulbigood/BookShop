package com.example.booktask

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.booktask.model.repo.FinishedBooksRepository
import com.example.booktask.model.repo.ProfileRepository
import com.example.booktask.viewmodel.ProfileViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(
    private val profileRepository: ProfileRepository,
    private val finishedBooksRepository: FinishedBooksRepository,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    // TODO: переделать на dependency injection Koin
	override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ) = with(modelClass) {
		when {
			isAssignableFrom(ProfileViewModel::class.java) ->
				ProfileViewModel(profileRepository, finishedBooksRepository)
			else ->
				throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
		}
	} as T
}
