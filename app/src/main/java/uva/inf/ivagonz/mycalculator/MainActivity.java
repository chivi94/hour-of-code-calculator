package uva.inf.ivagonz.mycalculator;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private double sumar(double a, double b) {
        return a + b;
    }

    private double restar(double a, double b) {
        return a - b;
    }

    private double multiplicar(double a, double b) {
        return a * b;
    }

    private double dividir(double a, double b) {
        return a / b;
    }

    private void showMessage(Context context) {
        Toast.makeText(context, "Debes introducir números", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enlace de los elementos gráficos con nuestro código
        Button btn_sumar = (Button) findViewById(R.id.btn_sumar);
        Button btn_restar = (Button) findViewById(R.id.btn_restar);
        Button btn_multiplicar = (Button) findViewById(R.id.btn_multiplicar);
        Button btn_dividir = (Button) findViewById(R.id.btn_dividir);

        TextView tv_num1 = (TextView) findViewById(R.id.tv_numero1);
        TextView tv_num2 = (TextView) findViewById(R.id.tv_numero2);


        btn_sumar.setOnClickListener(this);
        btn_restar.setOnClickListener(this);
        btn_multiplicar.setOnClickListener(this);
        btn_dividir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        TextView tv_resultado = (TextView) findViewById(R.id.tv_resultado);
        EditText et_num1 = (EditText) findViewById(R.id.et_numero1);
        EditText et_num2 = (EditText) findViewById(R.id.et_numero2);

        String txt_1 = et_num1.getText().toString();
        String txt_2 = et_num2.getText().toString();
        try {
            switch (id) {
                case R.id.btn_sumar:
                    tv_resultado.setText(String.valueOf(sumar(Double.parseDouble(txt_1), Double.parseDouble(txt_2))));
                    break;
                case R.id.btn_restar:
                    tv_resultado.setText(String.valueOf(restar(Double.parseDouble(txt_1), Double.parseDouble(txt_2))));
                    break;
                case R.id.btn_multiplicar:
                    tv_resultado.setText(String.valueOf(multiplicar(Double.parseDouble(txt_1), Double.parseDouble(txt_2))));
                    break;
                case R.id.btn_dividir:
                    tv_resultado.setText(String.valueOf(dividir(Double.parseDouble(txt_1), Double.parseDouble(txt_2))));
                    break;
            }
        } catch (NumberFormatException e) {
            showMessage(MainActivity.this);
        }
    }
}
