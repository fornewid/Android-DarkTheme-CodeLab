package soup.codelab.darktheme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import soup.codelab.darktheme.databinding.MoopActivityBinding

class MoopActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MoopActivityBinding.inflate(LayoutInflater.from(this)).apply {
            setContentView(root)
            setSupportActionBar(toolbar)
            toolbar.setNavigationOnClickListener {
                finish()
            }
            listView.adapter = ListAdapter()
        }
    }

    class ListAdapter : RecyclerView.Adapter<ItemViewHolder>() {

        private val list = MoopItemUiModel.createDummyList()

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
                is MoopItemUiModel.Tag -> TYPE_TAG
                is MoopItemUiModel.Error -> TYPE_ERROR
                is MoopItemUiModel.Moop -> TYPE_MOOP
                is MoopItemUiModel.SOUP -> TYPE_SOUP
            }
        }

        private fun getLayoutIdOf(viewType: Int): Int {
            return when (viewType) {
                TYPE_TAG -> R.layout.moop_item_tag
                TYPE_ERROR -> R.layout.moop_item_error
                TYPE_MOOP -> R.layout.moop_item_moop
                TYPE_SOUP -> R.layout.moop_item_soup
                else -> R.layout.moop_item_space
            }
        }

        companion object {
            private const val TYPE_TAG = 0
            private const val TYPE_ERROR = 1
            private const val TYPE_MOOP = 2
            private const val TYPE_SOUP = 3
        }
    }

    class ItemViewHolder(
        private val binding: ViewDataBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MoopItemUiModel?) {
            binding.setVariable(BR.item, item)
            binding.executePendingBindings()
        }
    }
}
