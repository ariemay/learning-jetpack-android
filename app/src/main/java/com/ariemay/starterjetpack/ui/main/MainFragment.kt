package com.ariemay.starterjetpack.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.ariemay.starterjetpack.R
import com.ariemay.starterjetpack.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.fabChange?.setOnClickListener {
            viewModel.newData.value = "test"
        }

        _binding?.message?.setOnClickListener{
            view?.let { Navigation.findNavController(it).navigate(R.id.aboutFragment) }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        // Observe data on the ViewModel, exposed as a LiveData
        viewModel.data.observe(this, Observer { data ->
            view?.findViewById<TextView>(R.id.message)?.text = data
        })

    }

}