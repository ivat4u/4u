package example.com.fragmentbestpractice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewsContentAcativity extends AppCompatActivity {
    public static void actionStart(Context context,String newsTitle,String newsContext){
        Intent intent=new Intent(context,NewsContentAcativity.class);
        intent.putExtra("news_title",newsTitle);
        intent.putExtra("news_context",newsContext);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);
        String newsTitle=getIntent().getStringExtra("news_title");
        String newsContent=getIntent().getStringExtra("news_content");
        NewsContentFragment newsContentFragment=(NewsContentFragment)getSupportFragmentManager().
                findFragmentById(R.id.news_content_fragment);
        newsContentFragment.refresh(newsTitle,newsContent);

    }
}
