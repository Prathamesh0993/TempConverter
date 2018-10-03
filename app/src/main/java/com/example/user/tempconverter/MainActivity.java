package com.example.user.tempconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public EditText et1,et2,et3,et4,et5;
    public Button b;
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

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et1.isFocused()){
                    double data = Double.parseDouble(et1.getText().toString());
                    et2.setText((data*1.8+32)+""); //cel to fah
                    et3.setText((data+273.15)+"");  //cel to kel
                    et4.setText((data*0.8)+""); // cel to rea
                    et5.setText(((data+273.15)/(1.41683385 *(int)Math.pow(10,32)))+"");  // cel to pla
                }else if(et2.isFocused()){
                    double data = Double.parseDouble(et2.getText().toString());
                    et1.setText((((data-32)*5)/9)+""); //fah to cel
                    Double kel = (data + 459.67)/1.8;
                    et3.setText((kel)+"");  // fah to kel
                    et4.setText(((data-32)/2.25)+"");  // fah to rea
                    et5.setText(((data+ 459.67) / (2.55030092*(int)Math.pow(10,32)))+""); // fah to pla
                }else if(et3.isFocused()){
                    double data = Double.parseDouble(et3.getText().toString());
                    et1.setText((data-273.15)+""); //kel to cel
                    Double fah = data*1.8-459.67;
                    et2.setText((fah)+""); //kel to fah
                    et4.setText(((data - 273.15)*0.)+""); // kel to rea
                    et5.setText((data/(1.41683385*(int)Math.pow(10,32)))+"");  //kel to pla
                }else if(et4.isFocused()){
                    double data = Double.parseDouble(et4.getText().toString());
                    et1.setText((data*1.25)+""); //rea to cel
                    et2.setText((data*2.25+32)+""); //rea to fah
                    et3.setText((data*1.25+273.15)+"");  // rea to kel

                    et5.setText("");  //rea to pla
                }else if(et5.isFocused()){
                    double data = Double.parseDouble(et5.getText().toString());
                    et1.setText((data*1.41683385*(int)Math.pow(10,32)-273.15)+""); //pla to cel
                    et2.setText((data*2.55030092*(int)Math.pow(10,32)-459.67)+""); //pla to fah
                    et3.setText((data*1.41683385*(int)Math.pow(10,32))+"");  // pla to kel
                    et4.setText(""); // pla to rea
                }
            }
        });
    }
}
