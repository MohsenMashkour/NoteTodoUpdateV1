package com.mkrdeveloper.notetodoupdatev1.memoFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mkrdeveloper.notetodoupdatev1.R
import com.mkrdeveloper.notetodoupdatev1.adapters.memoRecAdapter
import com.mkrdeveloper.notetodoupdatev1.viewModel.MemoViewModel
import com.mkrdeveloper.notetodoupdatev1.databinding.FragmentMemoHomeBinding


class MemoHomeFragment : Fragment(R.layout.fragment_memo_home) {

    private lateinit var mMemoViewModel: MemoViewModel


    private var _binding : FragmentMemoHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMemoHomeBinding.inflate(inflater,container,false)


        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        mMemoViewModel = ViewModelProvider(this)[MemoViewModel::class.java]
        mMemoViewModel.readAllData.observe(viewLifecycleOwner) { memo ->
          val  adaptr = memoRecAdapter(memo)

            binding.rvMemo.apply {

                adapter = adaptr
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
            }
        }



        binding.btnAddMemo.setOnClickListener {
            findNavController().navigate(R.id.action_memoHomeFragment_to_memoAddFragment)
        }
    }


}