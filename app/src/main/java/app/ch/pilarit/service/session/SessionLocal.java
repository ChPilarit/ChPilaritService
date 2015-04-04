package app.ch.pilarit.service.session;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ch_pilarit on 4/2/15 AD.
 */
public class SessionLocal {

    public final static String SP_USER_INFO = "SP_USER_INFO";
    public final static String SESSION_ID = "abcdefg";

    private static SessionLocal instance;
    private static Context context;
    private SharedPreferences sharedPreferences;

    private SessionLocal(Context context) {
        if(context == null){
            instance = null;
            return;
        }

        this.context = context;
        sharedPreferences = context.getSharedPreferences(SP_USER_INFO, Context.MODE_PRIVATE);
    }

    public static SessionLocal getInstance(Context context) {
        if(instance == null || SessionLocal.context == null){
            instance = new SessionLocal(context);
        }
        return instance;
    }

    public void put(String key, Object value){
        if(value == null) value = "";
        sharedPreferences.edit().putString(key, String.valueOf(value)).commit();
    }

    public Object get(String key){
        if(key == null) return "";
        return sharedPreferences.getString(key, "");
    }

    public boolean hasKey(String key) {
        return sharedPreferences.contains(key);
    }

    public void clear(){
        sharedPreferences.edit().remove("sessionid").commit();
    }

    public void createSession() {
        put("sessionid", SESSION_ID);
    }

    public boolean hasSession() {
        return sharedPreferences.contains("sessionid") && SESSION_ID.equals(get("sessionid"));
    }


}
