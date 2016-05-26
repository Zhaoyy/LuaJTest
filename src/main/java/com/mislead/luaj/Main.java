package com.mislead.luaj;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

/**
 * Main by Mislead on 2016/5/26
 */
public class Main {
  private static final String luaScript = "hello.lua";

  public static void main(String[] args) {
    Globals globals = JsePlatform.debugGlobals();
    try {
      LuaValue chunk =
          globals.load(Object.class.getResourceAsStream("/lua/" + luaScript),
              "@" + luaScript, "bt", globals);
      chunk.call();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
