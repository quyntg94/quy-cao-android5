package quyntg.vn.layout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by giaqu on 10/3/2016.
 */
public class NewsItem {

    public static List<NewsItem> newsItems;

    private String title;
    private int image;
    private String time;

    public NewsItem(String title, int image, String time) {
        this.title = title;
        this.image = image;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public static List<NewsItem> getNewsItems() {
        if(newsItems == null){
            newsItems = new ArrayList<NewsItem>();
            newsItems.add(new NewsItem("He may act like he wants a secretary but most of the time they're looking for...", R.drawable.item1, "10min"));
            newsItems.add(new NewsItem("Peggy, just think about it. Deeply. Then forget it. And an idea will jump up on your face", R.drawable.item2, "13min"));
            newsItems.add(new NewsItem("Go home, take a paper bag and cut some eyeholes out of it. Put it over your head", R.drawable.item3, "16min"));
            newsItems.add(new NewsItem("Get out of here and move forward. This never happened. It will shock you how much", R.drawable.item4, "19min"));
            newsItems.add(new NewsItem("That poor girl. She doesn’t know that loving you is the worst way to get you", R.drawable.item5, "22min"));
        }
        return newsItems;
    }
}
