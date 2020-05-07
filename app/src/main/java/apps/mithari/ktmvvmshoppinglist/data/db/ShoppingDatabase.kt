package apps.mithari.ktmvvmshoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import apps.mithari.ktmvvmshoppinglist.data.db.entities.ShoppingItem

@Database(entities = [ShoppingItem::class], version = 1)
abstract class ShoppingDatabase : RoomDatabase() {
    abstract fun getShoppingDao(): ShoppingDao

    companion object {
        @Volatile
        private var instance: ShoppingDatabase? = null
//        Volatile means the instance is visible to all the threads and activities
//        that is to help to ensure it is singleton

        private val LOCK = Any()
//        A lock is a tool for controlling access to a shared resource by multiple threads.
//        Commonly, a lock provides exclusive access to a shared resource:
//        only one thread at a time can acquire the lock and
//        all access to the shared resource requires that the lock be acquired first

        //        this invoke function means is will be called by default when the class object is made
//        as we are companion object it can be called with parent ShoppingDatabase()
        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
                instance
                    ?: createDatabase(
                        context
                    )
                        .also { instance = it }
        }


        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ShoppingDatabase::class.java,
                "ShoppingDB.db"
            ).build()

    }
}