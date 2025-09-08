package br.com.renan.foodlist.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.renan.foodlist.R
import br.com.renan.foodlist.common.FruitsDatabase
import br.com.renan.foodlist.domain.fruit.FruitsAdapter

class FruitsFragment: Fragment(R.layout.fruits_fragment) {

    private lateinit var fruitsRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fruits_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fruitsRecyclerView = view.findViewById(R.id.fruits_recycler_view)
        fruitsRecyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun onStart() {
        super.onStart()

        val fruitsList = FruitsDatabase.findAll()
        val fruitsAdapter = FruitsAdapter(fruitsList)
        fruitsRecyclerView.adapter = fruitsAdapter
    }
}