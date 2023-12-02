import re 
import sys 

file = open(sys.argv[1])

idCounter = 0
sumPossible = 0

gamePresetColors = ["red","green","blue"]
gamePresetCount = [12,13,14]

for line in file:
    error = False
    idCounter += 1
    splitLine = line.split(":")
    splitResult = splitLine[1].split(";")
    gameParted = []

    for game in splitResult:
        pairs = [pair.strip().split() for pair in game.split(",")]
        gameParted.append([(parts[0], parts[1]) for parts in pairs])

    for game in gameParted:
        for pair in game: 
            for i, color in enumerate(gamePresetColors):
                if pair[1] == color:
                    numCol = int(pair[0])
                    if numCol > gamePresetCount[i]:
                        error = True
                        print(f"Error! IS: ({numCol}) Preset:({gamePresetCount[i]}) |id:{idCounter} | Game: {pair}")
                        break
                    else:
                        print(f"Correct! IS:({numCol}) Preset:({gamePresetCount[i]}) |id:{idCounter}| Game: {pair}")

    if not error:
        print("Possible game")
        sumPossible += idCounter

print("Sum Possible IDs", sumPossible)



