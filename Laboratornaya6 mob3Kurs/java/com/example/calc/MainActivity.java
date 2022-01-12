package com.example.calc;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private  CalcModelOperation calculator;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] arrIdNumber = new int[] {
                R.id.buttonOne,
                R.id.buttonTwo,
                R.id.buttonThree,
                R.id.buttonFour,
                R.id.buttonFive,
                R.id.buttonSix,
                R.id.buttonSeven,
                R.id.buttonEight,
                R.id.buttonNine,
                R.id.buttonZero
        };

        int[] arrIdAction = new int[]{
                R.id.buttonPlus,
                R.id.buttonMinus,
                R.id.buttonMultiplication,
                R.id.buttonDiv,
                R.id.buttonResult
        };

        text = findViewById(R.id.textView);
        calculator = new CalcModelOperation();

        View.OnClickListener numberClickButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onPressNumber(view.getId());
                text.setText(calculator.getText()); //обновление текстового поля
            }
        };

        View.OnClickListener actionClickButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onPressOperation(view.getId());
                text.setText(calculator.getText());
            }
        };
        for (int i=0; i<arrIdNumber.length; i++){
            findViewById(arrIdNumber[i]).setOnClickListener(numberClickButtonListener);
        }
        for (int i=0; i<arrIdAction.length; i++){
                findViewById(arrIdAction[i]).setOnClickListener(actionClickButtonListener);
        }
    }
}