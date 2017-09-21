package com.zserver.helper;

import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

/**
 * Created by ZZZ on 2017/9/4.
 */


public class HuHelper {

    public static List<CTingCard> CheckTing(List<Card> cards) {

        List<CTingCard> tingCards = new Vector<>();
        for (CardType t : CardType.values()) {
            for (int i = 0, size = Card.GetCardMax(t); i < size; i++) {
                Card card = new Card(t, i);

                List<Card> listnew = new Vector<>();
                listnew.addAll(cards);
                listnew.add(card);

                List<CHuCard> hulist = CheckHU(listnew);
                hulist.forEach((CHuCard p) -> {
                    CTingCard ctingCard = new CTingCard();
                    ctingCard.ting = card;
                    ctingCard.huCard = p;
                    tingCards.add(ctingCard);
                });

            }
        }

        return tingCards;
    }

    public static List<CHuCard> CheckHU(List<Card> cards) {
        cards.sort((x, y)-> {
            if (x.type == y.type )
                return  Integer.compare(x.num, y.num);
            else
                return  x.type.compareTo(y.type);
        });

        List<CHuCard> eyelist = CheckEye(cards);
        List<CHuCard> hulist = eyelist.stream().filter(p -> CheckMianZi(p.cards)).collect(Collectors.toList());

        return hulist;

    }

    public static List<CHuCard> CheckEye(List<Card> cards) {

        List<CHuCard> lists = new Vector<>();
        for (int i = 0, size = cards.size() - 1; i < size; ) {

            Card card = cards.get(i);
            Card nextCard = cards.get(i+1);

            if (card.Equals(nextCard)){
                CHuCard CHuCard = new CHuCard();
                CHuCard.eye = card;
                CHuCard.cards.addAll(cards);
                CHuCard.cards.remove(card);
                CHuCard.cards.remove(nextCard);

                lists.add(CHuCard);
                i += 2;
            } else {
                i += 1;
            }
        }
        return lists;
    }

    public static boolean CheckMianZi(List<Card> cards) {
        if (cards.size() % 3 != 0) return false;

        for (int i = 0, size = cards.size() - 2; i < size; i+=3 ) {
            if (!IsMianzi(cards, i)) {
                return false;
            }
        }

        return true;
    }

    public static boolean IsShunzi(List<Card> cards, int i) {
        Card card1 = cards.get(i);
        Card card2 = cards.get(i+1);
        Card card3 = cards.get(i+2);

        return (card1.type == card2.type && card2.type == card3.type && card1.type != CardType.ZI) &&
                    ((card1.num + 1) == card2.num && (card2.num + 1) == card3.num);
    }

    public static boolean IsKezi(List<Card> cards, int i) {
        Card card1 = cards.get(i);
        Card card2 = cards.get(i+1);
        Card card3 = cards.get(i+2);

        return (card1.type == card2.type && card2.type == card3.type ) &&
                (card1.num  == card2.num && card2.num == card3.num);

    }

    public static boolean IsDuizi(List<Card> cards, int i) {
        Card card1 = cards.get(i);
        Card card2 = cards.get(i+1);
        return card1.Equals(card2);
    }

    public static boolean IsMianzi(List<Card> cards, int i) {
        return IsShunzi(cards, i) || IsKezi(cards, i);
    }

    public static boolean IsQiDui(List<Card> cards) {
        for (int i = 0; i < cards.size(); i+=2) {
            if (!IsDuizi(cards, i)) return false;
        }
        return true;
    }



}
