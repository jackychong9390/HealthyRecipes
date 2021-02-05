package com.example.healthyrecipes.ui.fragments.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.healthyrecipes.data.models.FoodResult
import com.example.healthyrecipes.databinding.FragmentInstructionsBinding
import com.example.healthyrecipes.utils.Constants.Companion.RECIPE_BUNDLE_NAME


class InstructionsFragment : Fragment() {

    private var _binding: FragmentInstructionsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInstructionsBinding.inflate(inflater, container, false)


        val args = arguments
        val foodResult: FoodResult? = args?.getParcelable(RECIPE_BUNDLE_NAME)

        binding.instructionsWebView.webViewClient = object : WebViewClient() {

        }
        binding.instructionsWebView.webChromeClient = object : WebChromeClient() {

        }

        val websiteUrl: String = foodResult!!.sourceUrl
        binding.instructionsWebView.loadUrl(websiteUrl)


        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}