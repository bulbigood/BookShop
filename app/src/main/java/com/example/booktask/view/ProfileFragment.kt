package com.example.booktask.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.booktask.R
import com.example.booktask.databinding.FragmentProfileBinding
import com.example.booktask.model.types.db.Profile
import com.example.booktask.utils.formatRawDate
import com.example.booktask.utils.getViewModelFactory
import com.example.booktask.utils.toast
import com.example.booktask.viewmodel.ProfileViewModel
import timber.log.Timber

class ProfileFragment : Fragment() {

    private val viewModel by viewModels<ProfileViewModel> { getViewModelFactory() }

    private var _binding: FragmentProfileBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.refreshLayout.setOnRefreshListener(::onRefresh)
        viewModel.error.observe(viewLifecycleOwner, ::error)
        viewModel.profile.observe(viewLifecycleOwner, ::fillProfile)
        viewModel.finishedBooksNumber.observe(viewLifecycleOwner, ::fillFinishedBooksNumber)
    }

    private fun onRefresh() {
        viewModel.update().invokeOnCompletion { err ->
            error(err)
            binding.refreshLayout.isRefreshing = false
        }
    }

    private fun fillProfile(profile: Profile) {
        val birthday = formatRawDate(profile.birthDate, profile.dateFormat)
        val gender = profile.typedGender?.let {
            val res = when(it) {
                Profile.Gender.MAN -> R.string.gender_man
                Profile.Gender.WOMAN -> R.string.gender_woman
            }
            getString(res)
        } ?: ""

        binding.also {
            it.firstName.text = profile.firstName
            it.lastName.text = profile.lastName
            it.birthday.text = birthday
            it.hometown.text = profile.city
            it.gender.text = gender
            it.email.text = profile.email
            it.phoneNumber.text = profile.phoneNumber
        }
    }

    private fun fillFinishedBooksNumber(count: Int) {
        binding.finishedBooksNumber.text = count.toString()
    }

    private fun error(err: Throwable?) {
        if (err != null) {
            val toastMessage = err.localizedMessage ?: getString(R.string.error)
            toast(toastMessage, isLong = true)
            Timber.e(err)
        }
    }

    companion object {
        fun newInstance() = ProfileFragment()
    }
}