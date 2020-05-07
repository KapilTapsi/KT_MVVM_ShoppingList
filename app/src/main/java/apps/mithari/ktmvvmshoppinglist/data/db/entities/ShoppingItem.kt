package apps.mithari.ktmvvmshoppinglist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity         //you can set custom table name (tableName = "shopping_items")
data class ShoppingItem(

    @ColumnInfo(name = "item_name")       // columninfo is optional
    var name: String,

    @ColumnInfo(name = "item_amount")
    var amount: Int

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}