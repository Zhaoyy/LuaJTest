package com.mislead.luaj.extend;

import java.util.Scanner;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.ZeroArgFunction;

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

  // implements a read method to read the input line from console.
  final class read extends ZeroArgFunction {
    final org.luaj.vm2.lib.BaseLib baseLib;

    public read(org.luaj.vm2.lib.BaseLib baseLib) {
      this.baseLib = baseLib;
    }

    @Override public LuaValue call() {
      Scanner scanner = new Scanner(System.in);
      String result = scanner.nextLine();
      return LuaString.valueOf(result);
    }
  }
}
