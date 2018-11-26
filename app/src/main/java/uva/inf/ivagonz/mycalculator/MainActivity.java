package uva.inf.ivagonz.mycalculator;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{



    private Button complexCalculator;
    private Button simpleCalculator;

    private Intent intent;

    private final String COMPLEX = "COMPLEX";
    private final String SIMPLE = "SIMPLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ly_main_activity);

        complexCalculator = (Button) findViewById(R.id.btn_mainActivity_complexCalculator);
        complexCalculator.setOnClickListener(this);
        simpleCalculator = (Button) findViewById(R.id.btn_mainActivity_simpleCalculator);
        simpleCalculator.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        intent = new Intent(MainActivity.this,CalculatorActivity.class);
        switch (id){
            case R.id.btn_mainActivity_simpleCalculator:
                intent.putExtra("SIMPLE",SIMPLE);
                break;
            case R.id.btn_mainActivity_complexCalculator:
                intent.putExtra("COMPLEX",COMPLEX);
                break;
        }
        startActivity(intent);
    }


}
