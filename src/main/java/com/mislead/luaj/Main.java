package com.mislead.luaj;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

/**
 * Main by Mislead on 2016/5/26
 */
public class Main {
  private static final String luaScript = "hello.lua";
  private static final String testmath = "testmath.lua";

  public static void main(String[] args) {
    // set lua default path
    System.setProperty("luaj.package.path",
        Object.class.getResource("/lua").getPath() + "/?.lua");

    Globals globals = JsePlatform.debugGlobals();
    //String currentTime = globals.get("luajava")
    //    .get("bindClass")
    //    .call(LuaValue.valueOf("java.lang.System"))
    //    .invokemethod("currentTimeMillis").toString();
    //System.out.println(currentTime);

    //how to run a lua script
    try {
      loadScript(globals, testmath).call();
      LuaValue chunk = loadScript(globals, luaScript);
      chunk.call();
    } catch (Exception e) {
      e.printStackTrace();
    }

    // how to use a lua function in Java.
    //LuaObject object = new LuaObject(globals);
    //globals.load(Object.class.getResourceAsStream("/lua/" + luaScript), "@" + luaScript, "bt",
    //    globals).call();
    //System.out.println("use lua function:" + object.face(4));
  }

  private static LuaValue loadScript(Globals globals, String scriptName) {
    return globals.load(Object.class.getResourceAsStream("/lua/" + scriptName),
        "@" + scriptName, "bt", globals);
  }
}
