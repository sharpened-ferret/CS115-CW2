import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * This class allows the creation of profiles, containing a person's first and last names, email address,
 * date of birth, interests, activities, and friends.
 * @author Neil Woodhouse - 851182
 */
public class Profile {

    private String lastName;
    private String firstName;
    private int birthDay, birthMonth, birthYear;
    private String emailAddress;
    private String[] interests;
    private String[] activities;
    private ArrayList<Profile> friends;

    /**
     * Constructor for new profiles
     * @param lastName the last name for the profile
     * @param firstName the first name for the profile
     * @param birthDay the day of birth for the profile
     * @param birthMonth the month of birth for the profile
     * @param birthYear the year of birth for the profile
     * @param emailAddress the email address for the profile
     * @param interests a list of interests
     * @param activities a list of activities
     */
    public Profile(String lastName, String firstName, int birthDay, int birthMonth, int birthYear,
                   String emailAddress, String[] interests, String[] activities) {

        friends = new ArrayList<>();
        setLastName(lastName);
        setFirstName(firstName);
        setBirthYear(birthYear);
        setBirthMonth(birthMonth);
        setBirthDay(birthDay);
        setEmailAddress(emailAddress);
        setInterests(interests);
        setActivities(activities);
    }

    /**
     * @return the last name for the profile
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the last name for the profile
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the day of birth
     */
    public int getBirthDay() {
        return birthDay;
    }

    /**
     * @return the month of birth
     */
    public int getBirthMonth() {
        return birthMonth;
    }

    /**
     * @return the year of birth
     */
    public int getBirthYear() {
        return birthYear;
    }

    /**
     * @return the date of birth ( d/m/y format )
     */
    public String getDateOfBirth() {
        return String.format("%d/%d/%d", birthDay, birthMonth, birthYear);
    }

    /**
     * @return the email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @return the list of interests
     */
    public String[] getInterests() {
        return interests;
    }

    /**
     * @return the list of activities
     */
    public String[] getActivities() {
        return activities;
    }

    /**
     * @param lastName the profile's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @param firstName the profile's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param birthDay the profile's day of birth
     */
    public void setBirthDay(int birthDay) {
        if (birthDay <= 31 && birthDay > 0) {
            this.birthDay = birthDay;
        }
        else {
            throw new IllegalArgumentException("Invalid Birth Day");
        }
    }

    /**
     * @param birthMonth the profile's month of birth
     */
    public void setBirthMonth(int birthMonth) {
        if (birthMonth <= 12 && birthMonth > 0) {
            this.birthMonth = birthMonth;
        }
        else {
            throw new IllegalArgumentException("Invalid Birth Month");
        }
    }

    /**
     * @param birthYear the profile's year of birth
     */
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    /**
     * @param emailAddress the profile's email address
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @param interests a list of interests
     */
    public void setInterests(String[] interests) {
        this.interests = interests;
    }

    /**
     * @param activities a list of activities
     */
    public void setActivities(String[] activities) {
        this.activities = activities;
    }

    /**
     * @param p adds a new friend to the profile's friends list
     */
    public void addFriend(Profile p) {
        friends.add(p);
    }

    /**
     * @param i the number of the friend to fetch from friends list
     * @return the profile for the specified friend from the friends list
     */
    public Profile getFriend(int i) {
        return friends.get(i);
    }

    /**
     * @return the number of friends for this profile
     */
    public int numOfFriends() {
        return friends.size();
    }

    public boolean hasFriend(Profile p) {
        if (friends.contains(p)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * toString method for testing
     * @return a formatted string containing data about the profile
     */
    @Override
    public String toString() {
        String friendsListOut = "";
        for (Profile friend : friends) {
            friendsListOut += String.format("%s %s, ", friend.getFirstName(), friend.getLastName());
        }
        return "Profile{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthDay=" + birthDay +
                ", birthMonth=" + birthMonth +
                ", birthYear=" + birthYear +
                ", emailAddress='" + emailAddress + '\'' +
                ", interests=" + Arrays.toString(interests) +
                ", activities=" + Arrays.toString(activities) +
                ", friends=" + friendsListOut +
                '}';
    }

    /**
     * @param o object to compare against
     * @return true if the input is equal to this Profile object, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Profile profile = (Profile) o;
        return getBirthDay() == profile.getBirthDay() &&
                getBirthMonth() == profile.getBirthMonth() &&
                getBirthYear() == profile.getBirthYear() &&
                getLastName().equals(profile.getLastName()) &&
                getFirstName().equals(profile.getFirstName()) &&
                getEmailAddress().equals(profile.getEmailAddress()) &&
                Arrays.equals(getInterests(), profile.getInterests()) &&
                Arrays.equals(getActivities(), profile.getActivities()) &&
                Objects.equals(friends, profile.friends);
    }
}
