package lotto;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lotto.method.Play;
import lotto.method.Setting;
import lotto.method.Play.PRIZE;

public class PlayTest {
    @BeforeEach
    void setUp(){
        Setting.winLotto = Lotto.makeLotto(java.util.List.of(1,2,3,4,5,6));
        Setting.bonus_numb = 7;
    }
    @Test
    void 당첨_5개_보너스_일치(){
        Lotto paidLotto = Lotto.makeLotto(java.util.List.of(1,2,3,4,5,7));
        assertThat(Play.check_same(paidLotto)).isEqualTo(PRIZE.TWO);
    }
    @Test
    void 당첨_6개_일치(){
        Lotto paidLotto = Lotto.makeLotto(java.util.List.of(1,2,3,4,5,6));
        assertThat(Play.check_same(paidLotto)).isEqualTo(PRIZE.ONE);
    }// 의미는 없을듯 전체 테스트로 

}
