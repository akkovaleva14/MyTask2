package com.example.mytask2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.mytask2.databinding.FragmentABinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class FragmentA : Fragment() {

    private val sharedViewModel by viewModels<SharedViewModel>({ requireActivity() })
    private lateinit var binding: FragmentABinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    /* Устанавливается слушатель на кнопку отправки, который вызывает метод
    sendDataToFragmentB у активности, передавая текст из EditText.
    Используется lifecycleScope для сбора данных из clickCount в SharedViewModel.
    Когда данные обновляются, текстовое поле обновляется с количеством кликов.  */
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSend.setOnClickListener {
            (activity as? FragmentACallback)?.sendDataToFragmentB(binding.editText.text.toString())
        }

        sharedViewModel.clickCount.onEach { count ->
            binding.textClickCount.text = "Кликнули $count раз"
        }.launchIn(lifecycleScope)

    }

}