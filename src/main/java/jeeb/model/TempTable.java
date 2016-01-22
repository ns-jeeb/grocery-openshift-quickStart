package jeeb.model;

import java.util.List;

/**
 * Created by Jeeb on 11/11/2015.
 */
public class TempTable {
    private long mId;
    private String mTitle;
    private String mImagesFolder;


    @Override
    public String toString () {
        return "TempTable{" +
                "mId=" + mId +
                ", mTitle='" + mTitle + '\'' +
                ", mItems=" + mItems +
                '}';
    }
    public void setImagesFolder (String imagesFolder) {
        mImagesFolder = imagesFolder;
    }

    public String getImagesFolder () {
        return mImagesFolder;
    }

    public List<String> getItems () {
        return mItems;
    }

    public void setItems (List<String> items) {
        mItems = items;
    }

    public String getTitle () {
        return mTitle;
    }

    public void setTitle (String title) {
        mTitle = title;
    }

    public long getId () {
        return mId;
    }

    public void setId (long id) {
        mId = id;
    }

    private List<String> mItems;
}
