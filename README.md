# Tic Tac Toe JavaFX

> A desktop Tic Tac Toe game for two local players, built with JavaFX.

## Overview

Tic Tac Toe JavaFX is a small desktop application that lets two players
alternate turns on a 3x3 board. The application displays the current player,
detects wins and draws, disables the board when a game ends, and allows a new
game to be started with the **RESTART** button.

## Features

- Local two-player gameplay for X and O
- Automatic win detection across rows, columns, and diagonals
- Automatic draw detection
- Current-player and game-result display
- Restart button for starting a new game
- JavaFX styling through a CSS stylesheet

## Tech Stack

| Component | Technology |
|---|---|
| Language | Java 21 |
| UI framework | JavaFX 21.0.2 |
| Build tool | Maven |
| Styling | JavaFX CSS |
| Testing framework | JUnit Jupiter 5.10.2 |

## Architecture

The application uses a compact JavaFX structure:

- `main.Main` extends `Application` and owns the board state, turn
  handling, win/draw detection, and event handlers.
- `style.css` defines the visual styles for the board, status label, and
  restart button.
- Maven manages Java compilation, JavaFX dependencies, and application
  execution through the JavaFX Maven Plugin.

## Requirements

- JDK 21 or newer
- Maven 3.9 or newer

JavaFX is resolved automatically by Maven from the project dependencies, so a
separate JavaFX SDK installation is not required for the Maven workflow.

## Installation

Clone the repository and enter its directory:

```bash
git clone https://github.com/OthmaneCHAOUI/TicTacToe-javafx.git
cd TicTacToe-javafx
```

## Usage

Start the application with Maven:

```bash
mvn javafx:run
```

Then:

1. Select an empty cell to place the current player's mark.
2. Continue taking turns until a player wins or the board is full.
3. Select **RESTART** to clear the board and begin again.

## Testing

Run the Maven verification command:

```bash
mvn test
```

The project currently contains no automated game-logic test classes. This
command still verifies that the project compiles and that the configured test
phase completes successfully.

## Project Structure

```text
.
├── pom.xml
├── src/
│   └── main/
│       ├── java/
│       │   ├── main/Main.java
│       │   └── style/style.css
└── README.md
```

## Limitations

- The game supports local two-player play only.
- There is no computer opponent, score history, persistence, or network
  multiplayer.
- The game board is fixed at 3x3.
- There are currently no automated tests for the game logic.

## Roadmap

- [ ] Add automated tests for win, draw, and reset behavior
- [ ] Add a single-player mode with a computer opponent
- [ ] Add score tracking across rounds
- [ ] Add a packaged desktop distribution

## Contributing

Contributions, bug reports, and suggestions are welcome.

1. Fork the repository.
2. Create a branch for your changes.
3. Make and test your changes.
4. Commit your work with a descriptive message.
5. Open a pull request describing the changes.

If a `CONTRIBUTING.md` file is added later, refer to it for detailed contribution guidelines.

## License

See the [LICENSE](LICENSE) file for the project's reuse, modification, and distribution terms.
