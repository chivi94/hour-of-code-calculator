package uva.inf.ivagonz.mycalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    private EditText et_mensaje;
    private Button btn_enviarMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et_mensaje = (EditText) findViewById(R.id.et_main2Activity_mensaje);
        btn_enviarMensaje = (Button)findViewById(R.id.btn_main2Activity_enviarMensaje);

        //final String mensaje = et_mensaje.getText().toString();
        btn_enviarMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,DummyActivity.class);
                String mensaje = et_mensaje.getText().toString();
                intent.putExtra("MENSAJE",mensaje);
                startActivity(intent);
            }
        });
    }
}
