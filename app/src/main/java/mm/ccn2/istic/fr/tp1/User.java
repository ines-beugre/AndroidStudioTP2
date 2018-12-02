package mm.ccn2.istic.fr.tp1;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String lastname;
    private String firstname;
    private String birthday;
    private String birthcity;

    public User(String lastname, String firstname, String birthday, String birthcity) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.birthday = birthday;
        this.birthcity = birthcity;
    }

    protected User(Parcel in) {
        lastname = in.readString();
        firstname = in.readString();
        birthday = in.readString();
        birthcity = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(lastname);
        dest.writeString(firstname);
        dest.writeString(birthday);
        dest.writeString(birthcity);
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getBirthcity() {
        return birthcity;
    }

}
