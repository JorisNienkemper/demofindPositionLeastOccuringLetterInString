package nl.infosupport.projectxi.demopreparation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Take2DemoFindPositionLeastOccurringLetterInSentenceTests {

    @Test
    @DisplayName("de verwachtepositie = 0 wanneer de sentence = AAAA alleen uit A's bestaat")
    void verwachtPositieNulBijStringVanAlleenAas(){
        //1 Arrange
        String aas = "AAAA";
        //2 Act
        int postieFirstA = findFirstPositionLeastOccuringLetter(aas);

        //3 Assert
        assertThat(postieFirstA).isEqualTo(0);
    }

    @Test
    @DisplayName("de verwachtepositie = 1 van de eerste B in de sentence = ABAABA alleen uit A's en B's bestaat")
    void verwachtPositie1BijStringVanAlleenAasEnBees(){
        //1 Arrange
        String sentence = "ABAABA";
        //2 Act
        int postionLeastOccuringLetter = findFirstPositionLeastOccuringLetter(sentence);

        //3 Assert
        assertThat(postionLeastOccuringLetter).isEqualTo(1);
    }

    @Test
    @DisplayName(" AABBBCZCCDDE")
    void vindDeIndexVanZ(){
        //1 Arrange
        String sentence = "AABBBCZCCDDEE";
        //2 Act
        int postionLeastOccuringLetter  = findFirstPositionLeastOccuringLetter(sentence);
        //3 Assert
        assertThat(postionLeastOccuringLetter).isEqualTo(6);
    }
    private int findFirstPositionLeastOccuringLetter(String sentence) {

        char[] capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        int [] counterCapitals = countCapitals(capitals,sentence);

        int indexLowestFrequenceLetterCount = indexLowestFrequenceLetterCount(counterCapitals);

        char lowestFrequenceLetter = capitals[indexLowestFrequenceLetterCount];

        int indexFirstOccurrenceLetterInSentence = findFirstOccurrenceLetter(lowestFrequenceLetter, sentence);

        return indexFirstOccurrenceLetterInSentence;

//        return findFirstOccurrenceLetter(lowestFrequenceLetter, sentence);

    }

    private int[] countCapitals(char[] capitals, String sentence) {
        int [] counterCapitals = new int[capitals.length];
        for(int indexCapitals = 0; indexCapitals<capitals.length;indexCapitals+=1) {
            for (char characterInSentence : sentence.toCharArray()) {
                if (characterInSentence == capitals[indexCapitals]) {
                    counterCapitals[indexCapitals] += 1;
                }
            }
        }
        return counterCapitals;
    }

    private int findFirstOccurrenceLetter(char lowestFrequenceLetter, String sentence) {
        char [] sentenceAsCharacters = sentence.toCharArray();
        for(int indexCharInSentence =0;indexCharInSentence< sentenceAsCharacters.length;indexCharInSentence += 1){
            if(lowestFrequenceLetter == sentenceAsCharacters[indexCharInSentence]){
                return indexCharInSentence;
            }
        }
        throw new NotYetImplementedException("Dat kan niet");
    }

    private int indexLowestFrequenceLetterCount(int[] counterCapitalAandB) {
        int lowest = counterCapitalAandB[0];
        int indexLowestValue = 0;
        for(int indexCounter = 0;indexCounter< counterCapitalAandB.length;indexCounter+=1){
            if(counterCapitalAandB[indexCounter] == 0){
                continue;
            }
            if(lowest > counterCapitalAandB[indexCounter]){
                lowest = counterCapitalAandB[indexCounter];
                indexLowestValue = indexCounter;
            }
        }
        return indexLowestValue;
    }

    private int moetJeNietWillenDoen(String sentence) {

        char[] capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        int [] counterCapitals1 = new int[capitals.length];
        for(int indexCapitals = 0; indexCapitals< capitals.length; indexCapitals+=1) {
            for (char characterInSentence : sentence.toCharArray()) {
                if (characterInSentence == capitals[indexCapitals]) {
                    counterCapitals1[indexCapitals] += 1;
                }
            }
        }
        int [] counterCapitals = counterCapitals1;

        int lowest = counterCapitals[0];
        int indexLowestValue = 0;
        for(int indexCounter = 0; indexCounter< counterCapitals.length; indexCounter+=1){
            if(counterCapitals[indexCounter] == 0){
                continue;
            }
            if(lowest > counterCapitals[indexCounter]){
                lowest = counterCapitals[indexCounter];
                indexLowestValue = indexCounter;
            }
        }
        int indexLowestFrequenceLetterCount = indexLowestValue;

        char lowestFrequenceLetter = capitals[indexLowestFrequenceLetterCount];

        char [] sentenceAsCharacters = sentence.toCharArray();
        for(int indexCharInSentence =0;indexCharInSentence< sentenceAsCharacters.length;indexCharInSentence += 1){
            if(lowestFrequenceLetter == sentenceAsCharacters[indexCharInSentence]){
                return indexCharInSentence;
            }
        }

        throw new NotYetImplementedException("Niet doen");

//        return findFirstOccurrenceLetter(lowestFrequenceLetter, sentence);

    }

}
