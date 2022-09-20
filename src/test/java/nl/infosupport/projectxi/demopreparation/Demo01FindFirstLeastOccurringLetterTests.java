package nl.infosupport.projectxi.demopreparation;

import nl.infosupport.projectxi.demopreparation.utils.Demo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

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
    private int findFirstPositionLeastOccurringLetter(String sentence) {
        char[] capitalsAandB = {'A','B'};
        int [] captialCounter = new int[capitalsAandB.length];
        for(int index = 0; index < capitalsAandB.length; index++){
            for(char charFromString : sentence.toCharArray()){
                if(capitalsAandB[index] == charFromString){
                    captialCounter[index] += 1;
                }
            }
        }
        int indexMaxValue = findIndexMostOccuringCapital(captialCounter);


        return findFirstPosition(capitalsAandB[indexMaxValue],sentence);
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

    private int findIndexMostOccuringCapital(int[] captialCounter) {
        int maxValue = captialCounter[0];
        int indexMaxValue= 0;
        for(int index = 1; index< captialCounter.length;index++ ){
            if(captialCounter[index]> maxValue){
                maxValue = captialCounter[index];
                indexMaxValue = index;
            }
        }
        return indexMaxValue;
    }
}
