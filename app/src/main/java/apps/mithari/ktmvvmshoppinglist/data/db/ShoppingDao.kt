package apps.mithari.ktmvvmshoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import apps.mithari.ktmvvmshoppinglist.data.db.entities.ShoppingItem

@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shoppingitem")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}