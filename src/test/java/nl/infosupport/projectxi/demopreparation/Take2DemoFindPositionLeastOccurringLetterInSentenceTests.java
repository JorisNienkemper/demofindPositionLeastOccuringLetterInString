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
        int postieFirstA = findFirstPositionOfTheLeastOccuringAorBees(aas);

        //3 Assert
        assertThat(postieFirstA).isEqualTo(0);
    }

    @Test
    @DisplayName("de verwachtepositie = 1 van de eerste B in de sentence = ABAABA alleen uit A's en B's bestaat")
    void verwachtPositie1BijStringVanAlleenAasEnBees(){
        //1 Arrange
        String aas = "ABAABA";
        //2 Act
        int postieFirstB = findFirstPositionOfTheLeastOccuringAorBees(aas);

        //3 Assert
        assertThat(postieFirstB).isEqualTo(1);
    }
    private int findFirstPositionOfTheLeastOccuringAorBees(String sentence) {
        char[] capitalsAorB ={'A','B'};
        int [] counterCapitalAandB = new int[capitalsAorB.length];
        for(int indexCapitalsAorB = 0; indexCapitalsAorB<capitalsAorB.length;indexCapitalsAorB+=1) {
            for (char characterInSentence : sentence.toCharArray()) {
                if (characterInSentence == capitalsAorB[indexCapitalsAorB]) {
                    counterCapitalAandB[indexCapitalsAorB] += 1;
                }
            }
        }

        int indexLowestFrequenceLetterCount = indexLowestFrequenceLetterCount(counterCapitalAandB);

        char lowestFrequenceLetter = capitalsAorB[indexLowestFrequenceLetterCount];

        int indexInSentence = findFirstB(lowestFrequenceLetter, sentence);

        return indexInSentence;
    }

    private int findFirstB(char lowestFrequenceLetter, String sentence) {
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
            if(lowest > counterCapitalAandB[indexCounter]){
                lowest = counterCapitalAandB[indexCounter];
                indexLowestValue = indexCounter;
            }
        }
        return indexLowestValue;
    }
}
