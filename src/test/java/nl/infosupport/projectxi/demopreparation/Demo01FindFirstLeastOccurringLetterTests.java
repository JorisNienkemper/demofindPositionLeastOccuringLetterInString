package nl.infosupport.projectxi.demopreparation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("""
    Vind de eerste positie van de  letter die het minst voorkomt in een gegeven String
    """)
public class Demo01FindFirstLeastOccurringLetterTests {

    @Test
    @DisplayName("""
    De eerste postitie in een String die alleen A's bevat is 0
    """)
    void vindDeEersteA(){
        //Arrange
        String aas = "AAAAAA";
        //Act
        int firstPosition = findFirstPositionLeastOccurringLetter(aas);
        //Assert
        assertThat(firstPosition).isEqualTo(0);
    }

    @Test
    @DisplayName("""
    De eerste postitie in een String die alleen uit B's bestaat is 0
    """)
    void vindDeEersteB(){
        //Arrange
        String bees = "BBBB";
        //Act
        int firstPosition = findFirstPositionLeastOccurringLetter(bees);
        //Assert
        assertThat(firstPosition).isEqualTo(0);
    }

    @Test
    @DisplayName("""
    De eerste postitie van de B in de String ABAABA is 1
    """)
    void vindDeEersteBInEenStringDieUitAasEnBeesBestaat(){
        //Arrange
        String bees = "ABAABA";
        //Act
        int firstPosition = findFirstPositionLeastOccurringLetter(bees);
        //Assert
        assertThat(firstPosition).isEqualTo(0);
    }

    @Test
    @DisplayName("""
    Vind de 1ste positie van de minst voorkomende letter in de willekeurige String ABCZABCDD
    """)
    void vindDePositieVanDeZ(){
        //Arrange
        String sentence = "ABCZABCDD";
        //Act
        int firstPositionLeastOccurringLetter = findFirstPositionLeastOccurringLetter(sentence);
        //Assert
        assertThat(firstPositionLeastOccurringLetter).isEqualTo(3);
        assertThat(sentence.charAt(firstPositionLeastOccurringLetter)).isEqualTo('Z');
    }
    private int findFirstPositionLeastOccurringLetter(String sentence) {
        char[] capitalsAandB = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();


        int [] captialCounter = countCapitals(sentence, capitalsAandB);

        int indexMaxValue = findLeastOccuringLetter(captialCounter);


        return findFirstPosition(capitalsAandB[indexMaxValue],sentence);
    }

    //Kan de signature van deze methode mooier?
    //Is die niet mooi dan?
    private  int [] countCapitals(String sentence, char[] capitalsAandB) {
        int [] captialCounter = new int[capitalsAandB.length];
        for(int index = 0; index < capitalsAandB.length; index++){
            for(char charFromString : sentence.toCharArray()){
                if(capitalsAandB[index] == charFromString){
                    captialCounter[index] += 1;
                }
            }
        }
        return captialCounter;
    }

    private int findFirstPosition(char character,String sentence) {
        char[] charactersInSentence = sentence.toCharArray();
        for(int index = 0; index < charactersInSentence.length; index++){
            if(character == charactersInSentence[index] ){
                return index;
            }
        }
        throw new NotYetImplementedException();
    }

    private int findLeastOccuringLetter(int[] captialCounter) {
        int minValue = Integer.MAX_VALUE;
        int indexMinValue=0;
        for(int index = 0; index< captialCounter.length;index++ ){
            if(captialCounter[index] == 0){
                continue;
            }
            if(captialCounter[index]< minValue){
                minValue = captialCounter[index];
                indexMinValue = index;
            }
        }
        return indexMinValue;
    }
}
