package com.hib.test;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hib.config.HibernateConfig;
import com.hib.dto.Bond;
import com.hib.dto.ShareDetails;
import com.hib.dto.Stock;

public class Test {

	public static void main(String[] args) {
		SessionFactory factory = HibernateConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(createShareDetails());
		session.saveOrUpdate(createBond());
		session.saveOrUpdate(createStock());
		transaction.commit();
		session.close();
		factory.close();

	}

	private static Stock createStock() {
		Stock stock  = new Stock();
		stock.setIssuer("HDFC");
		stock.setName("HDFC TERM");
		stock.setPrice(new BigDecimal(500000));
		return stock;
	}
	
	private static ShareDetails createShareDetails() {
		ShareDetails shareDetails = new ShareDetails();
		shareDetails.setDate(new Date());
		shareDetails.setIssuer("LIC");
		shareDetails.setName("JEEVAN ANAND");
		return shareDetails;
	}
	
	private static Bond createBond() {
		Bond bond  = new Bond();
		bond.setInterest(new BigDecimal(10.2));
		bond.setMaturityVal(new BigDecimal(10000000));
		return bond;
	}

}
