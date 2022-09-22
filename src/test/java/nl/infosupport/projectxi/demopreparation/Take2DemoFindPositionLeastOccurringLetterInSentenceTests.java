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
        int postieFirstA = findPositionFirstA(aas);

        //3 Assert
        assertThat(postieFirstA).isEqualTo(0);
    }

    private int findPositionFirstA(String sentence) {
        char capitalA ='A';

        for(char characterInSentence: sentence.toCharArray()){
            if(characterInSentence != capitalA){
                throw new NotYetImplementedException("Over deze situatie heb ik nog niet nagedacht");
            }
        }
        return 0;
    }
}
