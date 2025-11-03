package lotto;


import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        lotto.method.Buy.buyLotto();

        lotto.method.Setting setting = new lotto.method.Setting();
        setting.setting_play();

        lotto.method.Play play = new lotto.method.Play();
        play.play();
        play.print_result();

        
        

    }
}
