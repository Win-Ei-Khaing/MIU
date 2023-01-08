package edu.mum.cs544.bank.dao;

import java.util.*;
import javax.persistence.EntityManager;
import edu.mum.cs544.bank.EntityManagerHelper;
import edu.mum.cs544.bank.domain.Account;

public class JPAAccountDAO implements IAccountDAO{
        
	public void saveAccount(Account account) { 
                EntityManager em = EntityManagerHelper.getCurrent();
                em.persist(account);
	}

	public void updateAccount(Account account) {
                EntityManager em = EntityManagerHelper.getCurrent();
                em.merge(account);
        }

	public Account loadAccount(long accountnumber) {
                EntityManager em = EntityManagerHelper.getCurrent();
                return em.find(Account.class, accountnumber);
	}

	public Collection<Account> getAccounts() {
                EntityManager em = EntityManagerHelper.getCurrent();
                //added order by because old result is showing 4253892 first then 1263862
                //a)
                // Collection<Account> accountlist = em.createQuery("from Account a order by a.accountnumber desc", Account.class).getResultList();
                // 	return accountlist;
                // }

                //b) by using join-fetch-query
                Collection<Account> accountlist = em.createQuery("SELECT DISTINCT a from Account a "
                                                                + "JOIN FETCH a.customer c "
                                                                + "JOIN FETCH a.entryList el order by a.accountnumber desc", Account.class).getResultList();
                return accountlist;
	}
}
