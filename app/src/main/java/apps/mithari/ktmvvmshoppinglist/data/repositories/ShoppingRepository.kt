package apps.mithari.ktmvvmshoppinglist.data.repositories

import apps.mithari.ktmvvmshoppinglist.data.db.ShoppingDatabase
import apps.mithari.ktmvvmshoppinglist.data.db.entities.ShoppingItem

class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}