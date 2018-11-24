package uva.inf.ivagonz.mycalculator;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class CalculatorFragment extends Fragment implements View.OnClickListener {

    private View calculatorFragment;

    private double valueOne = Double.NaN;
    private double valueTwo;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;
    private DecimalFormat decimalFormat;

    private Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9;
    private Button btn_add, btn_substract, btn_multiply, btn_divide, btn_clear, btn_dot, btn_equal;

    private EditText et_number;
    private TextView tv_info;


    public CalculatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        calculatorFragment = inflater.inflate(R.layout.ly_fragment_calculator, container, false);
        decimalFormat = new DecimalFormat("#.######");

        et_number = (EditText) calculatorFragment.findViewById(R.id.et_number);
        tv_info = (TextView) calculatorFragment.findViewById(R.id.infoTextView);
        btn_0 = (Button) calculatorFragment.findViewById(R.id.buttonZero);
        btn_1 = (Button) calculatorFragment.findViewById(R.id.buttonOne);
        btn_2 = (Button) calculatorFragment.findViewById(R.id.buttonTwo);
        btn_3 = (Button) calculatorFragment.findViewById(R.id.buttonThree);
        btn_4 = (Button) calculatorFragment.findViewById(R.id.buttonFour);
        btn_5 = (Button) calculatorFragment.findViewById(R.id.buttonFive);
        btn_6 = (Button) calculatorFragment.findViewById(R.id.buttonSix);
        btn_7 = (Button) calculatorFragment.findViewById(R.id.buttonSeven);
        btn_8 = (Button) calculatorFragment.findViewById(R.id.buttonEight);
        btn_9 = (Button) calculatorFragment.findViewById(R.id.buttonNine);
        btn_add = (Button) calculatorFragment.findViewById(R.id.buttonAdd);
        btn_substract = (Button) calculatorFragment.findViewById(R.id.buttonSubtract);
        btn_multiply = (Button) calculatorFragment.findViewById(R.id.buttonMultiply);
        btn_divide = (Button) calculatorFragment.findViewById(R.id.buttonDivide);
        btn_dot = (Button) calculatorFragment.findViewById(R.id.buttonDot);
        btn_clear = (Button) calculatorFragment.findViewById(R.id.buttonClear);
        btn_equal = (Button) calculatorFragment.findViewById(R.id.buttonEqual);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_substract.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_equal.setOnClickListener(this);

        return calculatorFragment;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.buttonDot:
            case R.id.buttonZero:
            case R.id.buttonOne:
            case R.id.buttonTwo:
            case R.id.buttonThree:
            case R.id.buttonFour:
            case R.id.buttonFive:
            case R.id.buttonSix:
            case R.id.buttonSeven:
            case R.id.buttonEight:
            case R.id.buttonNine:
                setEditTextWithButton(et_number, id);
                break;
            case R.id.buttonAdd:
            case R.id.buttonSubtract:
            case R.id.buttonMultiply:
            case R.id.btn_dividir:
                checkCalculation(id);
                break;
            case R.id.buttonEqual:
                computeCalculation();
                tv_info.setText(tv_info.getText().toString() +
                        decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
                valueOne = Double.NaN;
                CURRENT_ACTION = '0';
                break;
            case R.id.buttonClear:
                if (et_number.getText().length() > 0) {
                    String currentText = et_number.getText().toString();
                    et_number.setText(currentText.subSequence(0, currentText.length() - 1));
                } else {
                    valueOne = Double.NaN;
                    valueTwo = Double.NaN;
                    et_number.setText("");
                    tv_info.setText("");
                }
                break;

        }
    }

    private void setEditTextWithButton(EditText et, int id) {
        Button btn = (Button) calculatorFragment.findViewById(id);
        et.setText(et.getText() + btn.getText().toString());
    }

    private void setTextViewWithButton(TextView tv, int id) {
        Button btn = (Button) calculatorFragment.findViewById(id);
        tv.setText(decimalFormat.format(valueOne) + btn.getText().toString());
    }

    private void checkCalculation(int id) {
        computeCalculation();
        switch (id) {
            case R.id.buttonAdd:
                CURRENT_ACTION = ADDITION;
                break;
            case R.id.buttonSubtract:
                CURRENT_ACTION = SUBTRACTION;
                break;
            case R.id.buttonMultiply:
                CURRENT_ACTION = MULTIPLICATION;
                break;
            case R.id.buttonDivide:
                CURRENT_ACTION = DIVISION;
                break;
        }
        setTextViewWithButton(tv_info, id);
        et_number.setText(null);

    }

    private void computeCalculation() {
        if (!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(et_number.getText().toString());
            et_number.setText(null);

            if (CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if (CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valueTwo;
            else if (CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valueTwo;
            else if (CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valueTwo;
        } else {
            try {
                valueOne = Double.parseDouble(et_number.getText().toString());
            } catch (Exception e) {
            }
        }
    }
}
