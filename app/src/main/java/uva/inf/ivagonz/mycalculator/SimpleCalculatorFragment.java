package uva.inf.ivagonz.mycalculator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class SimpleCalculatorFragment extends Fragment implements View.OnClickListener {

    private View calculatorFragment;
    private Calculadora calculadora;

    private EditText et_operando1, et_operando2;
    private Button btn_sumar, btn_restar, btn_multiplicar, btn_dividir, btn_igual;
    private TextView tv_result;

    public SimpleCalculatorFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        calculatorFragment = inflater.inflate(R.layout.ly_fragment_simplecalculator, container, false);
        calculadora = new Calculadora();

        et_operando1 = (EditText) calculatorFragment.findViewById(R.id.et_simpleCalculator_operando1);
        et_operando2 = (EditText) calculatorFragment.findViewById(R.id.et_simpleCalculator_operando2);
        tv_result = (TextView)calculatorFragment.findViewById(R.id.tv_simpleCalculator_result);

        btn_sumar = (Button) calculatorFragment.findViewById(R.id.btn_simpleCalculator_sumar);
        btn_restar = (Button) calculatorFragment.findViewById(R.id.btn_simpleCalculator_restar);
        btn_multiplicar = (Button) calculatorFragment.findViewById(R.id.btn_simpleCalculator_multiplicar);
        btn_dividir = (Button) calculatorFragment.findViewById(R.id.btn_simpleCalculator_dividir);
        btn_igual = (Button) calculatorFragment.findViewById(R.id.btn_simpleCalculator_igual);

        btn_sumar.setOnClickListener(this);
        btn_restar.setOnClickListener(this);
        btn_multiplicar.setOnClickListener(this);
        btn_dividir.setOnClickListener(this);
        btn_igual.setOnClickListener(this);

        return calculatorFragment;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        String operando1, operando2;
        double resultado;

        operando1 = et_operando1.getText().toString();
        operando2 = et_operando2.getText().toString();
        if (!"".equals(operando1) && operando1 != null
                && !"".equals(operando2) && operando2 != null) {
            calculadora.setA(Double.parseDouble(operando1));
            calculadora.setB(Double.parseDouble(operando2));
            switch (id) {
                case R.id.btn_simpleCalculator_sumar:
                    resultado = Double.parseDouble(calculadora.getDecimalFormat().format(calculadora.sumar(calculadora.getA(),calculadora.getB())));
                    calculadora.setResult(resultado);
                    break;
                case R.id.btn_simpleCalculator_restar:
                    resultado = Double.parseDouble(calculadora.getDecimalFormat().format(calculadora.restar(calculadora.getA(),calculadora.getB())));
                    calculadora.setResult(resultado);
                    break;
                case R.id.btn_simpleCalculator_multiplicar:
                    resultado = Double.parseDouble(calculadora.getDecimalFormat().format(calculadora.multiplicar(calculadora.getA(),calculadora.getB())));
                    calculadora.setResult(resultado);
                    break;
                case R.id.btn_simpleCalculator_dividir:
                    resultado = Double.parseDouble(calculadora.getDecimalFormat().format(calculadora.dividir(calculadora.getA(),calculadora.getB())));
                    calculadora.setResult(resultado);
                    break;

            }
            tv_result.setText(String.valueOf(calculadora.getResult()));

        }
    }

}
