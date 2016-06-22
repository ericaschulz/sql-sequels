package com.els.tvstore;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ericaschulz on 6/22/16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1; //change as we upgrade;
    public static final String DB_NAME = "store.db";
    public static final String CREATE_TABLE = "CREATE TABLE televisions(id INT PRIMARY KEY, brand TEXT, size TEXT, price INT);";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS store;";


    public DatabaseHelper(Context context) {
        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE); //drop table
        onCreate(db); //create table

    }

    //Not an override
    public void seedDatabase() {
        insertStore(1, "Samsung","40in", 400);
        insertStore(2, "RCA", "60in", 1000);
        insertStore(3, "Sony", "37in", 600);





    }
    public void insertStore(int id, String brand, String size, int price) {
        //insert into table_name values (1,etc,etc)
        SQLiteDatabase db = getReadableDatabase();
        //special type of HashMap for Database values;
        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("brand", brand);
        values.put("size", size);
        values.put("price", price);
        //good place for breakpoint
        db.insert("store", null, values);
    }


}
