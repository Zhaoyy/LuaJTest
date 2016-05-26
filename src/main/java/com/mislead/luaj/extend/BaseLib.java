package com.mislead.luaj.extend;

import java.util.Scanner;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaInteger;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;

/**
 * BaseLib by Mislead on 2016/5/26.
 */
public class BaseLib {
  private org.luaj.vm2.lib.BaseLib baseLib;
  private Globals globals;

  public BaseLib(org.luaj.vm2.lib.BaseLib baseLib, Globals globals) {
    this.baseLib = baseLib;
    this.globals = globals;
  }

  public void extend(LuaValue env) {
    env.set("read", new read(baseLib));
  }

  // 简单实现一个io.read的方法
  final class read extends OneArgFunction {
    final org.luaj.vm2.lib.BaseLib baseLib;

    public read(org.luaj.vm2.lib.BaseLib baseLib) {
      this.baseLib = baseLib;
    }

    @Override public LuaValue call(LuaValue arg) {
      Scanner scanner = new Scanner(System.in);
      String result = scanner.nextLine();
      if (arg instanceof LuaString) {
        if (arg.tojstring().replaceAll("\\*", "").toLowerCase().equals("number")) {
          return LuaInteger.valueOf(Long.valueOf(result));
        }
      }
      return LuaString.valueOf(result);
    }
  }
}
