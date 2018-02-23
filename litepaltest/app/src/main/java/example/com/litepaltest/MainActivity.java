package example.com.litepaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createDatabase=(Button)findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LitePal.getDatabase();
            }
        });
        Button addData=(Button)findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book=new Book();
                book.setName("The Da Vinci Code");
                book.setName("Dan Brown");
                book.setAuthor("Dan Brown");
                book.setPrice(16.96);
                book.setPages(454);
                book.save();
            }
        });
            Button updateData=(Button)findViewById(R.id.update_data);
            updateData.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Book book=new Book();
                    book.setPress("Anchor");
                    book.updateAll("name=? and author = ?","The Lost Symbol","Dan Brown");

                }
            });
    }
}
