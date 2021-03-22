package RacingGame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("Car가 자신이 존재한 위치를 잘 나타내는지 확인")
    public void checkCarIsAt(){
        Car racingCar = new Car();
        for (int i = 0 ; i <5 ; i++){
            racingCar.stopOrMove();
        }

        assertThat(racingCar.isAt()).isGreaterThan(-1);
        assertThat(racingCar.isAt()).isLessThan(5);
    }

    @Test
    @DisplayName("출력이 잘 되는지 확")
    public void printTest(){
        Car racingCar = new Car();
        int numOfPlay = 5;
        for (int i = 0; i< numOfPlay;i++)
        {
            racingCar.stopOrMove();
            ResultView.viewResult(racingCar);
        }
    }

    @Test
    @DisplayName("game이 잘 진행되는지 확인")
    public void doRacingGame(){

        int numOfCar = 3;
        int numOfPlay = 5;

        RacingGame game = new RacingGame();
        game.prepareGame(numOfCar);
        game.playGameNumOfTry(numOfPlay);
    }

}