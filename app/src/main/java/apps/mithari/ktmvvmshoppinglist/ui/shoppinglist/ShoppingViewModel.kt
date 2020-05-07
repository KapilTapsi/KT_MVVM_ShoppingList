package apps.mithari.ktmvvmshoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import apps.mithari.ktmvvmshoppinglist.data.db.entities.ShoppingItem
import apps.mithari.ktmvvmshoppinglist.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository: ShoppingRepository) : ViewModel() {

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShoppingItems() = repository.getAllShoppingItems()
//    though this function is database operation but it is a read function so we are using it on MAIN thread

}