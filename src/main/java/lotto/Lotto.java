package lotto;

import java.util.ArrayList;
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
        if (numbers.size() != new java.util.HashSet<Integer>(numbers).size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static Lotto makeLotto(){
        List<Integer> target =  camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> mutable_dump = new ArrayList<>(target);
        mutable_dump.sort(null);
        Lotto paid = new Lotto(mutable_dump);
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

}
