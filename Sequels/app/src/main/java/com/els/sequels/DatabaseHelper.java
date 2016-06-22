package com.els.sequels;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ericaschulz on 6/22/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

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
        insertSequel(1, "Empire Strikes Back");
        insertSequel(2, "Toy Story 2");
        insertSequel(3, "Raiders of the Lost Ark 2");
        insertSequel(4, "Halloween 2");
        insertSequel(5, "Mulan 2");
        insertSequel(6, "Taken 2");
        insertSequel(7, "Jaws 2");
        insertSequel(8, "Deathwish 2");
        insertSequel(9, "Zoolander 2");
        insertSequel(10, "Die Harder");


    }
    public void insertSequel(int id, String name) {
        //insert into table_name values (1,etc,etc)
        SQLiteDatabase db = getReadableDatabase();
        //special type of HashMap for Database values;
        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("name", name);
        //good place for breakpoint
        db.insert("sequels", null, values);
    }


}
