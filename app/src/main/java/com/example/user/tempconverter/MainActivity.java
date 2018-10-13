package com.example.user.tempconverter;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    public EditText et1, et2, et3, et4, et5;
    public Button b,b1;
    private AlertDialog.Builder adb;
    private DecimalFormat dfe,df;
    private boolean emptyflag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);
        et4 = (EditText) findViewById(R.id.editText4);
        et5 = (EditText) findViewById(R.id.editText5);

        b = (Button) findViewById(R.id.button);
        b1 = (Button) findViewById(R.id.button2);

        adb = new AlertDialog.Builder(this);

        dfe=new DecimalFormat("#.###E0");
        df=new DecimalFormat("#.###");

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et1.isFocused()) {
                    if(!isEmpty(et1)) {
                        emptyflag=false;
                        double data = Double.parseDouble(et1.getText().toString());
                        et2.setText(df.format((data * 1.8 + 32)) + ""); //cel to fah
                        et3.setText(df.format((data + 273.15)) + "");  //cel to kel
                        et4.setText(df.format((data * 0.8)) + ""); // cel to rea
                        et5.setText(dfe.format(((data + 273.15) / (1.416785 * Math.pow(10, 32)))) + "");  // cel to pla
                    }else   emptyflag=true;
                } else if (et2.isFocused()) {
                    if(!isEmpty(et2)) {
                        emptyflag=false;
                        double data = Double.parseDouble(et2.getText().toString());
                        et1.setText(df.format((((data - 32) * 5) / 9)) + ""); //fah to cel
                        Double kel = (data + 459.67) / 1.8;
                        et3.setText(df.format((kel)) + "");  // fah to kel
                        et4.setText(df.format(((data - 32) / 2.25)) + "");  // fah to rea
                        et5.setText(dfe.format(((data + 459.67) / (2.550230092 * Math.pow(10, 32)))) + ""); // fah to pla
                    }else   emptyflag=true;
                } else if (et3.isFocused()) {
                    if(!isEmpty(et3)) {
                        emptyflag=false;
                        double data = Double.parseDouble(et3.getText().toString());
                        et1.setText(df.format((data - 273.15)) + ""); //kel to cel
                        Double fah = data * 1.8 - 459.67;
                        et2.setText(df.format((fah)) + ""); //kel to fah
                        et4.setText(df.format(((data - 273.15)) * 0.8) + ""); // kel to rea
                        et5.setText(dfe.format((data / (1.41683385 *  Math.pow(10, 32)))) + "");  //kel to pla
                    }else   emptyflag=true;
                } else if (et4.isFocused()) {
                    if(!isEmpty(et4)) {
                        emptyflag=false;
                        double data = Double.parseDouble(et4.getText().toString());
                        et1.setText(df.format((data * 1.25)) + ""); //rea to cel
                        et2.setText(df.format((data * 2.25 + 32)) + ""); //rea to fah
                        et3.setText(df.format((data * 1.25 + 273.15)) + "");  // rea to kel
                        et5.setText(dfe.format((data/(1.133428 * Math.pow(10, 32)) + ( 1.9279566059776 * Math.pow(10, -30))))+"");  //rea to pla
                    }else   emptyflag=true;
                } else if (et5.isFocused()) {
                    if(!isEmpty(et5)) {
                        emptyflag=false;
                        double data = Double.parseDouble(et5.getText().toString());
                        et1.setText(dfe.format((data * 1.416785 * Math.pow(10, 32) - 273.15)) + ""); //pla to cel
                        et2.setText(dfe.format((data * 2.550230092 *  Math.pow(10, 32) - 459.67)) + ""); //pla to fah
                        et3.setText(dfe.format((data * 1.41683385 *  Math.pow(10, 32))) + "");  // pla to kel
                        et4.setText(dfe.format((data * 1.133428 * Math.pow(10,32))) + ""); // pla to rea
                    }else   emptyflag=true;
                }

                if(emptyflag){
                    emptyflag = false;
                    Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("Error Message..");
                    alert.setMessage("Please enter value in text box");
                    alert.setPositiveButton("OK",null);
                    alert.show();
                }
            }

        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText("");
                et2.setText("");
                et3.setText("");
                et4.setText("");
                et5.setText("");
            }
        });

    }

    private boolean isEmpty(EditText e){
        if(e.getText().toString().trim().length() > 0)
            return false;
        return true;
    }
}
