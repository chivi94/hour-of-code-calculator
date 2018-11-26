package uva.inf.ivagonz.mycalculator;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class CalculatorActivity extends AppCompatActivity {

    private SimpleCalculatorFragment simpleCalculatorFragment;
    private ComplexCalculatorFragment complexCalculatorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent().getStringExtra("COMPLEX") != null) {
            complexCalculatorFragment = new ComplexCalculatorFragment();
            commitFragment(complexCalculatorFragment);
        } else {
            simpleCalculatorFragment = new SimpleCalculatorFragment();
            commitFragment(simpleCalculatorFragment);
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    private void commitFragment(Fragment fragment) {
        getFragmentManager()
                .beginTransaction()
                .add(android.R.id.content, fragment,
                        fragment.getClass().getSimpleName())
                .commit();
    }

}
