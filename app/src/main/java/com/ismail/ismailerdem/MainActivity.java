package com.ismail.ismailerdem;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity{



    private EditText etUserName;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnSignUp;
    public TextView txHata;

    private void findViews() {
        etUserName = (EditText)findViewById( R.id.etUserName );
        etPassword = (EditText)findViewById( R.id.etPassword );
        btnLogin = (Button)findViewById( R.id.btnLogin );
        btnSignUp = (Button)findViewById( R.id.btnSignUp );
        txHata = (TextView) findViewById(R.id.txHata);


    }

    public void setClickListeners()
    {


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = etUserName.getText().toString();
                String passWord = etPassword.getText().toString();

                if(userName.length() <= 2)
                {
                   //HATA
                    txHata.setVisibility(View.VISIBLE);
                    txHata.setText("USERNAME COK KUCUK");
                }

                else if(passWord.length() <=4)
                {
                    // hata
                    txHata.setVisibility(View.VISIBLE);
                    txHata.setText("PASSWORD COK KUCUK");

                }


                else
                {
                    //LOGIN OLDU
                    txHata.setVisibility(View.GONE);
                    //BASKA SAYFA GEC
                    AlertDialog d = new AlertDialog.Builder(MainActivity.this)
                            .setTitle("asdasdasdasd")
                            .setMessage("OLDU LOGIN")
                            .setPositiveButton("DIALOG BUTONU", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    Intent i = new Intent(MainActivity.this,IkinciActivity.class);
                                    i.putExtra("usrName",etUserName.getText().toString());
                                    startActivity(i);


                                }
                            })
                            .create();
                    d.show();
                }




            }
        });




    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setClickListeners();







    }

}
