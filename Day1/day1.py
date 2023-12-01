import sys
import re 

file = open(sys.argv[1])
total = 0

for line in file: 
    for char in line:
        if char.isdigit():
            total += 10 * int(char)
            break

    for char in line[::-1]:
        if char.isdigit():
            total += int(char)
            break

print('Answer:', total)


