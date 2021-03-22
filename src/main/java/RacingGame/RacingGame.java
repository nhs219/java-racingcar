package RacingGame;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<Car> racingCars;
    private int numOfCar;
    private int numOfTry;


    public RacingGame(){
        racingCars = new ArrayList<Car>();
    }

    public void getInputValue(){
        InputView inputView = new InputView();
        this.numOfCar = inputView.inputNumOfCar();
        this.numOfTry = inputView.inputNumOfTry();
    }

    public void doRacingGame(){

        getInputValue();
        prepareGame(numOfCar);
        playGameNumOfTry(numOfTry);

    }

    public void playGameNumOfTry(int numOfTry) {
        int numOfPlayed = 0;
        while(numOfPlayed++ < numOfTry){
            
            racingCars.stream()
                    .forEach(car -> car.stopOrMove());
            
            racingCars.stream()
                    .forEach(car-> ResultView.viewResult(car));

            System.out.println();
        }
    }

    public void prepareGame(int numOfCar) {

        for(int i = 0; i < numOfCar; i ++){
            racingCars.add(new Car());
        }
    }

}
