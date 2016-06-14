--
-- Created by IntelliJ IDEA.
-- By: Mislead
-- Date: 2016/6/13
-- Time: 10:03
-- To change this template use File | Settings | File Templates.
--
-- use luajava.newInstace to instace a java class
local luaLog = luajava.newInstance("com.mislead.luaj.java_lua.LuaLogTest")
-- use java class methods
luaLog:info("this is info")
luaLog:error("this is error")

-- use luajava.bindClass to bind a class to lua
-- then use luajava.new to instance it
local LuaLog = luajava.bindClass("com.mislead.luaj.java_lua.LuaLogTest")
-- use static java class method & field
LuaLog:staticInfo("info")
print(LuaLog.TAG)
-- instance class
local newLog = luajava.new(LuaLog)
-- use java class method
newLog:info("this is newLog info")
-- a JFrame example
local jframe = luajava.bindClass("javax.swing.JFrame")
local frame = luajava.newInstance("javax.swing.JFrame", "this is text")
frame:setDefaultCloseOperation(jframe.EXIT_ON_CLOSE)
frame:setSize(300, 400)
frame:setVisible(true)

