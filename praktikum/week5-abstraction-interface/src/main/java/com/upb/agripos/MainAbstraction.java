package com.upb.agripos;

import com.upb.agripos.model.pembayaran.*;
import com.upb.agripos.model.kontrak.*;
import com.upb.agripos.util.CreditBy;

public class MainAbstraction {
    public static void main(String[] args) {
        Pembayaran cash = new Cash("HLD-002", 300000, 200000);
        System.out.println(((Receiptable) cash).cetakStruk());

        Pembayaran ew = new EWallet("SVA-003", 222300, "hilda@ewallet", "010505");
        System.out.println(((Receiptable) ew).cetakStruk());

        Pembayaran transfer = new TransferBank("ZNA-004", 100000, "hilda@bank", "212255");
        System.out.println(((Receiptable) transfer).cetakStruk());

        CreditBy.print();
    }
}
