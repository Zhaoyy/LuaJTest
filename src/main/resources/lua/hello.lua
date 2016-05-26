function face(n)
    if n == 0 then
        return 1
    else
        return n * face(n - 1)
    end
end

print('please enter a number')
num = read("*number")
print(num)
print(face(num))

print("hello, lua")

local t = {}
function t.r(...)
    print(...)
end

_G["rrr"] = t.r

rrr(1, 2, 3)
rrr(1, 2, 3, 4)

