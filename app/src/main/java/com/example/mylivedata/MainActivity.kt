package com.example.mylivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val model: NameViewModel by viewModels()
    private lateinit var fragment: MyFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameObserver: Observer<String> = Observer {name ->
            nameTextView.text = name
        }

        model.currentName.observe(this, nameObserver)

        button.setOnClickListener {
            model.currentName.value = nameTextView.text.toString() + "!"
        }

        fragment = MyFragment.newInstance()

        openFragment.setOnClickListener {
            if (!fragment.isAdded) {
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment, MyFragment.TAG).commit()
            }
        }
    }
}
