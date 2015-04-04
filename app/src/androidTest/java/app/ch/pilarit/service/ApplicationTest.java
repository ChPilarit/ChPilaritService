package app.ch.pilarit.service;

import android.app.Application;
import android.test.ApplicationTestCase;

import java.util.HashMap;
import java.util.Map;

import app.ch.pilarit.service.authen.AuthenLocal;
import app.ch.pilarit.service.session.SessionLocal;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        SessionLocal sessionLocal = AuthenLocal.login(getSystemContext(), "toomtam", "12345");
        assertTrue(sessionLocal.hasSession());

        sessionLocal.clear();

        sessionLocal = AuthenLocal.login(getSystemContext(), "toomtam", "123456");
        assertNull(sessionLocal);
    }
}