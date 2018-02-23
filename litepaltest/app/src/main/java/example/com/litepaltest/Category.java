package example.com.litepaltest;

import org.litepal.crud.DataSupport;

/**
 * Created by hasee on 2018/1/14.
 */

public class Category extends DataSupport{
    private int id;
    private String categoryName;
    private  int categoryCode;

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}