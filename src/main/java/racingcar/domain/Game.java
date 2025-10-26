package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game{
    private final List<Car> cars;

    public Game(String carNames) {
        this.cars = createCars(carNames);
    }

    private List<Car> createCars(String carNames) {
        String[] names = carNames.split(",");
        List<Car> carList = new ArrayList<>();

        for (String name : names) {
            carList.add(new Car(name.trim()));
        }
        return carList;
    }

    public void race() { // 모든 자동차를 경주 한번진행(코인토스까지 해서)
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getCars() { // 자동차 리스트를 그대로 반환(출력에 사용하기 위해)
        return cars;
    }
    private int findMaxPosition() { // 말그대로 MAX 포지션 찾기
        int max = 0;
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        return max;
    }
    private List<String> findWinnerNames(int maxPosition) { // 우승자 이름찾기 STREAM 사용
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
    public List<String> getWinners() {
        int maxPosition = findMaxPosition();
        return findWinnerNames(maxPosition);
    }
}