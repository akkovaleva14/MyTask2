package com.example.mytask2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.mytask2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FragmentACallback {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* Если savedInstanceState равно null, это означает, что активность создается впервые.
        В этом случае добавляются два фрагмента (FragmentA и FragmentB) в контейнеры,
        определенные в XML. */
        savedInstanceState ?: supportFragmentManager.commit {
            replace(binding.fragmentContainerA.id, FragmentA())
            replace(binding.fragmentContainerB.id, FragmentB())
        }
    }

    /*  Метод интерфейса FragmentACallback, который передает данные из FragmentA в FragmentB.
    Он ищет FragmentB по его идентификатору и вызывает метод updateHeader для обновления заголовка.  */
    override fun sendDataToFragmentB(data: String) {
        (supportFragmentManager.findFragmentById(binding.fragmentContainerB.id) as? FragmentB)
            ?.updateHeader(data)
    }

}