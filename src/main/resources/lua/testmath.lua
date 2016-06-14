--
-- Created by IntelliJ IDEA.
-- By: Mislead
-- Date: 2016/6/13
-- Time: 15:52
-- To change this template use File | Settings | File Templates.
--

print("this is testmath start line")

local function add(a, b)
    if not (tonumber(a) and tonumber(b)) then
        error("param not number")
    end
    return a + b
end

testmath = {
    add = add,
}

return testmath

