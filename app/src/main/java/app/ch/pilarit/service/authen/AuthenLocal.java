package app.ch.pilarit.service.authen;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

import app.ch.pilarit.service.session.SessionLocal;

/**
 * Created by ch_pilarit on 4/2/15 AD.
 */
public class AuthenLocal {


    private static SessionLocal sessionLocal;

    public static boolean hasRegister(Context context) {
        sessionLocal = SessionLocal.getInstance(context);
        String usernameInit = String.valueOf(sessionLocal.get("username"));
        String passwordInit = String.valueOf(sessionLocal.get("password"));

        if(usernameInit.length() > 0 && passwordInit.length() > 0){
            return true;
        }

        return false;
    }


    public static SessionLocal register(Context context, Map map) {

        if(map == null) return null;

        sessionLocal = SessionLocal.getInstance(context);

        for(Object key : map.keySet()){
            sessionLocal.put(String.valueOf(key), map.get(key));
        }

        return  sessionLocal;
    }

    public static SessionLocal login(Context context, String username, String password) {

        sessionLocal = SessionLocal.getInstance(context);

        String usernameInit = String.valueOf(sessionLocal.get("username"));
        String passwordInit = String.valueOf(sessionLocal.get("password"));

        if(usernameInit.equals(username) && passwordInit.equals(password)){
            sessionLocal.createSession();
            return  sessionLocal;
        }

        return null;
    }

    public static SessionLocal login(Context context, String password) {

        sessionLocal = SessionLocal.getInstance(context);

        String passwordInit = String.valueOf(sessionLocal.get("password"));

        if(passwordInit.equals(password)){
            sessionLocal.createSession();
            return  sessionLocal;
        }

        return null;
    }

    public static SessionLocal logout(Context context) {

        sessionLocal = SessionLocal.getInstance(context);
        sessionLocal.clear();

        return  sessionLocal;
    }
}
