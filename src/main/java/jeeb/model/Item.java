package jeeb.model;

import java.util.List;

/**
 * Created by Jeeb on 11/12/2015.
 */
public class Item {
    private boolean mIsChecked;

    public boolean isChecked () {
        return mIsChecked;
    }

    public void setIsChecked (boolean isChecked) {
        mIsChecked = isChecked;
    }

    private List<String> mAnimalName;

    public List<String> getAnimalName () {
        return mAnimalName;
    }

    public void setAnimalName (List<String> animalName) {
        mAnimalName = animalName;
    }

    private List<String> mPartName;

    public List<String> getPartName () {
        return mPartName;
    }

    public void setPartName (List<String> partName) {
        mPartName = partName;
    }


}
