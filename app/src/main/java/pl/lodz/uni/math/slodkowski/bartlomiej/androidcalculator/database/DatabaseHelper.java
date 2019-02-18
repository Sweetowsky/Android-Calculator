package pl.lodz.uni.math.slodkowski.bartlomiej.androidcalculator.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public final class DatabaseHelper extends Database{

    public DatabaseHelper(Context context) {
        super(context);
    }

    public boolean setData(String textEquation) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(databasePath, textEquation);
        if (database.insert(databaseTable, null, contentValues) == -1) {
            return false;
        } else {
            return true;
        }

    }

    public  ArrayList<String> getData() {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor result = database.rawQuery("SELECT * FROM " + databaseTable, null);
        ArrayList<String> listOfEquations = new ArrayList<>();
        while (result.moveToNext()) {
            listOfEquations.add(result.getString(1));
        }
        return listOfEquations;

    }

    public void clearData() {
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL(databaseEntriesDelete);
        onCreate(database);
    }

}
