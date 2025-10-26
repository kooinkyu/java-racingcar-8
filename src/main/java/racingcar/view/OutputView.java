package racingcar.view;

import racingcar.domain.Car;
import java.util.List;

public class OutputView {
    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String POSITION_SYMBOL = "-";
    private static final String NAME_POSITION_SEPARATOR = " : ";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printRacingResult(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
        }
        System.out.println();
    }

    private void printCarPosition(Car car) {
        System.out.println(car.getName() + NAME_POSITION_SEPARATOR +
                POSITION_SYMBOL.repeat(car.getPosition()));
    }

    public void printWinners(List<String> winners) {
        System.out.println(WINNER_MESSAGE + String.join(", ", winners));
    }
}