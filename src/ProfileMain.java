import java.util.Arrays;

/**
 * Test Class for Profile
 * @author Neil Woodhouse - 851182
 */
public class ProfileMain {
    public static void main(String[] args) {
        String[] profile1Interests = {"Holistic Investigation", "Reading", "coding"};
        String[] profile1Activities = {"Defeating Alien Invasions", ""};

        Profile profile1 = new Profile("Knott", "Ronan", 13, 4, 1982,
                "r.knott@swansea.ac.uk", profile1Interests, profile1Activities);

        String[] profile2Interests = {"Stargazing", "Photonic Anti-telephone"};
        String[] profile2Activities = {"D&D", "Transforming into a toaster"};
        Profile profile2 = new Profile("Tanner", "David", 1, 1, 2001,
                "1@1.com", profile2Interests, profile2Activities);

        //Test Setting Friends
        profile1.addFriend(profile2);
        System.out.println(profile1);

        //Test Getters
        System.out.println("Profile 1 First Name: " + profile1.getFirstName());
        System.out.println("Profile 1 Last Name: " + profile1.getLastName());
        System.out.printf("Profile 1 Birth day, month, year: %d, %d, %d",
                profile1.getBirthDay(), profile1.getBirthMonth(), profile1.getBirthYear());
        System.out.println("Profile 1 Date of Birth: " + profile1.getDateOfBirth());
        System.out.println("Profile 1 Email Address: " + profile1.getEmailAddress());
        System.out.println("Profile 1 Interests: " + Arrays.toString(profile1.getInterests()));
        System.out.println("Profile 1 Activities: " + Arrays.toString(profile1.getActivities()));

        //Test Friend references
        System.out.println("Profile 1 Num. Friends: " + profile1.getFriend(0));
        System.out.println("Profile 2 Num. Friends: " + profile1.getFriend(0).numOfFriends());

        //Test Setters
        System.out.println(profile2);
        profile2.setLastName("Name");
        profile2.setFirstName("New");
        profile2.setBirthMonth(2);
        profile2.setBirthDay(2);
        profile2.setBirthYear(1907);
        System.out.println(profile2);
    }
}
