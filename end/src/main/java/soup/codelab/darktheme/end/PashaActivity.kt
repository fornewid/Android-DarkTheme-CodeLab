package soup.codelab.darktheme.end

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import soup.codelab.darktheme.end.databinding.PashaActivityBinding

class PashaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PashaActivityBinding.inflate(LayoutInflater.from(this)).apply {
            setContentView(root)
            setSupportActionBar(toolbar)
            toolbar.setNavigationOnClickListener {
                finish()
            }
            listView.adapter = ListAdapter()
        }
    }

    class ListAdapter : RecyclerView.Adapter<ItemViewHolder>() {

        private val list = PashaItemUiModel.createDummyList()

        init {
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            val layoutId = getLayoutIdOf(viewType)
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding: ViewDataBinding = DataBindingUtil
                .inflate(layoutInflater, layoutId, parent, false)
            return ItemViewHolder(binding)
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            holder.bind(list.getOrNull(position))
        }

        override fun getItemViewType(position: Int): Int {
            return when (list[position]) {
                is PashaItemUiModel.Tag -> TYPE_TAG
                is PashaItemUiModel.Error -> TYPE_ERROR
                is PashaItemUiModel.Pasha -> TYPE_PASHA
                is PashaItemUiModel.SOUP -> TYPE_SOUP
            }
        }

        private fun getLayoutIdOf(viewType: Int): Int {
            return when (viewType) {
                TYPE_TAG -> R.layout.pasha_item_tag
                TYPE_ERROR -> R.layout.pasha_item_error
                TYPE_PASHA -> R.layout.pasha_item_pasha
                TYPE_SOUP -> R.layout.pasha_item_soup
                else -> R.layout.pasha_item_space
            }
        }

        companion object {
            private const val TYPE_TAG = 0
            private const val TYPE_ERROR = 1
            private const val TYPE_PASHA = 2
            private const val TYPE_SOUP = 3
        }
    }

    class ItemViewHolder(
        private val binding: ViewDataBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PashaItemUiModel?) {
            binding.setVariable(BR.item, item)
            binding.executePendingBindings()
        }
    }
}
