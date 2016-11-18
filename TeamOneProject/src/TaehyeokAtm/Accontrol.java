/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaehyeokAtm;

import java.io.*;
import java.util.*;
import java.io.DataOutputStream;

public class Accontrol{
	private int acnum;//현재 계좌 개설 갯수 = 마지막 계좌번호
	private int tdnum;//현재 거래내역 갯수
	private final int bufacnum = 50;//계좌 버퍼에 생성 갯수 - 시스템이 커질 경우 사이즈 추가
	private final int buftdnum = 500;//계좌 버퍼에 생성 갯수 - 시스템이 커질 경우 사이즈 추가
	private int maxaccount;//최대 계좌 갯수
	private int maxtrade;//최대 거래내역 갯수
	private Account []ac;//계좌 배열
	private Trade []td;//거래내역 배열
	private int detailsnum;//현재 거래내역출력 갯수

	Accontrol()//생성자 호출시 계좌갯수를 받고 계좌배열을 생성하고 저장된 계좌 읽어 옴
	{
		try{
			acnum = 0;
			tdnum = 0;
			File file1 = new File("Accontrol.dat");
			if(file1.exists())
			{
				DataInputStream in = new DataInputStream(new FileInputStream("Accontrol.dat"));
				acnum = in.readInt();
				tdnum = in.readInt();
				in.close();
			}
			ac = new Account [acnum + bufacnum];
			td = new Trade [tdnum + buftdnum];

			maxaccount = acnum + bufacnum;
			maxtrade = tdnum + buftdnum;
			
			File file2 = new File("Account.dat");
			if(file2.exists())
			{
				loaddAccount();
				/*ObjectInputStream ina = new ObjectInputStream(new FileInputStream("Account.dat"));
				for(int i=0;i<acnum;i++)
				{
					ac[i] = (Account)ina.readObject();
				}
				ina.close();*/
			}

			File file3 = new File("Trade.dat");
			if(file3.exists())
			{
				loaddTrade();
				/*ObjectInputStream inb = new ObjectInputStream(new FileInputStream("Trade.dat"));
				for(int i=0;i<tdnum;i++)
				{
					td[i] = (Trade)inb.readObject();
				}
				inb.close();*/
			}
		}
		catch (NumberFormatException ex)
		{
			
		}
		catch (Exception e)
		{
			System.out.println("컨트롤 클래스 로드 오류 발생!");
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getCause());
			System.out.println(e.toString());
		}
	}

	public void saveacc()//계좌,거래내역갯수 저장
	{
		try{
			DataOutputStream out = new DataOutputStream(new FileOutputStream("Accontrol.dat"));
			out.writeInt(acnum);
			out.writeInt(tdnum);
			out.close();
			savedAccount();
			savedTrade();
		}catch (Exception e)
		{
			System.out.println("계좌갯수,거래내역갯수 저장 오류 발생!");
			System.out.println(e.toString());
		}
	}

	public boolean openATMTime()//ATM 사용 가능 체크
	{
		int hour = Calendar.getInstance(Locale.KOREA).get(Calendar.HOUR_OF_DAY);
		if(hour >= 9 && hour < 18)
		{
			return true;
		}
		else return false;
	}

	public void addobj(String objtype)//객체 부족시 객체 배열 추가
	{
		try
		{
			if(objtype.equals("Account"))
			{
				Account []tempac = new Account[maxaccount];
				for(int i=0;i<=maxaccount;i++)
				{
					tempac[i] = ac[i];
				}
				ac = new Account[maxaccount + bufacnum];
				for(int i=0;i<=maxaccount;i++)
				{
					ac[i] = tempac[i];
				}
				maxaccount = maxaccount + bufacnum;
			}
			else if(objtype.equals("Trade"))
			{
				Trade []temptd = new Trade[maxtrade];
				for(int i=0;i<=maxtrade;i++)
				{
					temptd[i] = td[i];
				}
				td = new Trade[maxtrade + buftdnum];
				for(int i=0;i<=maxtrade;i++)
				{
					td[i] = temptd[i];
				}
				maxtrade = maxtrade + buftdnum;
			}
			else
			{
			}
		}
		catch(Exception e)
		{
			System.out.println("객체 배열을 추가하는 중에 오류가 발생 하였습니다.");
			System.out.println(e.toString());
		}
	}

	public long openAccount(long salary,long balance,boolean accounttype,//계좌 개설
		String name,String peoplenumber,String adress,String phonenumber)
	{
		try{
			if(maxaccount == acnum)
			{
				addobj("Account");
			}
			ac[acnum] = new Account(acnum,salary,balance,accounttype,name,peoplenumber,adress,phonenumber);
			long tempaccountnumber = ac[acnum].getAccountnumber();
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Account.dat",true));
			out.writeObject(ac[acnum]);
			acnum++;
			out.close();
			boolean state = saveTrade(tempaccountnumber,balance,true,balance);
			if (!state)
			{
				System.out.println("거래내역 저장 실패!!!");	
			}
			return tempaccountnumber;
		}
		catch (Exception e)
		{
			System.out.println("계좌 개설 실패!!!");
			System.out.println(e.toString());
			return -1;
		}
	}

	public boolean drawing(long accountnumber,long trademoney)
	{
		boolean tstate = false;
		try
		{
			long balance = ac[(int)accountnumber].getBalance();
			boolean accounttype = ac[(int)accountnumber].getAccounttype();
			if(accounttype)
			{
				if(balance >= trademoney)
				{
					ac[(int)accountnumber].setBalance(balance - trademoney);
					tstate = true;

					boolean state = saveTrade(accountnumber,ac[(int)accountnumber].getBalance(),true,trademoney);

					if (!state)
					{
						System.out.println("거래내역 저장 실패!!!");	
					}
				}
			}
			else
			{
				long salary = ac[(int)accountnumber].getSalary();
				if(balance + salary * 0.5 >= trademoney)
				{
					ac[(int)accountnumber].setBalance(balance - trademoney);
					tstate = true;

					boolean state = saveTrade(accountnumber,ac[(int)accountnumber].getBalance(),false,trademoney);
				
					if (!state)
					{
						System.out.println("거래내역 저장 실패!!!");	
					}
				}
			}
			return tstate;
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			return tstate;
		}
	}

	public boolean deposit(long accountnumber,long trademoney)
	{
		boolean tstate = false;
		try
		{
			ac[(int)accountnumber].setBalance(ac[(int)accountnumber].getBalance() + trademoney);
			tstate = true;
			
			boolean state = saveTrade(accountnumber,ac[(int)accountnumber].getBalance(),true,trademoney);
			if (!state)
			{
				System.out.println("거래내역 저장 실패!!!");	
			}
			return tstate;
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			return tstate;
		}
	}

	public boolean saveTrade(long accountnumber,long balance,boolean tradetype,long trademoney)
	{
		boolean state = false; 
		try
		{
			if(maxtrade == tdnum)
			{
				addobj("Trade");
			}
			long time = Calendar.getInstance(Locale.KOREA).getTimeInMillis();
			td[tdnum] = new Trade(accountnumber,time,balance,tradetype,trademoney);
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Trade.dat",true));
			out.writeObject(td[tdnum]);
			tdnum++;
			out.close();
			state = true;
			return state;
		}
		catch (Exception e)
		{
			System.out.println("거래내역 저장 실패!!!");
			System.out.println(e.toString());
			state = false;
			return state;
		}
	}

	public long inquiryBalance(long accountnumber)
	{	
		if(accountnumber < 0 && accountnumber>acnum) return -1;
		return ac[(int)accountnumber].getBalance();
	}

	
	public int findDetailsnum(long accountnumber)
	{
		detailsnum = 0;
		for(int i =0;i<tdnum;i++)
		{
			if(td[i].getAccountnumber() == accountnumber)
			{
				detailsnum++;
			}
		}
		return detailsnum;
	}

	public Trade[] inquiryDetails(long accountnumber)
	{
		int tempdtnum =0;
		Trade[] details = new Trade[detailsnum];
		for(int i =0;i<tdnum;i++)
		{
			if(td[i].getAccountnumber() == accountnumber)
			{
				details[tempdtnum] = td[i];
				tempdtnum++;
			}
		}
		return details;
	}

	
	public int findDetailsnum(long accountnumber,long sday,long lday)
	{
		detailsnum = 0;
		long tempdate;
		for(int i =0;i<tdnum;i++)
		{
			if(td[i].getAccountnumber() == accountnumber)
			{
				tempdate = td[i].getTradedate();
				if(sday <= tempdate && tempdate <= lday){
					detailsnum++;
				}
			}
		}
		return detailsnum;
	}

	public Trade[] inquiryDetails(long accountnumber,long sday,long lday)
	{
		int tempdtnum =0;
		long tempdate;
		Trade[] details = new Trade[detailsnum];
		for(int i =0;i<tdnum;i++)
		{
			if(td[i].getAccountnumber() == accountnumber)
			{
				
				tempdate = td[i].getTradedate();
				if(sday <= tempdate && tempdate <= lday){
					details[tempdtnum] = td[i];
					tempdtnum++;
				}
			}
		}
		return details;
	}
	
	public void loaddAccount()
	{
		try{
			DataInputStream in = new DataInputStream(new FileInputStream("Account.dat"));
			for(int i=0;i<acnum;i++)
			{
				long accountnumber = in.readLong();//계좌번호;
				long salary = in.readLong();//연봉;
				long balance = in.readLong();//잔액;
				boolean  accounttype = in.readBoolean();//계좌유형;
				String name = in.readUTF();//이름
				String peoplenumber = in.readUTF();//주민등록번호
				String adress = in.readUTF();//주소
				String phonenumber = in.readUTF();//전화번호
				ac[i] = new Account(accountnumber,salary,balance,accounttype,name,peoplenumber,adress,phonenumber);
			}
			in.close();
		}
		catch (Exception e)
		{
			System.out.println("계좌 클래스 로드 오류 발생!");
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getCause());
			System.out.println(e.toString());
		}
	}
	
	public void savedAccount()
	{
		try{
			DataOutputStream out = new DataOutputStream(new FileOutputStream("Account.dat"));
			for(int i=0;i<acnum;i++)
			{
				out.writeLong(ac[i].getAccountnumber());//계좌번호;
				out.writeLong(ac[i].getSalary());//연봉;
				out.writeLong(ac[i].getBalance());//잔액;
				out.writeBoolean(ac[i].getAccounttype());//계좌유형;
				out.writeUTF(ac[i].getName());//이름
				out.writeUTF(ac[i].getPeoplenumber());//주민등록번호
				out.writeUTF(ac[i].getAdress());//주소
				out.writeUTF(ac[i].getPhonenumber());//전화번호
			}
			out.close();
		}
		catch (Exception e)
		{
			System.out.println("계좌 클래스 저장 오류 발생!");
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getCause());
			System.out.println(e.toString());
		}
	}

	public void loaddTrade()
	{
		try{
			DataInputStream in = new DataInputStream(new FileInputStream("Trade.dat"));
			for(int i=0;i<tdnum;i++)
			{
				long accountnumber = in.readLong();//계좌번호;
				long tradedate = in.readLong();//날짜
				boolean tradetype = in.readBoolean();//거래유형;
				long trademoney = in.readLong();//거래액;
				long balance = in.readLong();//잔고;
				td[i] = new Trade(accountnumber,tradedate,balance,tradetype,trademoney);
			}
			in.close();
		}
		catch (Exception e)
		{
			System.out.println("거래내역 클래스 로드 오류 발생!");
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getCause());
			System.out.println(e.toString());
		}
	}

	
	public void savedTrade()
	{
		try{
			DataOutputStream out = new DataOutputStream(new FileOutputStream("Trade.dat"));
			for(int i=0;i<tdnum;i++)
			{
				out.writeLong(td[i].getAccountnumber());//계좌번호;
				out.writeLong(td[i].getTradedate());//날짜
				out.writeBoolean(td[i].getTradetype());//거래유형;
				out.writeLong(td[i].getTrademoney());//연봉;
				out.writeLong(td[i].getBalance());//잔고;
			}
			out.close();
		}
		catch (Exception e)
		{
			System.out.println("거래내역 클래스 저장 오류 발생!");
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getCause());
			System.out.println(e.toString());
		}
	}
}
