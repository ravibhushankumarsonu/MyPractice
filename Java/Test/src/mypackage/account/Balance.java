package mypackage.account;

public class Balance {
	String name;
	double balance;
	Balance(String name,double balance){
		this.name=name;
		this.balance=balance;
	}
	
	void show() {
		if(balance<0)
			System.out.println("--->");
		System.out.println("name : $"+balance);
	}
}

