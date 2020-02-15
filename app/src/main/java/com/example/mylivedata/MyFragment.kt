package com.example.mylivedata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.my_fragment.*
import kotlinx.android.synthetic.main.my_fragment.view.*


class MyFragment : Fragment() {

    companion object {
        const val TAG = "MyFragment"

        fun newInstance(): MyFragment {
            return MyFragment()
        }
    }

    private val model: NameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.my_fragment, container, false)

        view.buttonInFragment.setOnClickListener {
            model.currentName.value = view.nameInFragment.text.toString() + "!"
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val observer: Observer<String> = Observer { name ->
            nameInFragment.text = name
        }

        model.currentName.observe(viewLifecycleOwner, observer)
    }

}
