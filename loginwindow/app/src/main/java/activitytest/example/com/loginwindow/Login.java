package activitytest.example.com.loginwindow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class Login extends AppCompatActivity {
    HashMap<String, String> user = new HashMap<String, String>();
    Boolean IsSave = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button1 = (Button) findViewById(R.id.in);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View W) {
                EditText account = (EditText) findViewById(R.id.account);
                EditText password = (EditText) findViewById(R.id.givepassword);
                String str1 = account.getText().toString();
                String str2 = password.getText().toString();

                if (!user.containsKey(str1)) {
                    Toast.makeText(Login.this, "can't find this account", Toast.LENGTH_SHORT).show();
                }
                if (!str2.equals(user.get(str1)))
                    Toast.makeText(Login.this, "your password is wrong!", Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent(Login.this, Suceess.class);
                    intent.putExtra("extra_str1",str1);
                    intent.putExtra("extra_str2",str2);
                    startActivity(intent);
                }
                if(IsSave==false) {
                    account.setText("");
                    password.setText("");
                }
            }
        });
        Button button2 = (Button) findViewById(R.id.up);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View W) {
                EditText account = (EditText) findViewById(R.id.account);
                EditText password = (EditText) findViewById(R.id.givepassword);
                String str1 = account.getText().toString();
                String str2 = password.getText().toString();
                account.setText("");
                password.setText("");
                if (!user.containsKey(str1)) {
                    user.put(str1, str2);
                    Toast.makeText(Login.this, str1 + "register.....ok!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Login.this, str1 + "The id has been used!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    IsSave = true;
                } else
                    IsSave = false;
            }
        });
        checkBox.setChecked(IsSave);

    }
}