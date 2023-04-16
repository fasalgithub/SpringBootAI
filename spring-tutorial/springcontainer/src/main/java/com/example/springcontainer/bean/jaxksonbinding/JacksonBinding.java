package com.example.springcontainer.bean.jaxksonbinding;

import com.example.springcontainer.bean.bank.account.access.BankBalance;
import com.example.springcontainer.bean.digital.account.access.DigitalBalance;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonBinding
{

    public void binding()
    {

        BankBalance balance = new BankBalance();
        balance.setAccountantName("Fasal");
        balance.setId(101);

        BankBalance.Money money = new BankBalance.Money();
        money.setCount("100");
        balance.setMoney(money);

        System.out.println(balance.getAccountantName());
        System.out.println(balance.getMoney().getCount());
        System.out.println(balance.getId());
        System.out.println("-----------------------------------------------------------------------");

        DigitalBalance digitalBalance =
                (DigitalBalance)ObjectMapper(balance,new DigitalBalance());

        System.out.println(digitalBalance.getAccountantName());
        System.out.println(digitalBalance.getMoney().getCount());
        System.out.println("-----------------------------------------------------------------------");
    }

    public static Object ObjectMapper(Object inputObject, Object convertedObject)
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return mapper.convertValue(inputObject,convertedObject.getClass());

    }
}
