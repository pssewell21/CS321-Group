/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaehyeokAtm;

import java.lang.System;
import java.util.*;

class ATM 
{
	Trade td[];
	private ATMUI atmui;
	public void showdetails(Trade td)
	{
		String type;
		if(td.getTradetype()) type = " Deposit";
		else type = " Withdraw";
		String details = "Date : ";
		long times = td.getTradedate();
		Date dt = new Date();
		dt.setTime(times);
		details = details.concat(dt.toString());
		details = details.concat(" Amount : ");
		details = details.concat(String.valueOf(td.getBalance()));
		details = details.concat(type);
		details = details.concat("trans amount : ");
		details = details.concat(String.valueOf(td.getTrademoney()));
		System.out.println(details);
	}
	
	public void uirun()
	{
		try{
			atmui = new ATMUI();
			atmui.setVisible(true);
		}
		catch(Exception e)
		{
		}
	}
	public static void main(String[] args) 
	{
		ATM atm = new ATM();
		//atm.testrun();
		atm.uirun();
	}
}

