package racingcar;

import racingcar.domain.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String carNames = inputView.readCarNames();
        int racingCount = inputView.readRacingCount();

        Game racingGame = new Game(carNames);

        outputView.printResultMessage();

        for (int i = 0; i < racingCount; i++) {
            racingGame.race();
            outputView.printRacingResult(racingGame.getCars());
        }

        outputView.printWinners(racingGame.getWinners());
    }
}