package jeeb.model;

import java.util.Date;

/**
 * Created by Jeeb on 10/27/2015.
 */
public class User {

    private String mName;
    private String mEmail;
    private String mPassword;
    private Date mDatepicker;

    public Date getDatepicker () {
        return mDatepicker;
    }

    public void setDatepicker (Date datepicker) {
        mDatepicker = datepicker;
    }

    public String getName () {
        return mName;
    }

    public void setName (String name) {
        mName = name;
    }

    public String getEmail () {
        return mEmail;
    }

    public void setEmail (String email) {
        mEmail = email;
    }

    public String getPassword () {
        return mPassword;
    }

    public void setPassword (String password) {
        mPassword = password;
    }
}
