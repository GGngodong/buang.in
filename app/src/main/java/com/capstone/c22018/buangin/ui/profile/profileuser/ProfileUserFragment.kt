package com.capstone.c22018.buangin.ui.profile.profileuser

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.capstone.c22018.buangin.databinding.FragmentProfileUserBinding
import com.capstone.c22018.buangin.ui.profile.language.ProfileLanguageFragment
import com.capstone.c22018.buangin.ui.profile.privacy.ProfilePrivacyFragment

class ProfileUserFragment : Fragment() {

    private var _binding : FragmentProfileUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProfileUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rlAbout.setOnClickListener {
            Intent(context, ProfileHelpFragment::class.java)
        }

        binding.rlPrivacy.setOnClickListener {
            Intent(context, ProfilePrivacyFragment::class.java)
        }

        binding.rlLanguage.setOnClickListener {
            startActivity(Intent(context, ProfileLanguageFragment::class.java))
        }

        binding.rlAccount.setOnClickListener {
            startActivity(Intent(context, ProfileAccountFragment::class.java))
        }

    }

}