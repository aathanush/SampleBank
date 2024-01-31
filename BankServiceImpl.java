public class BankServiceImpl implements BankService{
    @Override 
    public Double addFundsToAccount(Account account, Double amount) throws AccountException{

        if(account == null) {
            
            throw new AccountException("Account null.");
        }
        if(amount <0) {
           
            throw new AccountException("You cant add -ve Banalce.");
        }
        Double newBalance = account.getBalance();
        newBalance +=amount;
        account.setBalance(newBalance);
        return newBalance;

    }

    @Override
    public Double withdrawFunds(Account account, Double amount) throws AccountException {
        if (account == null){
            throw new AccountException("Account null");
        }
        if (account.getBalance < amount){
            throw new AccountException("Insufficient Balance");
        }
        account.setBalance(account.getBalance()-amount);
        return account.getBalance();
    }

    @Override
    public Double displayBalance(Account account) {
        return account.getBalance();
    }

    @Override
    public Boolean fundTransfer(Account fromAccount, Account toAccount, Double amount) throws AccountException {
        if (fromAccount.getBalance()<amount)
        {
            throw new AccountException("Insufficient Balance");
        }
        
        withdrawFunds(fromAccount,amount);
        addFundsToAccount(toAccount,amount);
        return true;
    }
}
