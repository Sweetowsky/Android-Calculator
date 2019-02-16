package pl.lodz.uni.math.slodkowski.bartlomiej.androidcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

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
        int lengthEquation = textEquation.length();
        if (lengthEquation < 1) {
            refreshText();
        } else {
            textEquation.delete(0, textEquation.length());
            refreshText();
        }

    }
    public void clearLastSign(View view ){
        int lengthEquation = textEquation.length();
        if (lengthEquation < 1) {
            refreshText();
        } else {
            textEquation.delete(textEquation.length() - 1, textEquation.length());
            refreshText();
        }

    }

    public void addToEquation(View view){
        int lengthOfEquation = textEquation.length() - 1;
        TextView button = (TextView) view;
        String character = button.getText().toString();
        if (lengthOfEquation > 13) {
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
        int lengthEquation = textEquation.length();
        if (lengthEquation < 1) {
            return;
        }
        double result;
        try {
            Expression expression = new ExpressionBuilder(textEquation.toString()).build();
            result = expression.evaluate();
        } catch (Exception e) {
            result = Double.NaN;
        }

        TextView textView = findViewById(R.id.textView);
        textView.setText(String.valueOf(result));
        textEquation.delete(0, textEquation.length());


    }

}
