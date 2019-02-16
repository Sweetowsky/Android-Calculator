package pl.lodz.uni.math.slodkowski.bartlomiej.androidcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private StringBuilder textEquation = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goHistory(View view ){
        Intent intent = new Intent(MainActivity.this,HistoryActivity.class);
        startActivity(intent);
    }

    public void clearAllSign(View view ){

    }
    public void clearLastSign(View view ){

    }

    public void addToEquation(View view){
        int lengthOfEguqtion = textEquation.length() - 1;
        TextView button = (TextView) view;
        String character = button.getText().toString();
        if (lengthOfEguqtion > 13) {
            return;
        }
        textEquation.append(character);
        refreshText();
    }
    private void refreshText() {
        TextView textView = findViewById(R.id.textView);
        textView.setText(textEquation.toString());
    }
    public void makeCalculation(View view)
    {


    }

}
