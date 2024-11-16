package com.example.mytask2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mytask2.databinding.FragmentBBinding

class FragmentB : Fragment() {

    private val sharedViewModel by viewModels<SharedViewModel>({ requireActivity() })
    private lateinit var binding: FragmentBBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonIncrement.setOnClickListener {
            sharedViewModel.incrementCount()
        }
    }

    /* Метод, который обновляет текст заголовка на основе данных, полученных из FragmentA.  */
    fun updateHeader(data: String) {
        binding.textHeader.text = data
    }
}
