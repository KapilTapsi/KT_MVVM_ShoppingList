package apps.mithari.ktmvvmshoppinglist.ui.shoppinglist

import apps.mithari.ktmvvmshoppinglist.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}