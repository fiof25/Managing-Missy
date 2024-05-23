/*
=======================================================================================================================
Summative Program: Managing Missy
Version: SummativeJan2024Final - With Extensions
Author: Fiona Fang
Date: Jan 19, 2023
Java Programming
=======================================================================================================================
-------PROBLEM DEFINITION------
In this program, the player's goal is to find Missy the dog before the dog-catchers catch her. She is hidden in a
grid, and each time the player moves, she moves randomly 0-3 spaces. The goal is to find her and bring her to safety
back to the starting point in the least amount of moves without being caught by the hunter or falling into a pitfall.


--------INPUT-------
User's Name
User's Move or Enter Settings Menu
   "W" for Up
   "A" for Left
   "S" for Down
   "D" for Right
   "M" for Menu


User Choice for Menu Options
   If user wants to cheat
   If user wants to win
   if user wants to give up
   If user wants to go back to game
   If user wants a hint
User Choice to Play Again ("y" or "n")


User Vs Missy Battle Move
   Rock, paper or scissors


--------OUTPUT-------
Display of Game Rules
   Game Objective and Rules
   Game Icon Legend
   Point System
   Controls


Number of Moves Made
Number of Hints Used
Penalty Points Accumulated
Time elapsed


Menu Options to Prompt User


Error Proofing
   Out of Bounds
   Invalid Input


Messages to Hint and Update User
   If Missy is within 4 moves
   If Missy is within 2 moves
   If Missy is already found
   Hint: Missy is _ moves away from the user


Game Grid
   Borders
   Coordinates (Letters + Numbers)
   Starting Icon
   Current User Position
   User Icon to change if Missy is caught or not
   Areas Already Searched
   Missy's Position (if cheat is on)
   Position of Pitfalls (if cheat is on)
   Empty Space for Hidden Areas


Winning/Losing Message
Prompt User to Play Again


-----PROCESSING-----
Calculates Number of Moves Required for User to Reach Missy
Take absolute value of (Missy's X-Coordinate - User's X-Coordinate)
- Take absolute value of (Missy's Y-Coordinate - User's Y-Coordinate)
- Add the two values together to represent the number of moves the user is away from Missy


Checks for Out of Bounds
- for both missy and users, checks if their position is less or more han the border index
- position remains the same if the x/y value is out of bounds


Move User
- Processes user input to move 1 square up,down,left or right depending on the input
- Adds or subtracts from position X or position Y


Move Missy
- Generates a random number from 1-4
- Moves randomly 1 square up, down, right or left depending on the number generated


Check for Missy Caught
- checks the condition for if the user and missy lands on the same square (has the same x and y coordinates)


Check for Win
- checks the condition if missy is caught and if the user's position is at the starting index


Path Searched
- everytime user lands on a square, the x and y coordinates are changed the true in a seperate 2d array
- Overwrites the searched path for each turn
- Checks if missy is on the searched path. if true, make missy visible


Calculate Penalty Points
- Add HINT_PENALTY to pointsCounter for each Hint Used
- Add MOVE_PENALTY to pointsCounter for each Move Used
- Add PITFALL_PENALTY to pointsCounter for each Pitfall Landed
- Add LOST_PENALTY to pointsCounter for each battle with Missy lost
- Calculate and display for each turn and after game is completed

Leaderboard
- Use Bubble Sorting to list penalty points from lowest to highest


=======================================================================================================================
----------LIST OF VARIABLES----------
user (String)
- represents the user icon to be displayed and moved throughout the game grid.
- is assigned to be changed depending on if missy is caught


missy (String)
- represents the missy icon to be displayed and moved throughout the game grid.
- set to hidden default and set to visible if cheat mode is on


hunter (String)
- represents the hunter icon to be displayed and moved throughout the game grid.
- set to hidden default and set to visible if cheat mode is on


grid (String) (2D array)
- set to the size by size square grid as a 2d array
- represents the game grid that stores the position of missy, the user and searched area


pathSearched (boolean) (2D array)
- set to the size by size square grid as a 2d array
- represents the path that user already searched as a true or false value


pitfalls (boolean) (2D array)
- set to the size by size square grid as a 2d array
- represents coordinates on the grid with pitfalls


hunters (boolean) (2D array)
- set to the size by size square grid as a 2d array
- represents coordinates on the grid with hunters


updatedCharPosition (int) (1D array)
- represents and used to store user's updated x and y position passed through the method


updatedMissyPosition (int) (1D array)
- represents and used to store missy's updated x and y position passed through the method


name (String)
- represents and stores each user's name to be used throughout the program


controlInput (String)
- represents stores the direction the user would like to move
- used as a condition to compute user movement


menuInput (int)
- represents and stores the number inputted by the user
- checked to determine which menu option is to be processed


charPosX (int)
- represents and stores current x value of the user's position
- set to new position with each valid move update


charPosY (int)
- represents and stores current y value of the user's position
- set to new position with each valid move update


newCharPosX (int)
- represents and stores new x value of the user's position that is to be assigned into the current position


newCharPosY (int)
- represents and stores new y value of the user's position that is to be assigned into the current position


randomMissyX (int)
- represents and stores missy's random generated x coordinate to be spawned in at the beginning of the game


randomMissyY (int)
- represents and stores missy's random generated y coordinate to be spawned in at the beginning of the game


missyPosX (int)
- represents and stores current x value of missy's position


missyPosY (int)
- represents and stores current y value of missy's position


isMissyCaught (boolean)
- represents and stores true or false depending if missy is caught yet
- used as a condition of whether to update missy's position, if user wins and other structures


isWin (boolean)
- represents and stores true or false depending on if user has won or not
- used as condition of whether the game is to end and prompts the user to play again or exit


isCheat (boolean)
- represents and stores true or false depending on if user decides to turn on cheat or not
- used as a condition of whether to display missy's location to the user


isPlayAgain (boolean)
- represents and used to store true of false depending on if the user decides to play again or exit
- used as condition for the game loop to repeat itself


distanceMoves (int)
- represents and used to store and compute the variable of the distance of moves between missy and the user


moveCounter (int)
- represents and keeps track of the number of moves/turns made by the user
- used as an counter value that adds 1 with each turn


hintCounter (int)
- represents and keeps track of the number of hints used by the user
- used as a counter value that adds 1 with each turn


pointCounter (int)
- represents and keeps track of the number of penalty points earned by the user
- used as an accumulator value that adds penalty points with each turn


pitfall (String)
- used to store the icon of the pitfall


isLost (boolean)
- stores true or false based on if the user gives up


missy_max_cord (int)
- represents the border and maximum value of where missy can randomly spawn
- makes sure that missy does not spawn beyond the border


pitfall_max (int)
- represents the border and maximum value of where pitfalls can randomly spawn
- makes sure that pitfall does not spawn beyond the border


isPosValid (boolean)
- represents condition of if user position is valid


pitfallCounter (int)
- represents and keeps track of the number of pitfalls the user lands on
- used as an counter value that adds 1 with each turn


seconds (long)
- keeps track of seconds elapsed in the program


isLandedPitfall (boolean)
- stores true or false based on if the user landed on a pitfall before restarting


randomHunterX (int) (1d array)
- stores random x-coordinate of the position of hunters


randomHunterY (int) (1d array)
- stores random y-coordinate of the position of hunters


hunterPosX (int) (1d array)
- stores current x-coordinate of the position of hunters


hunterPosY (int) (1d array)
- stores current y-coordinate of the position of hunters


newHunterPosX (int) (1d array)
- stores updated x-coordinate of the position of hunters


newHunterPosY (int) (1d array)
- stores updated y-coordinate of the position of hunters


updatedHunterPosition (int) (1d array)
- stores updated position of the position of hunters


hunter_max (int)
- represents the border and maximum value of where hunter can randomly spawn
- makes sure that hunter does not spawn beyond the border


isUserWinner (boolean)
- stores true or false based on if the user wins the battle with missy


-------CONSTANTS-------
SIZE (int)
- represents the size of the grid as the length of the side of the square
- represents numbers or rows/columns


START_CORD (int)
- represents the starting coordinate, where the user starts and should end


MISSY_MIN_CORD (int)
- represents the border and minimum value of where missy can randomly spawn
- makes sure that missy does not spawn too close to the user


USER_ICON (String)
- represents the icon of the user when missy is not caught


USER_MISSY (String)
- represents the icon of the user when missy is caught


MISSY_UNHIDDEN (String)
- represents the icon of Missy when unhidden


MISSY_HIDDEN (String)
- represents the icon of Missy when hidden


SEARCHED (String)
- represents the path that the user has already searched


HIDDEN (String)
- represents area that is hidden and unexplored


START (String)
- represents the icon of the starting checkpoint


MENU (String)
- represents the String character that is to be entered to open the menu


MOVE_PENALTY (int)
- represents the number of penalty points that is to be added for each move made by the user


HINT_PENALTY (int)
- represents the number of penalty points that is to be added for each hint used by the user


PITFALL_PENALTY (int)
- represents the number of penalty points that is to be added for each pitfall the user lands on


PITFALL_HIDDEN (String)
- represents the icon of the pitfall when hidden


PITFALL_UNHIDDEN (String)
- represents the icon of the pitfall when unhidden


PITFALL_MIN (int)
- represents the border and minimum value of where pitfall can randomly spawn
- makes sure that pitfall does not spawn too close to the user


HUNTER_HIDDEN (String)
- represents the icon of the hunter when hidden


HUNTER_UNHIDDEN (String)
- represents the icon of the hunter when unhidden


NUM_HUNTERS (int)
- represents the number of hunters in the game


HUNTER_MIN (int)
- represents the border and minimum value of where hunter can randomly spawn
- makes sure that hunter does not spawn too close to the user

LOST_PENALTY (int)
- represents the number of penalty points that is to be added for each battle lost by user


=======================================================================================================================
*/
import java.io.*;
import java.time.Instant;
import java.time.Duration;
import java.util.Scanner;
public class SummativeJan2024Final { //Start of class SummativeJan2024Final
    public static void main (String[] args)throws IOException{
        SummativeJan2024Final fF = new SummativeJan2024Final();//Declaration and instantiation of a SummativeJan2024Final object
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Declaration and instantiation of a BufferedReader object

        //Initialize starting coordinates and limits
        final int SIZE=15;
        final int START_CORD=0;
        final int MISSY_MIN_CORD=5;
        int missy_max_cord=SIZE-1;
        final int PITFALL_MIN=2;
        int pitfall_max=SIZE-1;
        final int HUNTER_MIN=1;
        int hunter_max=SIZE-1;

        //Initialize game icons and characters
        String user = "";
        final String USER_ICON="C";
        final String USER_MISSY="Y";
        String missy = " ";
        final String MISSY_UNHIDDEN="M";
        final String MISSY_HIDDEN=" ";
        String pitfall=" ";
        final String PITFALL_HIDDEN=" ";
        final String PITFALL_UNHIDDEN="p";
        final String SEARCHED="•";
        final String HIDDEN=" ";
        final String START = "S";
        final String MENU = "m";
        String hunter=" ";
        final String HUNTER_UNHIDDEN="h";
        final String HUNTER_HIDDEN=" ";

        //Initialize point system
        final int MOVE_PENALTY=1;
        final int HINT_PENALTY=2;
        final int PITFALL_PENALTY=3;
        final int LOST_PENALTY=5;

        //Initialize arrays for displaying character position and game grid
        String[][]grid=new String[SIZE][SIZE];
        int[] updatedCharPosition;
        int[] updatedMissyPosition;

        String name;
        String controlInput;
        int menuInput;

        //Character position
        int charPosX;
        int charPosY;
        int newCharPosX;
        int newCharPosY;

        //Missy position
        int randomMissyX;
        int randomMissyY;
        int missyPosX;
        int missyPosY;

        //pitfall position
        int numPitfall=SIZE-5;
        int randomPitfallX;
        int randomPitfallY;

        //Checks if conditions are met
        boolean isMissyCaught;
        boolean isWin;
        boolean isLost;
        boolean isCheat;
        boolean isPlayAgain;
        boolean isPosValid;
        boolean isLandedPitfall;
        boolean isUserWinner;

        //hunter position
        final int NUM_HUNTERS=5;
        int[] randomHunterX =new int[NUM_HUNTERS];
        int[] randomHunterY =new int[NUM_HUNTERS];
        int[] hunterPosX =new int[NUM_HUNTERS];
        int[] hunterPosY =new int[NUM_HUNTERS];
        int[] newHunterPosX =new int[NUM_HUNTERS];
        int[] newHunterPosY =new int[NUM_HUNTERS];
        int[] updatedHunterPosition;

        //Variable for detecting whether Missy is close to the player
        int distanceMoves;
        do{

            //Keeps track of moves
            int moveCounter=0;
            int hintCounter=0;
            int pointCounter=0;
            int pitfallCounter=0;
            long seconds=0;
            isLandedPitfall=false;

            //Prints out welcome message and rules
            System.out.println("\n>>> WELCOME TO MANAGING MISSY! <<<\n");
            System.out.println("-------RULES-------");
            System.out.println("Missy the Dog is lost in Unionville High School!");
            System.out.println("Your job is to find her in the least amount of moves possible!");
            System.out.println("- Missy moves 0-3 random spaces (up,down,left,right) with each turn.");
            System.out.println("- There will be hunters that will attempt to stop your search. They move randomly 1 space each turn.");

            //explains legend and icons and what they indicate
            System.out.println("\n-------LEGEND-------");
            System.out.println(START+" : Starting Point");
            System.out.println(USER_ICON+" : User (You)");
            System.out.println(MISSY_UNHIDDEN+" : Missy");
            System.out.println(HUNTER_UNHIDDEN+" : Hunter");
            System.out.println(USER_MISSY+" : User - Indicates Missy FOUND");
            System.out.println(SEARCHED+" : Path Already Explored. ");
            System.out.println("If Missy or a hunter goes on path that is already explored, they will be visible. ");

            //explains point system
            System.out.println("\n-------POINTS-------");
            System.out.println("The point system is Penalty-Based, meaning the lower the penalty points, the better.");
            System.out.println("—> Each Move is +"+MOVE_PENALTY+" Penalty Point");
            System.out.println("—> Each Hint Used is +"+HINT_PENALTY+" Penalty Point");
            System.out.println("—> Each Pitfall Landed on is +"+PITFALL_PENALTY+" Penalty Point");
            System.out.println("—> Each Battle Lost on is +"+LOST_PENALTY+" Penalty Point");
            System.out.println("—> Being Caught By the Hunter is GAME OVER! ");
            System.out.println("Using Cheat or Win does not affect penalty points and should only be used for ethical purposes. ");

            //Print out game controls
            System.out.println("\n-----CONTROLS-----");
            System.out.println("You can only move up, down, left or right 1 space with each turn.");
            System.out.println("Enter 'w' to move up.");
            System.out.println("Enter 'a' to move left.");
            System.out.println("Enter 's' to move right.");
            System.out.println("Enter 'd' to move down.");
            System.out.println("Enter 'm' to enter the menu.");

            //asks user for name
            System.out.println("\n>>> LETS BEGIN! <<<");
            System.out.println("Player, enter your name!");
            name=br.readLine();
            System.out.println("Good luck "+name+"!");

            //start timer
            Instant start=Instant.now();

            while (true){

                //resets game conditions
                boolean[][] pathSearched =new boolean[SIZE][SIZE];
                boolean[][] pitfalls = new boolean [SIZE][SIZE];
                boolean[][] hunters =new boolean[SIZE][SIZE];
                isUserWinner=false;
                isMissyCaught=false;
                isWin=false;
                isCheat=false;
                isLost=false;
                isPosValid=true;

                //Spawns Missy's random position
                randomMissyX=(int)Math.round (Math.random () * (missy_max_cord-MISSY_MIN_CORD))+MISSY_MIN_CORD;
                randomMissyY=(int)Math.round (Math.random () * (missy_max_cord-MISSY_MIN_CORD))+MISSY_MIN_CORD;


                //randomize pitfall location
                for (int x=0;x<numPitfall;x++){
                    randomPitfallX=(int)Math.round(Math.random() * (pitfall_max-PITFALL_MIN))+PITFALL_MIN;
                    randomPitfallY=(int)Math.round(Math.random()*(pitfall_max-PITFALL_MIN))+PITFALL_MIN;
                    pitfalls[randomPitfallX][randomPitfallY]=true;
                }

                //generate random hunter location at the start
                for (int x=0;x<NUM_HUNTERS;x++){
                    randomHunterX[x]=(int)Math.round(Math.random() * (hunter_max-HUNTER_MIN))+HUNTER_MIN;
                    randomHunterY[x]=(int)Math.round(Math.random()*(hunter_max-HUNTER_MIN))+HUNTER_MIN;
                    hunterPosX[x]=randomHunterX[x];
                    hunterPosY[x]=randomHunterY[x];
                    hunters[randomHunterX[x]][randomHunterY[x]]=true;

                }

                //Initializes starting variables and positions for each character
                charPosX=START_CORD;
                charPosY=START_CORD;
                missyPosX=randomMissyX;
                missyPosY=randomMissyY;
                user=USER_ICON;

                //Fills array with space
                for (int x=0;x<grid.length;x++){
                    for (int y=0;y<grid[0].length;y++){
                        grid[x][y]=HIDDEN;
                    }
                }

                //Puts player at the start
                grid[charPosX][charPosY]=user;

                while(true){
                    //Checks if the user won
                    if (charPosX==START_CORD && charPosY==START_CORD && isMissyCaught){
                        isWin=true;
                    }
                    else if (!isMissyCaught && isPosValid){//Checks if Missy is caught. Updates Missy's position if not caught
                        grid[missyPosX][missyPosY]=HIDDEN;
                        if (pathSearched[missyPosX][missyPosY]){
                            grid[missyPosX][missyPosY]=SEARCHED;
                        }
                        updatedMissyPosition = fF.updateMissyPosition(missyPosX,missyPosY, SIZE);
                        missyPosX=updatedMissyPosition[0];
                        missyPosY=updatedMissyPosition[1];
                    }
                    if (charPosX == missyPosX && charPosY == missyPosY) {
                        //initiates battle
                        isUserWinner=fF.battlePhase();
                        if (isUserWinner){
                            isMissyCaught = true;
                            user=USER_MISSY;
                        }else{
                            //restarts
                            pointCounter+=LOST_PENALTY;
                            break;

                        }

                    }

                    //Displays message for if Missy is caught or not
                    if (isMissyCaught){
                        System.out.println("\nYou caught Missy! Now bring her back to the start.");
                    }else{
                        System.out.println("\nFind Missy! She is somewhere in this grid.");
                    }

                    //calculate seconds elapsed
                    Instant end=Instant.now();
                    Duration timeElapsed=Duration.between(start, end);
                    seconds = (int) timeElapsed.getSeconds();

                    //Draws the grid with each move
                    fF.drawGrid(grid,charPosX,charPosY,user,missyPosX,missyPosY,missy,isMissyCaught, moveCounter,
                            MISSY_UNHIDDEN,MISSY_HIDDEN, isCheat,pathSearched,hintCounter,pointCounter,pitfalls,PITFALL_UNHIDDEN,pitfallCounter,
                            NUM_HUNTERS,hunters,HUNTER_UNHIDDEN,START_CORD,START,seconds, hunter,SEARCHED,HUNTER_HIDDEN);

                    //check if hunter catches user
                    for (int x=0;x<NUM_HUNTERS;x++){
                        if (charPosX==hunterPosX[x] && charPosY==hunterPosY[x]){
                            System.out.println("\n"+name+", GAME OVER: You've been stopped by the hunter!");
                            isLost=true;
                            break;
                        }

                    }
                    if (isLost){
                        break;
                    }

                    //Checks for win
                    if (isWin){
                        fF.printWinMessage(name,moveCounter,hintCounter,pointCounter);
                        System.out.println("You finished in "+seconds+" seconds.");
                        fF.leaderboard(name,pointCounter);
                        break;
                    }

                    //Checks if user is close to Missy based on number of moves needed to reach her
                    distanceMoves=fF.findDistance(charPosX,charPosY,missyPosX,missyPosY);
                    if (distanceMoves<=4 && distanceMoves>2 && !isMissyCaught){
                        System.out.println("\nYou are getting warmer! Missy is within 4 moves!");

                    }else if(distanceMoves<=2 && distanceMoves>0 && !isMissyCaught){
                        System.out.println("\nYou are getting hot! Missy is within 2 moves!");


                    }else if(isMissyCaught){
                        System.out.println("\nMissy Found!");

                    }
                    if(isLandedPitfall) {
                        System.out.println("\nUh Oh! You landed in a pitfall. Search Restarted!");
                    }
                    isLandedPitfall=false;

                    //Creates a path for where the user moves and starting checkpoint
                    pathSearched[charPosX][charPosY]=true;
                    for (int x=0;x<SIZE;x++){
                        for (int y=0;y<SIZE;y++){
                            if (pathSearched[x][y]) {
                                grid[charPosX][charPosY] = SEARCHED;
                                break;
                            }
                        }
                    }

                    //Checks if user makes a move or enters menu
                    controlInput = fF.getControl();
                    if (controlInput==MENU){
                        System.out.println("----MENU----");
                        System.out.println("1. Back");
                        System.out.println("2. Cheat");
                        System.out.println("3. Win");
                        System.out.println("4. Give Up");
                        System.out.println("5. Get Hint");
                        menuInput=fF.getMenuInput();

                        //Processes menu options and user input
                        switch(menuInput){
                            case 1:
                                continue;
                            case 2:
                                isCheat=!isCheat;
                                continue;
                            case 3:
                                isWin=true;
                                continue;
                            case 4:
                                System.out.println(name+", GAME OVER: You lost Missy!");
                                isLost=true;
                                break;
                            case 5:
                                if (!isMissyCaught){
                                    hintCounter++;
                                    pointCounter+=HINT_PENALTY;
                                    System.out.print("\nHINT: Missy is "+distanceMoves+" moves away.\n");
                                }
                                else{
                                    System.out.print("\nHINT: Missy is caught already!\n");
                                }

                                continue;
                        }
                        if (menuInput==4){
                            break;
                        }

                    }

                    //Gets user input for each control and movement
                    updatedCharPosition = fF.updatePosition(controlInput,charPosX,charPosY);
                    newCharPosX=updatedCharPosition[0];
                    newCharPosY=updatedCharPosition[1];

                    //Checks if character is out of bounds and makes them try again
                    if (fF.ifPositionValid(newCharPosX,newCharPosY,SIZE)){
                        charPosX=newCharPosX;
                        charPosY=newCharPosY;
                        moveCounter++;
                        pointCounter+=MOVE_PENALTY;
                        isPosValid=true;
                    }
                    else{
                        System.out.print("\nYou cannot go beyond the walls. Please try again.\n");
                        isPosValid=false;
                    }

                    //checks if user is on pitfall. restart if true
                    if (pitfalls[charPosX][charPosY]){
                        isLandedPitfall=true;
                        System.out.println("\nUh Oh! You landed in a pitfall. Search Restarted!");
                        pitfallCounter++;
                        pointCounter+=PITFALL_PENALTY;
                        break;
                    }

                    //updates hunter location
                    if (isPosValid){
                        for (int x=0;x<NUM_HUNTERS;x++){
                            updatedHunterPosition=fF.updateHunterPosition(hunterPosX[x], hunterPosY[x], SIZE);
                            hunters[hunterPosX[x]][hunterPosY[x]]=false;
                            newHunterPosX[x]=updatedHunterPosition[0];
                            newHunterPosY[x]=updatedHunterPosition[1];
                            hunterPosX[x]=newHunterPosX[x];
                            hunterPosY[x]=newHunterPosY[x];
                            hunters[hunterPosX[x]][hunterPosY[x]]=true;
                        }
                    }

                }
                //check if game is over
                if (isWin || isLost){
                    break;
                }

            }
            //prompts user to play again or exit program
            isPlayAgain= fF.isPlayAgain();


        }while(isPlayAgain);

    } //end main method


    /* battlePhase method
            This functional method initiates a battle phase of a game of rock paper scissors

        ---List of Local Variables---
            br = declare BufferedReader() object
            ROCK (String) - represents rock as string
            PAPER (String) - represents paper as string
            SCISSORS (String) - represents scissors as string
            MIN (int) - represents minimum value for generating random number
            MAX (int)- represents maximum value for generating random number
            missyMove (int) - stores value for missy's random move
            userMove (int) - stores value for user's random move
            missyMoveStr (String) - stores string value for missy's random move
            userMoveStr (String) - stores string value for users's random move
            isUserWinner (boolean) - represents if the user is the winner or loser

        @throws IOException
        @parameters
            none

        @return
            true or false (boolean) based result of the game

         */
    public boolean battlePhase()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //initializes values
        final String ROCK="Rock";
        final String SCISSORS="Scissors";
        final String PAPER="Paper";
        final int MIN=1;
        final int MAX=3;
        int missyMove;
        String missyMoveStr="";
        int userMove;
        String userMoveStr="";
        boolean isUserWinner;

        //display starting message
        System.out.println("\n>>> MISSY FOUND! BATTLE PHASE: Rock, Paper, Scissors <<<");
        System.out.println("- Enter '1' for "+ROCK);
        System.out.println("- Enter '2' for "+PAPER);
        System.out.println("- Enter '3' for "+SCISSORS);

        //initializes missy's random move for rock paper scissors
        while (true){
            missyMove=(int)Math.round(Math.random() * (MAX-MIN))+MIN;

            switch(missyMove){
                case 1:
                    missyMoveStr=ROCK;
                    break;
                case 2:
                    missyMoveStr=PAPER;
                    break;
                case 3:
                    missyMoveStr=SCISSORS;
                    break;
            }

            //initiates gameplay and user input
            while (true){
                try{
                    System.out.println("\nEnter your move:");
                    userMove=Integer.parseInt(br.readLine());
                    if (userMove==1 || userMove==2 || userMove==3){
                        break;
                    }else{
                        System.out.println("Please enter a number from 1-3.");
                    }

                }catch(Exception e){
                    System.out.println("Input Invalid. Try again.");
                }

            }
            //checks user's move
            switch(userMove){
                case 1:
                    userMoveStr=ROCK;
                    break;
                case 2:
                    userMoveStr=PAPER;
                    break;
                case 3:
                    userMoveStr=SCISSORS;
                    break;
            }
            System.out.println("Missy chose: "+missyMoveStr);
            System.out.println("You chose: "+userMoveStr);


            //check if win, tie or loss
            if (userMove==missyMove){
                System.out.println("It's a tie! Try again.");
                continue;
            }else if ((userMove==1 && missyMove==3)||(userMove==2 && missyMove==1)||(userMove==3 && missyMove==2)){
                System.out.println("You won the battle!");
                isUserWinner=true;

            }else{
                System.out.println("You lost the battle! Search Restarted!");
                isUserWinner=false;
            }
            return isUserWinner;
        }

    }//end battlePhase method


    /* leaderboard method
            This procedural method writes and sets up the format of the leaderboard as well as read and edit its file

            ---List of Local Variables---
                lB - declare File() object, represents file object of leaderboard file.
                count - declare Scanner() object for counting the number of lines in the leaderboard file
                counter (int) - counter for the number of lines in the leaderboard file
                nameLb (1d array) (String) - array to store player names from the leaderboard file
                scoreLb (1d array) (String) - array to store player scores from the leaderboard file
                lbSize (int) - Counter for the size of the leaderboard
                readFile - declare Scanner() objectfor reading the content of the leaderboard file
                clear - declare PrintWriter() object for clearing the content of the leaderboard file

            @throws IOException
            @parameters
                name (String) - user's name
                pointCounter (int) - penalty points earned

            @return
                none

             */
    public void leaderboard(String name,int pointCounter)throws FileNotFoundException{
        File lB = new File("src/leaderboard.txt");
        Scanner count = new Scanner(lB);
        int counter=1;


        try{
            while(count.hasNext()){//reading through as long as there is info, keep on going
                String txt=count.nextLine();
                counter++; //counts number of lines there are
            }
            count.close(); //close portal to txt file

        }catch(Exception e){

        }

        String[] nameLb=new String[counter];
        nameLb[0]=name;
        int[] scoreLb=new int[counter];
        scoreLb[0]=pointCounter;
        int lbSize=1;

        //opens up scanner to read txt file
        try{
            Scanner readFile = new Scanner(lB);
            while(readFile.hasNext()){//reading through as long as there is info, keep on going
                nameLb[lbSize] = readFile.next();
                scoreLb[lbSize] = readFile.nextInt();
                lbSize++;
            }
            readFile.close(); //close portal to txt file


        }catch(Exception e){

        }

        //sorts from highest to lowest using bubble sorting
        for (int x=0;x<scoreLb.length-1;x++){
            for (int y = 0; y< ((scoreLb.length-1)-x); y++){
                if (scoreLb[y]>scoreLb[y+1]){
                    int temp = scoreLb[y];
                    scoreLb[y] = scoreLb[y+1];
                    scoreLb[y+1] = temp;


                    String tempStr = nameLb[y];
                    nameLb[y] = nameLb[y+1];
                    nameLb[y+1] = tempStr;
                }
            }

        }

        //clears leaderboard
        PrintWriter clear=new PrintWriter(lB);
        clear.print("");
        clear.close();

        //add names and score onto file
        for (int j=0;j<nameLb.length;j++){
            addScore(scoreLb[j],nameLb[j]);

        }
        //print and display names
        System.out.println("\n>>>ALL-TIME LEADERBOARD<<<");
        System.out.println("RANK |  PENALTY-PTS  |  NAME");
        for (int j=0;j<nameLb.length;j++){
            System.out.println((j+1)+"       "+scoreLb[j]+"              "+nameLb[j]);
        }
    }//end leaderboard method

   /* addScore method
       This procedural method adds the score, name and new line onto the leaderboard file


       ---List of Local Variables---
           writer - declare FileWriter() object

           @parameters
               name (String) - user's name
               score (int) - penalty points earned

           @return
               none
    */


    public void addScore(int score,String name) {
        try {
            FileWriter writer = new FileWriter("src/leaderboard.txt", true); //writes the file
            writer.append(name + " " + score+"\n");//makes new line + name + score
            writer.close();
        } catch(IOException e) {

        }

    }//end addScore method

    /* isPlayAgain method
        This functional method asks the user if they want to play again and returns a boolean value


    ---List of Local Variables---
        br = declare BufferedReader() object
        YES (String) = constant value used to represent yes
        NO (String) = constant value used to represent no
        input (String) = stores user input

    @throws IOException
    @parameters
        none

    @return
        true or false (boolean) based on user input


     */
    public boolean isPlayAgain()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String YES="y";
        final String NO="n";
        String input;
        System.out.println("\nWould you like to play again?");

        while(true){
            System.out.println("Enter 'y' to play again and 'n' to exit the program.");
            input=br.readLine();
            if (input.equalsIgnoreCase(YES)){
                return true;
            }else if(input.equalsIgnoreCase(NO)){
                System.out.println("Goodbye! Thanks for using this program.");
                return false;
            }
            else{
                System.out.println("Input Invalid. Try Again.");
            }

        }


    }//end isPlayAgain method

   /* getMenuInput method
       This functional method asks the user to enter a number based on menu options, error proofing with try catch

   ---List of Local Variables---
       br = declare BufferedReader() object
       numInput (int) - stores user input

   @throws IOException
   @parameters
       none

   @return
       numInput integer value

    */

    public int getMenuInput()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            int numInput;
            try{
                System.out.println("Please enter a number from the options above.");
                numInput=Integer.parseInt(br.readLine());
                return numInput;

            }catch(Exception e){
                System.out.println("Invalid. Enter an Integer.");
            }
        }


    }//end getMenuInput method


   /* printWinMessage method
       This procedural method is used to print out a congratulatory message if the user wins


   @parameters
       name(String) - name of user
       moveCounter(int) - number of moves made
       hintCounter(int) - number of hints used
       pointCounter(int) - number of penalty points accumulated


   @return
       void

    */

    public void printWinMessage(String name, int moveCounter,int hintCounter,int pointCounter){
        System.out.println("\nCongratulations, "+name+"! You won!");
        System.out.println("It took you "+moveCounter+" moves and "+hintCounter+" hints.");
        System.out.println("You got "+pointCounter+" penalty points.");


    }//end printWinMessage method

    /* findDistance method
        This functional method is used to find the number of moves between user and missy based off of current position

    ---List of Local Variables---
        distanceY - distance between y-coordinates
        distanceX - distance between x-coordinates

    @parameters
        charPosX(int) - x-coordinate of user
        charPosY(int) - y-coordinate of user
        missyPosX(int) - x-coordinate of missy
        missyPosY(int) - y-coordinate of missy

    @return
        distanceMoves(int) - number of moves user has to make to reach missy

     */
    public int findDistance(int charPosX, int charPosY,int missyPosX,int missyPosY){
        int distanceY;
        int distanceX;
        int distanceMoves;

        distanceY=missyPosY-charPosY;
        if (distanceY<0){
            distanceY*=-1;
        }
        distanceX=missyPosX-charPosX;
        if (distanceX<0){
            distanceX*=-1;
        }
        distanceMoves=distanceX+distanceY;
        return distanceMoves;


    }//end findDistance method


   /* updateHunterPosition method
       This functional method is used to randomly update hunters' position on the grid by 1 square each turn


   ---List of Local Variables---
       MIN (int) - minimum value for generating random number range
       MAX (int) - maximum value for generating random number range
       randomNumber (int) - stores random number generated


   @parameters
       posX (int) - hunter's current x position
       posY (int) - hunters's current y position
       SIZE (int) - grid length

   @return
       hunter's new {x,y} coordinates (position) in 1d array format

    */

    public int[] updateHunterPosition(int posX,int posY, int SIZE){
        int randomNumber;
        final int MIN=1;
        final int MAX=4;

        //generate random direction
        randomNumber = (int)Math.round (Math.random () * (MAX-MIN))+MIN;
        if (randomNumber==1 && (posX+1)<SIZE){
            posX++;

        }else if (randomNumber==2 && (posX-1)>=0){
            posX--;

        }else if (randomNumber==3 && (posY+1)<SIZE){
            posY++;

        }else if(randomNumber==4 && (posY-1)>=0){
            posY--;

        }
        return new int[]{posX,posY};
    }//end updateHunterPosition method


    /* updateMissyPosition method
        This functional method is used to randomly update missy's position on the grid by a random number of squares


    ---List of Local Variables---
        MIN (int) - minimum value for generating random number range
        MAX (int) - maximum value for generating random number range
        MOVE_MAX (int) - maximum value for generating number of moves made
        randomMoveNum (int) - stores random number of moves generated
        randomNumber (int) - stores random number generated


    @parameters
        posX (int) - missy's current x position
        posY (int) - missy's current y position
        SIZE (int) - grid length


    @return
        missy's new {x,y} coordinates (position) in 1d array format


     */
    public int[] updateMissyPosition(int posX,int posY, int SIZE){
        int randomNumber;
        int randomMoveNum;
        final int MOVE_MAX=3;
        final int MIN=1;
        final int MAX=4;
        //generate random number of moves to move
        randomMoveNum = (int)Math.round(Math.random() *(MOVE_MAX));
        //generate random direction
        randomNumber = (int)Math.round (Math.random () * (MAX-MIN))+MIN;
        if (randomNumber==1 && (posX+randomMoveNum)<SIZE){
            posX+=randomMoveNum;


        }else if (randomNumber==2 && (posX-randomMoveNum)>=0){
            posX-=randomMoveNum;


        }else if (randomNumber==3 && (posY+randomMoveNum)<SIZE){
            posY+=randomMoveNum;


        }else if(randomNumber==4 && (posY-randomMoveNum)>=0){
            posY-=randomMoveNum;


        }
        return new int[]{posX,posY};


    }//end updateMissyPosition method


    /* ifPositionValid method
        This functional method checks and returns whether the position is valid by checking if the coordinates remain within the borders of the grid


    @parameters
        xPos (int) - x-coordinate of subject
        yPos (int) - y-coordinate of subject
        SIZE (int) - size of length to be checked


    @return
        boolean value to see if the coordinates fit within the border


     */
    public boolean ifPositionValid(int xPos,int yPos,int SIZE){
        return (xPos>=0 && xPos<SIZE && yPos>=0 && yPos<SIZE);


    }//end ifPositionValid method


   /* updatePosition method
       This functional method is used to update user position on the grid by 1 square based on parameter of input


   ---List of Local Variables---
       UP (String) - represents constant w character to return
       DOWN (String) - represents constant s character to return
       RIGHT (String) - represents constant d character to return
       LEFT (String) - represents constant a character to return


   @parameters
       controlInput (String) -
       charPosX (int) - current x-coordinate of position of user
       charPosY (int) - current y-coordinate of position of user


   @return
       user's new {charPosX,charPosY} coordinates (position) in 1d array format


    */


    public int[] updatePosition(String controlInput, int charPosX, int charPosY){
        final String UP = "w";
        final String DOWN = "s";
        final String LEFT = "a";
        final String RIGHT = "d";


        if (controlInput==UP){
            charPosX--;
        }
        else if (controlInput==DOWN){
            charPosX++;
        }
        else if (controlInput==LEFT){
            charPosY--;
        }
        else if (controlInput==RIGHT){
            charPosY++;
        }


        return new int[]{charPosX,charPosY};
    } //end updatePosition method


    /* getControl method
        This functional method asks the user to enter a move or open settings and return that move in lowercase


    ---List of Local Variables---
        br = declare BufferedReader() object
        controlInput(String) - stores String value that the user inputs
        UP (String) - represents constant w character to return
        DOWN (String) - represents constant s character to return
        RIGHT (String) - represents constant d character to return
        LEFT (String) - represents constant a character to return
        MENU (String) - represents constant m character to return


    @throws IOException
    @parameters
        none


    @return
        String value controls converted to constants that the user enters
        (a,s,w,d,m)


     */
    public String getControl()throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String controlInput;
        final String UP = "w";
        final String DOWN = "s";
        final String LEFT = "a";
        final String RIGHT = "d";
        final String MENU = "m";

        while (true){ //return user input
            System.out.println("\nEnter a WASD character. Enter 'm' for Menu.");
            controlInput=br.readLine();
            if (controlInput.equalsIgnoreCase(UP)){
                return UP;
            }
            else if (controlInput.equalsIgnoreCase(DOWN)){
                return DOWN;
            }
            else if (controlInput.equalsIgnoreCase(LEFT)){
                return LEFT;
            }
            else if (controlInput.equalsIgnoreCase(RIGHT)){
                return RIGHT;
            }
            else if (controlInput.equalsIgnoreCase(MENU)){
                return MENU;
            }
            else{
                System.out.println("Invalid Input. ");
            }


        }
    } //end getControl method


    /* drawGrid method
        This procedural method draws and updates the main game's grid with each turn based on updated information.
        - Displays hints, moves and penalty points
        - draws grid with borders
        - executes condition for if missy is hidden or not


    @parameters
        grid (String) (2d array) - grid/array for the game
        pathSearched (boolean) (2d array) - array that stores boolean value for if a path if searched already
        GRID_LETTERS (String) (1d array) - letters for the border of the grid
        charPosX (int) - current x-coordinate of position of user
        charPosY (int) - current y-coordinate of position of user
        user (String) - icon of user
        missy (String) - icon of missy
        missyPosX (int) - current x-coordinate of position of missy
        missyPosY (int) - current y-coordinate of position of missy
        isMissyCaught (boolean) - true of false value depending if missy is caught or not
        moveCounter (int) - number of turns/moves made by user so far
        MISSY_UNHIDDEN (String) - constant variable representing icon of unhidden missy
        MISSY_HIDDEN (String) - constant variable representing icon of hidden missy
        isCheat (boolean) - true of false value depending if cheat is on or not
        hintCounter (int) - number of hints used by user so far
        pointCounter (int) - number of penalty points accumulated by the user so far
        pitfalls (boolean) (2d array) - array that stores boolean value for pitfalls
        PITFALL_UNHIDDEN (String) - pitfall icon to show if cheat is on
        pitfallCounter (int) - keeps track of number of pitfalls fallen
        NUM_HUNTERS (int) - constant number of hunters in the game
        hunters (boolean) (2d array) - array that stores boolean value for if there is hunter on a square
        HUNTER_UNHIDDEN (String) - represents unhidden hunter icon
        HUNTER_HIDDEN (String) - represents hidden hunter icon
        START_CORD - coordinate of the start
        START (String) - represents start icon
        seconds (long) - represents seconds elapsed since the start of each game
        hunter (String) - represents hunter icon
        SEARCHED (String) - represents searched icon

    @return
        void

     */
    public void drawGrid(String[][]grid, int charPosX,int charPosY,String user,int missyPosX,int missyPosY,String missy,
                         boolean isMissyCaught, int moveCounter,String MISSY_UNHIDDEN, String MISSY_HIDDEN, boolean isCheat,
                         boolean[][] pathSearched, int hintCounter,int pointCounter,boolean[][] pitfalls,String PITFALL_UNHIDDEN, int pitfallCounter,
                         int NUM_HUNTERS,boolean[][]hunters,String HUNTER_UNHIDDEN, int START_CORD, String START,long seconds,String hunter, String SEARCHED,
                         String HUNTER_HIDDEN){

        // declare constant letters for grid
        final String[] GRID_LETTERS = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o"};

        // clear hunter's trail but preserve the user's trail
        if (isCheat) {
            hunter=HUNTER_UNHIDDEN;
        }
        else{
            hunter=HUNTER_HIDDEN;
        }
        // fills in and overwrites spaces
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (!user.equals(grid[x][y]) && !pathSearched[x][y]) {
                    grid[x][y] = " ";
                }
            }
        }

        // update hunter positions on the grid
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (hunters[x][y]) {
                    grid[x][y] = hunter;
                }
            }
        }

        //hunter shown on path
        for (int i=0;i<NUM_HUNTERS;i++){
            for (int x = 0; x < grid.length; x++) {
                for (int y = 0; y < grid[0].length; y++) {
                    if (pathSearched[x][y] && hunters[x][y]) {
                        grid[x][y] = HUNTER_UNHIDDEN;
                    }else if (pathSearched[x][y] && !hunters[x][y]){
                        grid[x][y]=SEARCHED;
                    }
                }
            }
        }

        //sets start coordinate to start symbol
        grid[START_CORD][START_CORD]=START;

        //sets users current position
        grid[charPosX][charPosY]=user;

        //checks if pitfalls should be hidden
        if (isCheat){
            for (int x=0;x<grid.length;x++){
                for (int y=0;y<grid[0].length;y++){
                    if (pitfalls[x][y]){
                        grid[x][y]=PITFALL_UNHIDDEN;
                    }


                }
            }
        }


        //checks if missy should be hidden or shown
        if (isCheat){
            missy=MISSY_UNHIDDEN;


        }else if(!isCheat && isMissyCaught){
            missy=MISSY_HIDDEN;
        }


        if(!isMissyCaught) { //update missy on grid if missy hasn't been caught yet
            grid[missyPosX][missyPosY] = missy;
        }


        //checks if Missy is on searched path to make her visible
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (pathSearched[x][y] && missyPosX==x && missyPosY==y && !isMissyCaught) {
                    grid[x][y] = MISSY_UNHIDDEN;
                }
            }
        }

        //print out the grid in format
        System.out.println();
        for (int x=0;x<grid.length;x++){
            System.out.print("  "+GRID_LETTERS[x]); //prints letters
        }
        System.out.println();


        for (int x=0;x<grid[0].length;x++){
            System.out.print(" ——"); // prints top border
        }
        //prints counters
        System.out.print("       Turns: "+moveCounter+" | Hints Used: "+hintCounter+" | Pitfalls Landed: "+pitfallCounter+" | Penalty Points: "+pointCounter);


        //print main game grid
        for (int x=0;x<grid.length;x++){
            System.out.print("\n| "); //prints left border
            for (int y=0;y<grid[0].length;y++){
                System.out.print(grid[x][y]);
                System.out.print("  ");
            }
            System.out.print("| "+ (x+1)); //prints right border with number notation
        }
        System.out.println();
        System.out.print(" ");
        for (int x=0;x<grid[0].length;x++){
            System.out.print(" ——"); //prints bottom border
        }
        System.out.println("       Time Elapsed: "+seconds+" seconds");


    } //end drawGrid method


} //end SummativeJan2024Final