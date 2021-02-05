package com.example.healthyrecipes.ui.fragments.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.healthyrecipes.data.models.FoodResult
import com.example.healthyrecipes.databinding.FragmentIngredientsBinding
import com.example.healthyrecipes.ui.adapters.IngredientAdapter
import com.example.healthyrecipes.utils.Constants.Companion.RECIPE_BUNDLE_NAME


class IngredientsFragment : Fragment() {

    private var _binding: FragmentIngredientsBinding? = null
    private val binding get() = _binding!!

    private val adapter: IngredientAdapter by lazy { IngredientAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentIngredientsBinding.inflate(inflater, container, false)


        val args = arguments
        val foodResult: FoodResult? = args?.getParcelable(RECIPE_BUNDLE_NAME)

        setUpRecyclerView()
        foodResult?.extendedIngredients?.let {
            adapter.setData(it)
        }


        return binding.root
    }


    private fun setUpRecyclerView() {
        binding.ingredientsRecyclerView.adapter = adapter
        binding.ingredientsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}