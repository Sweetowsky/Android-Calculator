package pl.lodz.uni.math.slodkowski.bartlomiej.androidcalculator.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    private static final String databaseName ="History";
    protected static final String databaseTable = "SavedOperations";
    private static final String databaseIdColumn = "ID";
    protected static final String databasePath = "Operations";

    private static final String databaseEntries = "CREATE TABLE " + databaseTable + "(" + databaseIdColumn + " INTEGER PRIMARY KEY AUTOINCREMENT," + databasePath + " TEXT)";
    protected static final String databaseEntriesDelete = "DROP TABLE IF EXISTS " + databaseTable;

    public Database(Context context) {
        super(context, databaseName, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(databaseEntries);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(databaseEntriesDelete);
        onCreate(db);

    }
}
