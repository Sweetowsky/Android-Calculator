package pl.lodz.uni.math.slodkowski.bartlomiej.androidcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import pl.lodz.uni.math.slodkowski.bartlomiej.androidcalculator.calculator.Calculator;
import pl.lodz.uni.math.slodkowski.bartlomiej.androidcalculator.database.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    private final Calculator calculator = new Calculator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void historyButtonClick(View view ){
        Intent intent = new Intent(MainActivity.this,HistoryActivity.class);
        startActivity(intent);
    }

    public void clearAllSignsButtonClick(View view ){
        calculator.clear();
        refreshText();
    }
    public void clearLastSignButtonClick(View view ){
        calculator.clearLastSign();
        refreshText();

    }

    public void numberOrOperatorButtonClick(View view){
        Button button =(Button) view;
        String buttonText = button.getText().toString();
        calculator.append(buttonText);
        refreshText();
    }
    private void refreshText() {
        TextView textView = findViewById(R.id.textView);
        textView.setText(calculator.getTextEquation().toString());
    }
    public void makeCalculationClick(View view) {
        int lengthOfEquation=calculator.getTextEquation().length();

        if(lengthOfEquation>0){
            String result;
            TextView textView = findViewById(R.id.textView);
            result=calculator.calculateEquation();
            textView.setText(result);

            if (result=="NaN") {
            } else {
                DatabaseHelper database = new DatabaseHelper(this);
                database.setData(calculator.getTextEquation().toString() + " = " + result);
            }
        }

        calculator.clear();

    }
    public void exitButtonClick(View view)
    {
        System.exit(0);
    }

}
