package pl.lodz.uni.math.slodkowski.bartlomiej.androidcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import pl.lodz.uni.math.slodkowski.bartlomiej.androidcalculator.database.DatabaseHelper;

public class HistoryActivity extends AppCompatActivity {


    private ListView historyListView;
    private ArrayAdapter<String> equationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        historyListView = findViewById(R.id.historyListView);
        readHistory();

    }

    private void readHistory() {

    }


}
