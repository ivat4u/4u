package activitytest.example.com.loginwindow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Suceess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suceess);
        Intent intent=getIntent();
        String str1=intent.getStringExtra("extra_str1");
        String str2=intent.getStringExtra("extra_str2");
        TextView a=(TextView)findViewById(R.id.textView);
        TextView b=(TextView)findViewById(R.id.textView2);
        a.setText("你的用户名是："+str1);
        b.setText("你的密码是："+str2);

    }
}
