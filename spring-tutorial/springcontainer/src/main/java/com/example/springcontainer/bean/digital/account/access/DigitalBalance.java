package com.example.springcontainer.bean.digital.account.access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DigitalBalance
{
    private String accountantName;
    private DigitalBalance.Money money;
    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    public static class Money
    {
        private String count;
    }

}


