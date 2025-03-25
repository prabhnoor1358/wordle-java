# Bollywood Movie Guessing Game 🎬🎮

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://java.com)
[![CLI](https://img.shields.io/badge/CLI_Game-4A4A4A?style=for-the-badge&logo=gnu-bash&logoColor=white)](https://en.wikipedia.org/wiki/Command-line_interface)

A console-based movie guessing game inspired by the classic Hangman game with Bollywood twist!

## Features ✨
- 🔠 Letter-by-letter guessing mechanics
- 🎨 Colored console output
- 🎥 Movie title obfuscation with vowels revealed
- ⏳ Animated win/lose screens
- 📊 Game summary with statistics
- ❌ Input validation (prevent duplicate guesses)
- 🔊 Automatic vowel handling

## Prerequisites ⚙️
- Java JDK 11 or newer
- Terminal with ANSI escape code support

## How to Run 🚀
1. Compile all Java files:
```bash
javac *.java
```
2. Run the game:
```bash
java Jan31
```

## Gameplay Instructions 🕹️
1. **Setup**  
   Player 1 enters the movie name (case insensitive)

2. **Guessing**  
   Player 2 tries to guess consonants:
   - Correct guess: Reveals all matching letters
   - Wrong guess: Adds to Bollywood counter
   - 9 wrong guesses = Game Over

3. **Winning**  
   Guess all letters before reaching 9 wrong attempts

## Game Structure 📂
```java
BollywoodGame/
├── Game.java          // Main game logic
├── Jan31.java         // Entry point
└── Color.java         // ANSI color constants (required)
```

## Code Snippets 💻

**Sample Game Flow:**
```
=============
| B*LLY***** |
=============
Word: R**DY *O **AY * ***E ??
Enter your guess: t
```


**Created with ❤️ by Prabhnoor Singh**  

[![GitHub](https://img.shields.io/badge/View_Source-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/prabhnoor25/bollywood-game)
