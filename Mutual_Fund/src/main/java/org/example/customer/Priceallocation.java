package org.example.customer;

import java.util.ArrayList;
import java.util.Random;

public class Priceallocation {
    public ArrayList<Fund> priceallocation( ArrayList<Fund> FundList){
        for (int i=0;i< FundList.size();i++){
            FundList.get(i).setNAV(new Random().nextInt(100));
        }

        return FundList;
    }
}
