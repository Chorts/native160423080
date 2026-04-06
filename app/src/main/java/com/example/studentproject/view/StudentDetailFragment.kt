package com.example.studentproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.studentproject.R
import com.example.studentproject.databinding.FragmentStudentDetailBinding
import com.example.studentproject.databinding.FragmentStudentListBinding
import com.example.studentproject.model.Student
import com.example.studentproject.viewmodel.DetailViewModel
import com.example.studentproject.viewmodel.ListViewModel

class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: FragmentStudentDetailBinding

    private var studentList = ArrayList<Student>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStudentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch()

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            binding.txtID.setText(it.id)
            binding.txtName.setText(it.name)
            binding.txtBod.setText(it.bod)
            binding.txtPhone.setText(it.phone)
        })
    }
}