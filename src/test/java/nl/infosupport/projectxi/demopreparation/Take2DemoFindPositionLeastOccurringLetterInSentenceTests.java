package nl.infosupport.projectxi.demopreparation;

import org.junit.jupiter.api.Disabled;
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

    @Test
    @DisplayName("Wat gebeurt er eigenlijk met karakters die niet opgenomen zijn in capitals, hoe reageert de methode daarop? " +
            "Bijvoorbeeld de a in aAABBBCZZCCDDEE ")
    @Disabled("Test moet nog gefixed worden. Test wordt opgenomen om deze situatie niet te vergeten.")
    void vindDeIndexVanLowercaseA(){
        //1 Arrange
        String sentence = "aAABBBCZCCDDEE";
        //2 Act
        int postionLeastOccuringLetter  = findFirstPositionLeastOccuringLetter(sentence);
        //3 Assert
        assertThat(postionLeastOccuringLetter).isEqualTo(0);
    }

    @Test
    @DisplayName("Hoe willen we omgaan met de situatie waarbij 2 letters even vaak voorkomen? " +
            "Bijvoorbeeld in AABBBCZZCCDDEE de Z en de E")
    @Disabled("By design: Wat willen dat er uitkomt, waar zal dit stuklopen, waarom? Oplossing")
    void hoeGaatAlgorithmeOmMet2LettersDieAllebeiEvenVaakVoorkomen(){
        //1 Arrange
        String sentence = "ZBBZ";
        //2 Act
        int postionLeastOccuringLetter  = findFirstPositionLeastOccuringLetter(sentence);
        //3 Assert
        assertThat(postionLeastOccuringLetter).isEqualTo(0);
    }

    @Test
    @DisplayName("Hoe willen we omgaan met de situatie wanneer de sentence leeg is. \"\"")
    @Disabled("By design: Wat willen dat er uitkomt, waar zal dit stuklopen, waarom? Oplossing")
    void hoeOmgaanMetLegeArray(){
        //1 Arrange
        String sentence = "";
        //2 Act
        int postionLeastOccuringLetter  = findFirstPositionLeastOccuringLetter(sentence);
        //3 Assert
        assertThat(postionLeastOccuringLetter).isEqualTo(0);
    }

    @Test
    @DisplayName("Hoe willen we omgaan een sentence die uit 1 letter bestaat bijv. A")
    @Disabled("By design: Wat willen dat er uitkomt, waar zal dit stuklopen, waarom? Oplossing")
    void hoeOmgaanMetEenSentenceVan1Letter(){
        //1 Arrange
        String sentence = "A";
        //2 Act
        int postionLeastOccuringLetter  = findFirstPositionLeastOccuringLetter(sentence);
        //3 Assert
        assertThat(postionLeastOccuringLetter).isEqualTo(0);
    }

    @Test
    @DisplayName("Mis je nog tests, welke test zou je willen toevoegen?")
    void ontbekendeTests(){
        //1 Arrange
        String sentence = "onbekende test";
        //2 Act
        int postionLeastOccuringLetter  = findFirstPositionLeastOccuringLetter(sentence);
        //3 Assert
        assertThat(postionLeastOccuringLetter).isEqualTo(0);
    }


    @Test
    @DisplayName("Zijn er plekken waar het efficienter kan? Zijn er plekken waar we veel informatie weggooien?" +
            " Waar, kan dat efficienter? Voordelen Wanneer? Nadelen wanneer?" +
            " Implementeer deze efficientere oplossing en noem de methode turboNaamAanpassing()" +
            " Zou je de efficiencyverschil kunnen meten? Hoe?")
    void kanHetEfficienter(){
        //1 Arrange
        String sentence = "AABBCCCDDDDEEEEEFFFFFFFZ";
        //2 Act
        int postionLeastOccuringLetter  = findFirstPositionLeastOccuringLetter(sentence);
        //3 Assert
        assertThat(postionLeastOccuringLetter).isEqualTo(23);
    }

    @Test
    @DisplayName("Idealiter zou je willen dat bij elke nieuwe test dat de NotYetImplementedException zou afgaan." +
            " Immers een nieuwe test, is nieuwe functionaliteit en die zou er nog niet in mogen zitten." +
            " Probeer vanaf de 2de test deze exception weer in te bouwen." +
            " Git ceckout commit en begin nieuwe branch, bugFix en probeer dit in te bouwen.")
    @Disabled("To Be implemented")
    void notYetImplementedDisappeared(){
        //1 Arrange
        String sentence = "Ik wil de NotYetImplementedException zien!";
        //2 Act
        int postionLeastOccuringLetter  = findFirstPositionLeastOccuringLetter(sentence);
        //3 Assert
        assertThat(postionLeastOccuringLetter).isEqualTo(0);
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
