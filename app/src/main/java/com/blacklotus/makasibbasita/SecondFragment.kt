package com.blacklotus.makasibbasita

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.blacklotus.makasibbasita.databinding.FragmentSecondBinding
import com.blacklotus.makasibbasita.databinding.ListAdpterBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private val itemList = mutableListOf<Item>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        // Add some sample items
        itemList.add(Item("Double Burger", 8.99, R.drawable.background5, false))
        itemList.add(Item("Onglet Steak", 14.99, R.drawable.background1, false))
        itemList.add(Item("Milk Breakfast", 6.50, R.drawable.background2, false))
        itemList.add(Item("Cheese Pizza", 12.50, R.drawable.baseline_person_24, true))

        val adapter = ItemAdapter(binding.root.context, itemList)
        binding.itemGridView.adapter = adapter


        return binding.root


    }

    private inner class ItemAdapter(context: Context, private val itemList: List<Item>) :
        ArrayAdapter<Item>(context, R.layout.list_adpter, itemList) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_adpter, parent, false)

            val itemImageView = view.findViewById<ImageView>(R.id.itemImageView)
            val itemNameTextView = view.findViewById<TextView>(R.id.itemNameTextView)
            val itemPriceTextView = view.findViewById<TextView>(R.id.itemPriceTextView)
            val itemSoldOutTextView = view.findViewById<TextView>(R.id.itemSoldOutTextView)

            val item = itemList[position]
            itemImageView.setImageResource(item.imageResId)
            itemNameTextView.text = item.name
            itemPriceTextView.text = "$${item.price}"
            itemSoldOutTextView.text = if (item.isSoldOut) "Sold Out" else ""

            view.setOnClickListener {
                Toast.makeText(context, "Item clicked: ${item.name}", Toast.LENGTH_SHORT).show()

            }
            return view
        }
    }

    data class Item(val name: String, val price: Double, val imageResId: Int, val isSoldOut: Boolean)
}