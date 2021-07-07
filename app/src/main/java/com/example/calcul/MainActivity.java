package com.example.calcul;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    EditText ecran;
    double a;
    double b;
    double resultat;
    String Op = "+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ecran =  findViewById(R.id.ecran);
    }

    public void chiffre(View view) {
        String chf = view.getTag().toString();
        String ecranTxt = ecran.getText().toString();
        if(ecranTxt.equals("NaN") || ecranTxt.equals("0") || ecranTxt.contains(".")  )
            ecranTxt="";
        ecranTxt += chf;
        ecran.setText(ecranTxt);
    }

    public void effacer(View view) {
        ecran.setText("");
        a = 0;
        b = 0;
        resultat = 0;
    }

    public void operation(View view) {
        Button btn = (Button) view;
        this.Op = btn.getText().toString();
        String ecranTxt = ecran.getText().toString();
        a = Double.valueOf(ecranTxt);
        Log.i("test", "OP = "+ Op);

        if (Op.equals("COS") || Op.equals("SIN") || Op.equals("TAN") || Op.equals("1/X")){
            Log.i("helloe", "OP = "+ Op);
            egal(view);
        }

        ecran.setText("");

    }

    public void egal(View view) {
        switch (Op)
        {
            case "+" :
                String ecranTxt = ecran.getText().toString();
                b = Double.valueOf(ecranTxt);
                resultat = a + b;
                break;
            case "-" :
                String ecranTxt1 = ecran.getText().toString();
                b = Double.valueOf(ecranTxt1);
                resultat = a - b;
                break;
            case "/" :
                String ecranTxt2 = ecran.getText().toString();
                b = Double.valueOf(ecranTxt2);
                resultat = b==0? Double.NaN : a / b;
                break;
            case "X" :
                String ecranTxt3 = ecran.getText().toString();
                b = Double.valueOf(ecranTxt3);
                resultat =  a * b;
                break;
            case "COS":
                resultat = Math.cos(a);

                ecran.setText(Double.toString(resultat));
                Log.i("test", "a = "+ a);
                Log.i("test", "r = "+ resultat);
                break;
            case "SIN":
                resultat = Math.sin(a);
                ecran.setText(Double.toString(resultat));
                break;
            case "TAN":
                resultat = Math.tan(a);
                ecran.setText(Double.toString(resultat));
                break;
            case "1/X":
                resultat = a==0? Double.NaN : 1 / a;
                ecran.setText(Double.toString(resultat));
                break;
            case "=":
                ecran.setText(Double.toString(resultat));
                break;
        }
        ecran.setText(Double.toString(resultat));
    }
}
