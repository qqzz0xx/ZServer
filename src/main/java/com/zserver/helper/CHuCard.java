package com.zserver.helper;

import java.util.List;
import java.util.Vector;

/**
 * Created by ZZZ on 2017/9/4.
 */
class CHuCard {
    Card eye;
    List<Card> cards = new Vector<>(14);


    @Override
    public String toString() {
        if (cards.isEmpty()) return "";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cards.get(0));
        for (int i = 1, size = cards.size(); i < size; i++)
        {
            stringBuilder.append(", ");
            stringBuilder.append(cards.get(i));
        }
        return "eye:" + eye + "  card:" + stringBuilder.toString();
    }
}

class CTingCard {
    Card ting;
    CHuCard huCard;

    @Override
    public String toString() {
        return "Ting [ " + ting + " ] " + ", Hu [ " + huCard + " ] ";
    }
}