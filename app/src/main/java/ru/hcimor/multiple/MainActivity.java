package ru.hcimor.multiple;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Нажатие кнопки "Добавить число"
    public void calculateMultiple(View view){
        EditText editTextNumber1 = findViewById(R.id.editTextNumber1);
        EditText editTextNumber2 = findViewById(R.id.editTextNumber2);
        TextView textViewTitle = findViewById(R.id.textTitle1);
        TextView textViewNum1 = findViewById(R.id.textViewNum1);
        TextView textViewNum2 = findViewById(R.id.textViewNum2);
        TextView textViewMultiple = findViewById(R.id.textViewMultiple);
        TextView textViewNOD = findViewById(R.id.textViewNOD);

        // Проверяем, что числа не пустые
        String num1Str = editTextNumber1.getText().toString();
        String num2Str = editTextNumber2.getText().toString();

        if (num1Str.length() == 0 || num2Str.length() == 0){
            textViewTitle.setText("Укажите числа");
            textViewNum1.setText("");
            textViewNum2.setText("");
            textViewMultiple.setText("");
            textViewNOD.setText("");
            return;
        } else {
            textViewTitle.setText("Введите натуральные числа:");
        }

        try {
            int num1 = Integer.parseInt(num1Str);
            int num2 = Integer.parseInt(num2Str);

            // Проверяем, что числа не равны 0
            if (num1 == 0 || num2 == 0){
                textViewTitle.setText("Числа не должны равняться 0");
                textViewNum1.setText("");
                textViewNum2.setText("");
                textViewMultiple.setText("");
                textViewNOD.setText("");
                return;
            } else {
                textViewTitle.setText("Введите натуральные числа:");
            }

            //Получаем списки из простых множителей для введенных чисел
            List<Integer> primeFactorsNum1 = primeFactorization.getPrimeFactors(num1);
            List<Integer> primeFactorsNum2 = primeFactorization.getPrimeFactors(num2);

            String resultNum1 = "Простые множители для" + " " + num1Str + ":" + " ";
            String resultNum2 = "Простые множители для" + " " + num2Str + ":" + " ";

            resultNum1 += primeFactorization.getPrimeFactors(primeFactorsNum1);
            resultNum2 += primeFactorization.getPrimeFactors(primeFactorsNum2);

            // Выводим разложение чисел на простые множители
            textViewNum1.setText(resultNum1);
            textViewNum2.setText(resultNum2);

            // Если числа равны 1 то выводим их множитель 1
            if (num1 == 1){
                textViewNum1.setText("Простые множители для" + " " + num1Str + ":" + " 1");
            }
            if (num2 == 1){
                textViewNum2.setText("Простые множители для" + " " + num2Str + ":" + " 1");
            }

            // Вывод НОК
            String multiple = "НОК для " + num1Str + " и " + num2Str + " равно: ";
            Integer nod = calculateMultiple.getNOK(num1, num2);
            multiple += String.valueOf(nod);
            textViewMultiple.setText(multiple);

            // Вывод НОД
            String denominator = "НОД для " + num1Str + " и " + num2Str + " равен: ";
            Integer nok = calculateMultiple.getNOD(num1, num2);
            denominator += String.valueOf(nok);
            textViewNOD.setText(denominator);

        }catch (NumberFormatException e){
            textViewTitle.setText(e.toString());
        }
    }
}