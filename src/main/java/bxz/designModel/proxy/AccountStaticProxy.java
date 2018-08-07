package bxz.designModel.proxy;

/**
 * Created by SQ_BXZ on 2018-08-07.
 */
public class AccountStaticProxy implements Account {

	private AccountImpl account;

	public AccountStaticProxy(AccountImpl account) {
		this.account = account;
	}

	public void queryAccount() {
		System.out.println("before-query--");
		// 调用委托类的具体方法
		account.queryAccount();
		System.out.println("after-query--");
	}

	public void updateAccount() {
		System.out.println("before--update---");
		// 调用委托类的具体方法
		account.updateAccount();
		System.out.println("after-update--");

	}
}
