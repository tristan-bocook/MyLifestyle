package com.example.mylifestyle.userInfo

import android.content.Context
import android.util.Log
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Singleton instance getter for the database
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = INSTANCE ?: createDatabase(context).also { INSTANCE = it }
                instance
            }
        }

        // Helper function to create a new instance of the database
        private fun createDatabase(context: Context): AppDatabase {
            val callback = DatabaseCallback()
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "app_database"
            )
                .addMigrations(MIGRATION_1_2)
                .addCallback(callback)
                .build()
        }

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                // Example migration adds a new column
                db.execSQL("ALTER TABLE users ADD COLUMN last_login INTEGER DEFAULT 0 NOT NULL")
            }
        }
    }

    private class DatabaseCallback : Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                ProcessLifecycleOwner.get().lifecycleScope.launch(Dispatchers.IO) {
                    Log.d("DatabaseInit", "Starting to populate the database")
                    populateDatabase(database.userDao())
                }
            }
        }

        private suspend fun populateDatabase(userDao: UserDao) {
            try {
                Log.d("DatabaseInit", "Creating default admin user")
                val prepopulateUser = User(username="admin", email="admin@example.com", password=SecurityUtils.hashPassword("adminPass"))
                val result = userDao.insertUser(prepopulateUser)
                if (result == -1L) {
                    Log.e("DatabaseInit", "Failed to insert default user")
                } else {
                    Log.d("DatabaseInit", "Default user inserted successfully")
                }
            } catch (e: Exception) {
                Log.e("DatabaseInit", "Error populating database: ${e.message}")
            }
        }
    }
}

