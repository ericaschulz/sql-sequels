package com.els.sequels;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ericaschulz on 6/22/16.
 */
public abstract class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1; //change as we upgrade;
    public static final String DB_NAME = "ReallyBadSequels.db";
    public static final String CREATE_TABLE = "CREATE TABLE sequels(id INT PRIMARY KEY, name TEXT);";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS sequels;";


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

    }
    public void insertSequel(int id, String name) {
        
    }
}
