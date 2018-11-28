package uva.inf.ivagonz.mycalculator;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DummyActivity extends AppCompatActivity {

    private TextView tv_showMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);
        Intent parentActivity = getIntent();
        tv_showMessage = (TextView)findViewById(R.id.tv_dummyActivity_showMessage);
        String message = parentActivity.getStringExtra("MENSAJE");
        //Si no ha metido un mensaje
        if(!"".equals(message) && message != null){
            tv_showMessage.setText(message);
            createDialog(DummyActivity.this,message);
        }else{
            tv_showMessage.setText("No has introducido mensaje");
        }



    }

    private void createDialog(Context context, String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        // set title
        alertDialogBuilder.setTitle(context.getString(R.string.dialog_title));

        // set dialog message
        alertDialogBuilder
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton(context.getString(R.string.dialog_possitiveButton), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, close dialog
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }
}
