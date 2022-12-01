package com.example.labo8;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean convertions = false, autre = true;
    double d;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){


        // Handle item selection
        switch (item.getItemId()) {
            case R.id.convertion:

                //popup();
                //return true;
                Intent intent1 =new Intent(this,popupActivity.class);//firstActivity
                startActivity(intent1);
                return true;/*
            case R.id.two:
                Intent intent2 =new Intent(this,ActivityTwo.class);//second Activity
                startActivity(intent2);
                return true;*/
            default:
                return super.onOptionsItemSelected(item);
        }

        /*View menuItemView = findViewById(R.id.convertion);
        PopupMenu popupMenu = new PopupMenu(this, menuItemView);
        popupMenu.inflate(R.menu.popup);
        popupMenu.show();
        return true;

        switch(item.getItemId()){
            case R.id.convertion:
                Intent intent = new Intent();
                intent.setClassName(MainActivity.this, "MainActivity2.java");
                startActivity(intent);
                return true;
        }
        return false;*/
    }
    public void openActivityForResult() {

        //Instead of startActivityForResult use this one
        Intent intent = new Intent(this,MainActivity2.class);
        ActivityResultLauncher<Intent> someActivityResultLauncher = null;
        someActivityResultLauncher.launch(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnCUS = (Button) findViewById(R.id.buttonCUS);
        btnCUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Intent main2 = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(main2);

                //prepareCall();

                ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
                        new ActivityResultContracts.StartActivityForResult(),
                        new ActivityResultCallback<ActivityResult>() {
                            @Override
                            public void onActivityResult(ActivityResult result) {
                                if (result.getResultCode() == Activity.RESULT_OK) {
                                    // Here, no request code
                                    Intent data = result.getData();
                                    //doSomeOperations();
                                }
                            }
                        });*/
               openactivitie2();
            }

        });
       Button btnElaC = (Button) findViewById(R.id.buttonElaC);
        btnElaC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (convertions){
                    final EditText edit =  (EditText) findViewById(R.id.nombredebanane);
                    if (edit.getText().toString() != "") {
                        TextView resulta;
                        Activity itemView;
                        itemView.findViewById(R.id.resultat);
                        public void setresultas(int resultas){resulta.setText(resultas);}
                        switch ((int) d) {
                            case 0: resulta.setText(Double.toString(Integer.valueOf(edit.getText().toString())*18));
                                break;
                            case 1:resulta.setText(Double.toString(Integer.valueOf(edit.getText().toString())*180));
                                break;
                            case 2:resulta.setText(Double.toString(Integer.valueOf(edit.getText().toString())*1.8));
                                break;
                            case 3:resulta.setText(Double.toString(Integer.valueOf(edit.getText().toString())*0.18));
                                break;
                            case 4:resulta.setText(Double.toString(Integer.valueOf(edit.getText().toString())*18));
                                break;
                            case 5:resulta.setText(Double.toString(Integer.valueOf(edit.getText().toString())*7.1));
                                break;


                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"aucun nombre de banane donner",Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(getApplicationContext(),"aucune uniter de convertion choisi encore",Toast.LENGTH_SHORT).show();
                }
            }
        }); /**/



    }

    /*@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case (MY_CHILD_ACTIVITY ) : {
                if (resultCode == Activity.RESULT_OK) {
                    // TODO Extract the data returned from the child Activity.
                    String returnValue = data.getStringExtra("some_key");
                }
                break;
            }
        }
    }*/
    public void openactivitie2(){
        ActivityResultLauncher<Intent> getData = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent intent = result.getData();
                        if (intent == null) return;
                        d = intent.getDoubleExtra("rate", -1);
                    }
                });
        convertions = true;
        Intent intent = new Intent(this,MainActivity2.class);
        getData.launch(intent);

        /*
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        PopupWindow pw = new PopupWindow(inflater.inflate(R.layout.popup, null, false),100,100, true);

        pw.showAtLocation(this.findViewById(R.id.popup), Gravity.CENTER, 0, 0);

         */
    }


}