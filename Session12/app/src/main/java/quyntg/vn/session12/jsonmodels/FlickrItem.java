package quyntg.vn.session12.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by giaqu on 10/13/2016.
 */
public class FlickrItem {
    @SerializedName("title") private String title;
    @SerializedName("dateTaken") private String dateTaken;
    @SerializedName("media") private Media media;

    public String getImageLink(){
        return media.getLink();
    }

    public class Media{
        @SerializedName("m") private String link;

        public String getLink(){
            return link;
        }
    }

    @Override
    public String toString() {
        return getImageLink();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(String dateTaken) {
        this.dateTaken = dateTaken;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }
}
