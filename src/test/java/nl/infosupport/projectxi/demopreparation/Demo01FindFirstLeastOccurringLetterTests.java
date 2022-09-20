package nl.infosupport.projectxi.demopreparation;

import nl.infosupport.projectxi.demopreparation.utils.Demo;
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

    private int findFirstPositionLeastOccurringLetter(String sentence) {
        throw new NotYetImplementedException("Not implemented yet. You probably found a new requirement. Chech out with the PO!");
    }
}
