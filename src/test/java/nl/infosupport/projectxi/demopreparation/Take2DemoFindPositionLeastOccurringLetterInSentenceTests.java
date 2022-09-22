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
    private int findFirstPositionLeastOccuringLetter(String sentence) {

        char[] capitals ={'A','B'};

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
}
