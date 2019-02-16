package pl.lodz.uni.math.slodkowski.bartlomiej.androidcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import pl.lodz.uni.math.slodkowski.bartlomiej.androidcalculator.database.DatabaseHelper;

public class HistoryActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        readHistory();
    }

    private void readHistory() {
        DatabaseHelper database = new DatabaseHelper(this);
        String History = database.getData().toString();
        TextView textView = findViewById(R.id.historyTextView);
        textView.setText(History);
    }

    public void clearHistory(View view) {
        DatabaseHelper database = new DatabaseHelper(this);
        database.clearData();
        TextView textView = findViewById(R.id.historyTextView);
        String History = database.getData().toString();
        textView.setText(History);
    }


}
