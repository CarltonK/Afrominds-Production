package handler;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.afrominds.Switcher;

import java.util.HashMap;

/**
 * Created by Mark Carlton on 08/09/2017.
 */

public class SessionManager {

    // Shared Preferences
    private final SharedPreferences pref;

    // Editor for Shared preferences
    private final SharedPreferences.Editor editor;

    // Context
    private final Context _context;

    // Shared pref mode
    private final int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "Afrominds";


    // All Shared Preferences Keys
    private static final String IS_LOGIN = Constants.IS_LOGGED_IN;

    public static final String KEY_FNAME = "f_name";
    public static final String KEY_LNAME = "l_name";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PHONE = "phone";
    public static  final String KEY_NATID = "natId";
    public static final String KEY_STUDENT = "student_id";
    public static final String TAG_TOKEN = "tagtoken";




    // Constructor
    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }



    public void createLoginSession(String f_name, String l_name, String phone,
                                   String email, String natid, String stu_id){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);
        // Storing name in pref
        editor.putString(KEY_FNAME, f_name);
        editor.putString(KEY_LNAME, l_name);
        editor.putString(KEY_PHONE, phone);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_NATID, natid);
        editor.putString(KEY_STUDENT, stu_id);
        // commit changes
        editor.commit();
    }

    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<>();
        user.put(KEY_FNAME, pref.getString(KEY_FNAME, null));
        user.put(KEY_LNAME, pref.getString(KEY_LNAME, null));
        user.put(KEY_STUDENT, pref.getString(KEY_STUDENT, null));
        user.put(KEY_NATID, pref.getString(KEY_NATID, null));
        user.put(KEY_PHONE, pref.getString(KEY_PHONE, null));
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));

        // return user
        return user;
    }


    public boolean saveDeviceToken(String token){
        editor.putString(TAG_TOKEN, token);
        editor.commit();
        return true;
    }

    //this method will fetch the device token from shared preferences
    public HashMap<String, String> getDeviceToken(){
        HashMap<String, String> token = new HashMap<>();
        token.put(TAG_TOKEN, pref.getString(TAG_TOKEN, null));
        return token;
    }


    public void checkLogin(){
        // Check login status
        if(!this.isLoggedIn()){
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, Switcher.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context.startActivity(i);
        }

    }

    /**
     * Clear session details
     * */
    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(_context, Switcher.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context.startActivity(i);
    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
}
