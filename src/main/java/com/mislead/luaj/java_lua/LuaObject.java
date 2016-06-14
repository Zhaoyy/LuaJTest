package com.mislead.luaj.java_lua;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;

/**
 * LuaObject by Mislead on 2016/5/27.
 */
public class LuaObject {
  private Globals globals;

  public LuaObject(Globals globals) {
    this.globals = globals;
  }

  public int face(int num) {
    LuaValue func = globals.get("face");

    if (!func.isnil()) {
      try {
        return func.call(CoerceJavaToLua.coerce(num)).toint();
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      System.out.println("func not found");
    }
    return 0;
  }
}
