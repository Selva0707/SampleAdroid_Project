package com.example.mvvm_coroutine_retro_recycler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_coroutine_retro_recycler.adapter.RecyclerViewAdapter
import com.example.mvvm_coroutine_retro_recycler.models.RecyclerList
import com.example.mvvm_coroutine_retro_recycler.viewmodel.MainActivityViewModel


class RecyclerListFragment : Fragment() {

    private lateinit var recyclerAdapter : RecyclerViewAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_recycler_list, container, false)


        initviewmodel(view)
        initViewModel()
        return view
    }

   private fun initviewmodel(view: View) {
     val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
       recyclerView?.layoutManager = LinearLayoutManager(activity)
       val decoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
       recyclerView?.addItemDecoration(decoration)
       recyclerAdapter = RecyclerViewAdapter()
       recyclerView?.adapter = recyclerAdapter



   }

    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getRecyclerListObserver().observe(viewLifecycleOwner,Observer<RecyclerList>{
            if(it != null){
                recyclerAdapter.setUpdateData(it.items)
            }else{
                Toast.makeText(activity,"Error", Toast.LENGTH_LONG).show()
            }


        })
        viewModel.makeApicall()
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            RecyclerListFragment()

    }
}