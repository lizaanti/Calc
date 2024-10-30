package com.example.calc;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    String oldNumber;
    String operator = "";
    EditText editText;
    Boolean isNew = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void clickNumber(View view) {
        if (isNew) {
            editText.setText("");
        }
        isNew = false;
        String number = editText.getText().toString();
        if (view.getId() == R.id.btn7) {
            editText.setText(number + "7");

        } else if (view.getId() == R.id.btn8) {
            editText.setText(number + "8");

        } else if (view.getId() == R.id.btn9) {
            editText.setText(number + "9");

        } else if (view.getId() == R.id.btn6) {
            editText.setText(number + "6");

        } else if (view.getId() == R.id.btn5) {
            editText.setText(number + "5");

        } else if (view.getId() == R.id.btn4) {
            editText.setText(number + "4");
        } else if (view.getId() == R.id.btn3) {
            editText.setText(number + "3");
        } else if (view.getId() == R.id.btn2) {
            editText.setText(number + "2");
        } else if (view.getId() == R.id.btn1) {
            editText.setText(number + "1");
        } else if (view.getId() == R.id.btn0) {
            editText.setText(number + "0");
        } else if (view.getId() == R.id.btnPeriod) {
            if (periodIsPresent(number)){}
            else{
                number = number + ".";
            }
            editText.setText(number);
        } else if (view.getId() == R.id.btnPlusMinus) {
            if (minusIsPresent(number)){
                number = number.substring(1);
            }
            else{
                number = "-" + number;
            }
            editText.setText(number);
        } else if (view.getId() == R.id.btnAC) {
            editText.setText("");
            isNew = true;
        }
    }

    public void operation(View view) {

        isNew = true;
        oldNumber = editText.getText().toString();
        if (view.getId() == R.id.btnMinus) {
            operator = "-";

        }

        else if (view.getId() == R.id.btnPlus) {
            operator = "+";
        }

        else if (view.getId() == R.id.btnDivide) {
            operator = "/";
        }

        else if (view.getId() == R.id.btnMultiply) {
            operator = "*";
        }
    }

    public void clickResult(View view) {
        String newNumber = editText.getText().toString();
        Double result = 0.0;
        if (operator == "-") {
            result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
        }

        else if (operator == "+") {
            result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
        }

        else if (operator == "/") {
            result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
        }

        else if (operator == "*") {
            result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
        }
        editText.setText(result+"");

        }
    public boolean periodIsPresent(String number) {
        return number.contains(".");
    }

    public boolean minusIsPresent(String number){
        if(number.charAt(0) == '-')
            return true;
        if (number.equals("0") || number.equals("0.0")) {
            return false;
        }
        else
            return false;
    }

    public void clickProcent(View view){
        if(operator == ""){
            String number = editText.getText().toString();
            double temp = Double.parseDouble(number) / 100;
            number = temp + "";
            editText.setText(number);
        }
        else{
            String newNumber = editText.getText().toString();
            Double result = 0.0;
            if (operator == "-") {
                result = Double.parseDouble(oldNumber) - Double.parseDouble(oldNumber) * Double.parseDouble(newNumber) / 100;
            }

            else if (operator == "+") {
                result = Double.parseDouble(oldNumber) + Double.parseDouble(oldNumber) * Double.parseDouble(newNumber) / 100;
            }

            else if (operator == "/") {
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber) * 100;
            }

            else if (operator == "*") {
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber) / 100;
            }
            editText.setText(result + "");
            operator = "";
        }
    }
}