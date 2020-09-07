package com.example.booktask.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.booktask.databinding.FragmentProfileBinding
import com.example.booktask.model.types.db.Profile
import com.example.booktask.utils.StringResource
import com.example.booktask.utils.getViewModelFactory
import com.example.booktask.utils.toast
import com.example.booktask.viewmodel.ProfileViewModel

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
        viewModel.error.observe(viewLifecycleOwner, ::error)
        viewModel.profile.observe(viewLifecycleOwner, ::fillProfile)
        //viewModel.finishedBooksNumber.observe(viewLifecycleOwner, ::fillFinishedBooksNumber)
    }

    private fun fillProfile(profile: Profile) {
        binding.also {
            it.firstName.text = profile.firstName
            it.lastName.text = profile.lastName
            it.birthday.text = profile.birthDate
            it.hometown.text = profile.city
            it.gender.text = profile.gender
            it.email.text = profile.email
            it.phoneNumber.text = profile.phoneNumber
        }
    }

    private fun fillFinishedBooksNumber(count: Int) {
        binding.finishedBooksNumber.text = count.toString()
    }

    private fun error(res: StringResource) {
        toast(res, isLong = true)
    }

    companion object {
        fun newInstance() = ProfileFragment()
    }
}