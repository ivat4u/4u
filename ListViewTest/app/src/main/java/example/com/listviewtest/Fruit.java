package example.com.listviewtest;

/**
 * Created by hasee on 2017/8/15.
 */

public class Fruit {
    private String name;
    private int imageId;
    public Fruit(String Name,int ImageId){
        this.name=Name;
        this.imageId=ImageId;
    }
    public String getName(){
        return  name;
    }
    public int getImageId(){
        return  imageId;
    }
}
