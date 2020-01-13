# Tennis Kata

The goal of this kata is to design a tennis match between two players.

The model of this kata was developed by using the TDD approach.


## Problem statement

The program must allow points to be won by one of the 2 players and to determine :

    1) The score,

    2) The status of the current game (0-0, 15-0, .., Deuce, Advantage),

    3) The status of the game (in Progress, player 1 wins, player 2 wins)
    
according to the format below:


```bash
Example 1 :
    Player  1 :  nom du joueur1
    Player  2 : nom du joueur2
    Score : (6 -1) (7-5) (1-0)
    Current game status : 15-30
    Match Status : in progress
```

```bash
Example 2
    Player  1 :  nom du joueur1
    Player  2 : nom du joueur2
    Score : (6 -1) (7-5) (0-0)
    Current game status : deuce
    Match Status : in progress
```

```bash
Example 3
    Player  1 :  nom du joueur1
    Player  2 : nom du joueur2
    Score : (6 -1) (7-5) (0-0)
    Current game status : advantage
    Match Status : in progress
```

```bash
Example 4
    Player 1 :  nom du joueur1
    Player 2 : nom du joueur2
    Score : (6 -1) (7-5) (6-0)
    Match Status : Player1 wins
```

```bash
Example 5
    Player 1 :  nom du joueur1
    Player 2 : nom du joueur2
    Score : (6 -1) (7-5) (2-6) (6-7) (4-6)
    Match Status : Player 2 wins
```