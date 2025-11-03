package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static Lotto makeLotto(){
        List<Integer> target =  camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1, 45, 6);
        target.sort(null);
        Lotto paid = new Lotto(target);
        System.out.println(paid.numbers);
        return paid;
    }
    public static Lotto makeLotto(List<Integer> numbers){
        Lotto paid = new Lotto(numbers);
        return paid;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    
    

    // TODO: 추가 기능 구현
}
