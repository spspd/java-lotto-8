package lotto.method;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import lotto.Lotto;
public class Setting {
    public static Lotto winLotto ;
    public static int bonus_numb ;
    public void setting_play(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        winNumbers();
        System.out.println("\n보너스 번호를 입력해 주세요.");
        bonusNumber();
    }

    public void winNumbers(){
        //TODO
        String a = camp.nextstep.edu.missionutils.Console.readLine();
        String[] numbers ;
        try{
            numbers = a.split(",");
        } 
        catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 입력 오류(나중에 바꿈)"); 
        }
        List<Integer> numbers_int = new ArrayList<>();
        // validate_winNumber(); trycatch로 대체
        for (int i = 0; i < numbers.length; i++) {
            numbers_int.add(Integer.parseInt(numbers[i]));
        }   
        Collections.sort(numbers_int);
        winLotto = Lotto.makeLotto(numbers_int);
    }

    public void bonusNumber(){
        //TODO
        int numb = 0;
        try{
            String temp =camp.nextstep.edu.missionutils.Console.readLine();
            numb = Integer.parseInt(temp);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 보너스입력 오류(나중에 바꿈)"); 
        }
        //validate_bonusNumber(); trycatch로 대체
        bonus_numb = numb;
        
    }

}
