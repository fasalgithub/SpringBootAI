package com.example.springcontainer.bean.bank.account.access;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BankBalance
{
    private String accountantName;
    private BankBalance.Money money;
    private int id;
    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    public static class Money
    {
        private String count;
    }

}


