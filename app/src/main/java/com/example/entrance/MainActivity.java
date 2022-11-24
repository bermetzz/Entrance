package com.example.entrance;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText password;
    private EditText login;
    private Button btn;
    private LinearLayout l1;
    private LinearLayout l2;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        setContentView(R.layout.activity_main);
        addListenerOnButton();
        login.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().trim().length()>0){
                    btn.setBackgroundColor(getResources().getColor(R.color.orange));
                }
                else btn.setBackgroundColor(getResources().getColor(R.color.gray));

            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().trim().length()>0){
                    btn.setBackgroundColor(getResources().getColor(R.color.orange));
                }
                else btn.setBackgroundColor(getResources().getColor(R.color.gray));

            }
        });
    }



    public void addListenerOnButton() {
        password = (EditText)findViewById(R.id.password);
        login = (EditText)findViewById(R.id.email);
        btn = (Button)findViewById(R.id.done);
        text = (TextView)findViewById(R.id.main);
        l1 = (LinearLayout)findViewById(R.id.inputs);
        l2 = (LinearLayout)findViewById(R.id.help);
        btn.setOnClickListener(
                view -> {
                    if(password.getText().toString().trim().equals("admin") && login.getText().toString().trim().equals("admin")){
                        l1.setVisibility(View.GONE); l2.setVisibility(View.GONE); text.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Неправильный логин или пароль", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}