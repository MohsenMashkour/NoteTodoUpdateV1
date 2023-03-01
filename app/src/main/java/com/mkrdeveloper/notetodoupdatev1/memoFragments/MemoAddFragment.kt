package com.mkrdeveloper.notetodoupdatev1.memoFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.mkrdeveloper.notetodoupdatev1.R
import com.mkrdeveloper.notetodoupdatev1.models.Memo
import com.mkrdeveloper.notetodoupdatev1.viewModel.MemoViewModel


class MemoAddFragment : Fragment() {

    private lateinit var mMemoViewModel: MemoViewModel
    private lateinit var edtMemoTitle: EditText
    private lateinit var edtMemoBody: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_memo_add, container, false)

        mMemoViewModel = ViewModelProvider(this)[MemoViewModel::class.java]
        edtMemoTitle = view.findViewById(R.id.edt_title_add_memo)
        edtMemoBody = view.findViewById(R.id.edt_body_add_memo)

        view.findViewById<Button>(R.id.btnSaveMemo).setOnClickListener {
            saveMemoToDatabase()
        }

        return view
    }

    private fun saveMemoToDatabase() {

        val titleMemo = edtMemoTitle.text.toString()
        val bodyMemo = edtMemoBody.text.toString()

        val memo = Memo(0,titleMemo,bodyMemo)
        mMemoViewModel.addMemo(memo)
        Toast.makeText(this.context,"Successfully added", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_memoAddFragment_to_memoHomeFragment)
    }


}