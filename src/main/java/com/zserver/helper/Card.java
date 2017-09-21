package com.zserver.helper;

/**
 * Created by ZZZ on 2017/9/4.
 */
enum CardType {
    WAN,
    TIAO,
    TONG,
    ZI,
    Hua,
}

public class Card {
    public CardType type;
    public int num;

    public Card(CardType type, int num) {
        this.type = type;
        this.num = num;
    }

    public boolean Equals(Card card) {
        return type == card.type && num == card.num;
    }
    static public int GetCardMax(CardType type) {
        if (type == CardType.ZI) return 7;
        else if (type == CardType.Hua) return 8;
        else return  9;
    }

    @Override
    public String toString() {
        return num +" "+ type.name();
    }
}

