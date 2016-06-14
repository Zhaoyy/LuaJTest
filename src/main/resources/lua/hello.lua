-- full class name is needed here, don't forget package name
require "com.mislead.luaj.java_lua.myadd"
-- package name is not needed here

print("myadd", myadd) -- print library
print("myadd.add", myadd.add) -- print library method
print("myadd.add(1,2)=", myadd.add(1, 2)) -- print result


require("testmath")
print(testmath.add(3, 4))

function face(n)
    if (n == nil) or (n == 0) then
        return 1
    else
        return n * face(n - 1)
    end
end

--print('please enter a number')
--num = tonumber(read())
--print(num)
--print(face(num))

function getCount()
    print("get count")
    return 6
end

for i = 1, getCount() do
    print(i)
end

print("hello, lua")

local t = {}
function t.r(...)
    print(...)
end

_G["rrr"] = t.r

rrr(1, 2, 3)
rrr(1, 2, 3, 4)

