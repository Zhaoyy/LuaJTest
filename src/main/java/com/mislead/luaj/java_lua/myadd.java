package com.mislead.luaj.java_lua;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.TwoArgFunction;

/**
 * myadd by Mislead on 2016/6/13.
 */
// When require() is called, it will first attempt to load the module as a Java class that implements LuaFunction.
// To succeed, the following requirements must be met:
// 1)The class must be on the class path with name, modname.
// 2)The class must have a public default constructor.
// 3)The class must inherit from LuaFunction.

public class myadd extends TwoArgFunction {
  // 这个必须有
  public myadd() {
  }

  // 注册库
  @Override public LuaValue call(LuaValue modName, LuaValue env) {
    LuaValue library = tableOf();
    library.set("add", new add());
    env.set("myadd", library);
    return library;
  }

  // 库方法实现
  static class add extends TwoArgFunction {

    @Override public LuaValue call(LuaValue arg1, LuaValue arg2) {
      assert (arg1.isnumber());
      assert (arg2.isnumber());
      return LuaValue.valueOf(arg1.todouble() + arg2.todouble());
    }
  }
}
