package br.com.renan.foodlist.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.renan.foodlist.R
import br.com.renan.foodlist.common.FoodsDatabase
import br.com.renan.foodlist.domain.food.FoodsAdapter

class FoodsFragment: Fragment(R.layout.foods_fragment) {

    private lateinit var foodsRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.foods_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        foodsRecyclerView = view.findViewById(R.id.foods_recycler_view)
        foodsRecyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun onStart() {
        super.onStart()

        val foodList = FoodsDatabase.findAll()
        val adapter = FoodsAdapter(foodList)
        foodsRecyclerView.adapter = adapter
    }
}