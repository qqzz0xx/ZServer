package com.zserver.helper;

import org.junit.Test;

import java.util.List;
import java.util.Vector;


/**
 * Created by ZZZ on 2017/9/4.
 */
public class HuHelperTest {
    @Test
    public void CheckEyeTest()
    {
        List<Card> list = new Vector<>();
        list.add(new Card(CardType.TIAO,2));
        list.add(new Card(CardType.TIAO,2));
        list.add(new Card(CardType.TIAO,2));

        list.add(new Card(CardType.TIAO,3));

        List<CTingCard> hulist = HuHelper.CheckTing(list);
        hulist.forEach((e)->{
            System.out.println(e);
        });

    }


}