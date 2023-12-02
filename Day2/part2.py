import re 
import sys 

file = open(sys.argv[1])


total = 0


for line in file:
    splitLine = line.split(":")
    splitResult = splitLine[1].split(";")
    gameParted = []

    for game in splitResult:
        pairs = [pair.strip().split() for pair in game.split(",")]
        gameParted.append([(parts[0], parts[1]) for parts in pairs])

    gamePresetColors = ["red","green","blue"]
    gamePresetCount = [0,0,0]    

    for game in gameParted:
        for pair in game: 
            for i, color in enumerate(gamePresetColors):
                if pair[1] == color:
                    numCol = int(pair[0])
                    if numCol > gamePresetCount[i]:
                        gamePresetCount[i] = numCol
                        
    total += gamePresetCount[0] * gamePresetCount[1] * gamePresetCount[2]
    

print("Sum: ", total)
