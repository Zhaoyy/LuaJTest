package com.mislead.luaj.java_lua;

/**
 * LuaLogTest by Mislead on 2016/6/13.
 */
public class LuaLogTest {

  public static String TAG = LuaLogTest.class.getSimpleName();

  public static void staticInfo(String msg) {
    System.out.println(String.format("static info: %s", msg));
  }

  public void info(String msg) {
    System.out.println(msg);
  }

  public void error(String msg) {
    System.err.println(msg);
  }
}
