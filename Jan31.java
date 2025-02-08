import java.util.Scanner;

class Game{

    static char[] vowels = {'a','e','i','o','u','A','E','I','O','U',' '};

    StringBuilder guessed = new StringBuilder();
    StringBuilder movie = new StringBuilder();
    int noOfGuess = 0;
    boolean won = false;

    {
        char[] str = "READY TO PLAY A GAME ??\nLETS BEGIN !!!".toCharArray();
        for(char c : str){
            System.out.print(c);
            Thread.sleep(175);
        }
        clearScreen();
    }

    Game() throws Exception{
        System.out.print("Enter the name of the movie: ");
        Scanner sc = new Scanner(System.in);
        this.movie = new StringBuilder(sc.nextLine());
    }

    void clearScreen() throws Exception{
        Thread.sleep(900);
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    void updateTitle(){
        System.out.print("\n\t============="+"\n\t| ");
        String title = "BOLLYWOOD";
        for(int i=0;i<title.length();i++){
            if(i<noOfGuess) System.out.print(Color.RED + "-" + Color.RESET);
            else System.out.print(Color.CYAN+title.charAt(i)+Color.RESET);
        }
        System.out.println(" |\n\t=============");
    }

    void hasWon() throws Exception{
        for(int i=0;i<12;i++) {
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            if(i%2==0){
                System.out.print("\t= = = = = = = = = \n");
                if(won) System.out.print("\t\\ "+Color.CYAN+"CONGRATULATION"+Color.RESET+" \\");
                else System.out.print("\t\\ "+Color.RED+"SORRY YOU LOST"+Color.RESET+" \\");
                System.out.print("\n\t = = = = = = = = =");   
            }
            else{
                System.out.print("\t = = = = = = = = =\n");
                if(won) System.out.print("\t/ "+Color.CYAN+"CONGRATULATION"+Color.RESET+" /");
                else System.out.print("\t/ "+Color.RED+"SORRY YOU LOST"+Color.RESET+" /");
                System.out.print("\n\t= = = = = = = = = ");
            }
            Thread.sleep(350);
        }
    }

    char getChar(){
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().toLowerCase().charAt(0);

        for(int i=0;i<guessed.length();i++){
            if(ch == guessed.charAt(i)){
                System.out.println(Color.RED+ch+" already guessed !!!"+Color.RESET);
                return Character.MIN_VALUE;
            }
        }
        
        for(char c : vowels){
            if(ch == c ){
                System.out.println(Color.RED+ch+" is a vowel !!!"+Color.RESET);
                return Character.MIN_VALUE;
            }
        }

        guessed.append(ch);
        return ch;
    }

    StringBuilder nextWord(StringBuilder prevWord,char ch){
        boolean found = false;
        StringBuilder newWord = prevWord;
        for (int i=0;i<movie.length();i++) {
            if(movie.toString().toLowerCase().charAt(i) == ch){
                newWord.setCharAt(i,movie.charAt(i));
                found = true;
            }
        }
        if(!found) this.noOfGuess++;
        return newWord;
    }

    void play() throws Exception{
        clearScreen();
        StringBuilder vowelsOnly = new StringBuilder();
        for(char c : movie.toString().toCharArray()){
            boolean found = false;
            for(char ch : vowels){
                if(c == ch){
                    vowelsOnly.append(c);
                    found = true;
                    break;
                }
            }
            if(!found) vowelsOnly.append('*');
        }
        StringBuilder prevWord = vowelsOnly;

        while(noOfGuess<9){

            if(prevWord.toString().equals(movie.toString())){
                won = true;
                break;
            }

            updateTitle();
            System.out.println("Word: " + prevWord.toString());
            System.out.print("Enter your guess: ");
            char ch = getChar();
            if(ch != Character.MIN_VALUE){
                prevWord = nextWord(prevWord, ch);
            }
            clearScreen();
        }

        this.hasWon();
        if(this.won == false ) this.printSummary(prevWord.toString());
        else this.printSummary(this.movie.toString());
    }

    void printSummary(String guessedWord){
        System.out.println("\n\n============================");
        System.out.println("Actual Word: "+this.movie.toString());
        System.out.println("Guessed Word: "+guessedWord);
        System.out.println("============================\n");
    }

}

class Jan31{
    public static void main(String[] args) throws Exception{
        Game g1 = new Game();
        g1.play();
    }
}