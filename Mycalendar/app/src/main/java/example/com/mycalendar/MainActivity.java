package example.com.mycalendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private AlarmManager alarmManager;
    private int hour;
    private int  minute;
    android.os.Handler handler=new Handler() ;
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            Time t=new Time(); // or Time t=new Time("GMT+8"); 加上Time Zone资料。
            t.setToNow(); // 取得系统时间。
            int year = t.year;
            int month = t.month+1;//“monthOfYear The month that was set (0-11) ”
            int day = t.monthDay;
             hour = t.hour; // 0-23
            minute = t.minute;
            int second = t.second;


            TextView y=(TextView)findViewById(R.id.year);
            TextView m=(TextView) findViewById(R.id.month);
            TextView d=(TextView) findViewById(R.id.day);
            y.setText(String.valueOf(year));
            m.setText(String.valueOf(month));
            d.setText(String.valueOf(day));
            TextView tm=(TextView)findViewById(R.id.timeinday);
            String time = (hour + ":" + minute + ":" + second);
            tm.setText(time);
            handler.postDelayed(this, 1000);


        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalendarView calendar = (CalendarView) findViewById(R.id.calendarView);
        handler.postDelayed(runnable, 1000);//每两秒执行一次runnable.
        ImageButton imageButton1=(ImageButton)findViewById(R.id.clock);
        imageButton1.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                Intent intent=new Intent(MainActivity.this,Clock.class);
                startActivity(intent);
            }
        });
        ImageButton imageButton2=(ImageButton)findViewById(R.id.ring);
        imageButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            }
  public  void  alarmOne(View view){
                   TimePickerDialog timePickerDialog=new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
         @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                              Calendar c=Calendar.getInstance();
                                 c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                                c.set(Calendar.MINUTE,minute);
                                   //时间一到，发送广播（闹钟响了）
                                     Intent intent=new Intent();
                                   intent.setAction("example.com.mycalendar.RING");
                                      //将来时态的跳转
                                   PendingIntent pendingIntent=PendingIntent.getBroadcast(MainActivity.this,0x101,intent,0);
                                  //设置闹钟
                                   alarmManager.set(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pendingIntent);
                           }
    },hour,minute,true);
                    timePickerDialog.show();

            }
        });
    }







    }

