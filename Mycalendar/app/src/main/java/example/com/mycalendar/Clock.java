package example.com.mycalendar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.DialogPreference;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RemoteViews;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Clock extends AppCompatActivity {
    private ListView listView;
    private String eventname="";
    private String eventtime="";
    private List<Map<String,Object>>list=new ArrayList<Map<String,Object>>();
    private  int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        final SharedPreferences preferences=getSharedPreferences("event", Context.MODE_PRIVATE);
        count=preferences.getInt("count", 0);
        for(int i=count;i>=1;i--){
            eventtime=preferences.getString("tm"+i, "");
            eventname=preferences.getString("nm"+i, "");
            if(!eventname.equals("")&&!eventtime.equals("")){
                Map<String,Object> map = new HashMap<String,Object>();
                map.put("event",eventname);
                map.put("time",eventtime);
                list.add(map);
            }}
        ListView listView = (ListView) findViewById(R.id.listView);
        final SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.line,
                new String[]{"event", "time"}, new int[]{R.id.event, R.id.thetime});
        listView.setAdapter(adapter);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("event","事例:\n开学");
        map.put("time","9月1日12：00");
        list.add(map);
        adapter.notifyDataSetChanged();
        ImageButton newevent = (ImageButton) findViewById(R.id.newevent);
        newevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Clock.this);
                View view = View.inflate(Clock.this, R.layout.dialog_custom_view, null);
                final EditText nm = (EditText) view.findViewById(R.id.eventname);
                final EditText tm = (EditText) view.findViewById(R.id.eventtime);
                Button queren = (Button) view.findViewById(R.id.queren);
                Button quxiao = (Button) view.findViewById(R.id.quxiao);
                builder.setView(view);
                final AlertDialog dialog=builder.show();
                queren.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        eventname = nm.getText().toString();
                        eventtime = tm.getText().toString();
                        if (!eventname.equals("") && !eventtime.equals("")) {
                            Map<String, Object> map = new HashMap<String, Object>();
                            map.put("event", eventname);
                            map.put("time", eventtime);
                            list.add(map);
                            count += 1;
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("tm"+count, eventtime);
                            editor.putString("nm"+count, eventname);
                            editor.putInt("count",count);
                            editor.commit();
                            adapter.notifyDataSetChanged();
                                                  }
                        if(eventname.equals(""))
                            new AlertDialog.Builder(Clock.this).setTitle("事件错误").setMessage("兄die,你没写具体事件。")
                                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                        }}).show();
                        if(eventtime.equals(""))
                            new AlertDialog.Builder(Clock.this).setTitle("时间错误").setMessage("时间呢？老铁")
                                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                        }}).show();

                        eventname = "";
                        eventtime = "";
                        dialog.dismiss();
                                              }

                                          }
                );
                quxiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
dialog.dismiss();
                    }
                });

            }
            });
        ImageButton getback=(ImageButton)findViewById(R.id.getback);
        getback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Clock.this,MainActivity.class);
                startActivity(intent);
            }
        });
        ImageButton clear=(ImageButton)findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Clock.this).setTitle("删除事件").setMessage("要删除所有事件吗？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                        list.clear();
                                        Map<String,Object> map = new HashMap<String,Object>();
                                        map.put("event","事例:\n开学");
                                        map.put("time","9月1日12：00");
                                        list.add(map);
                                        adapter.notifyDataSetChanged();
                                        SharedPreferences.Editor editor = preferences.edit();
                                        editor.clear();
                                        editor.commit();
                            }}).setNegativeButton("取消",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int which){
                    }
                }).show();
            }
        });

    };
}
