package lotto;



public class Application {
    public static void main(String[] args) {

        lotto.method.Buy.buyLotto();

        lotto.method.Setting setting = new lotto.method.Setting();
        setting.setting_play();

        lotto.method.Play play = new lotto.method.Play();
        play.play();
        play.print_result();

        
        

    }
}
