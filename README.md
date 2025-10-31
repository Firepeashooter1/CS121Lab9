# CS121Lab9


> CheckingAccount
> > Display prompts
> > Return the menu as a string
> > start
> > > while done is false do
> > > > display the menu and choice ← getInt(scanner)
> > > > switch choice
> > > > > case 1-3 and Defult to the right part
> > getBalance
> > > Return the current balance
> > getBalanceString
> > > Format and return balance as "$xx.xx".
> > setBalance newBalance
> > > set balance as newBalance
> > checkBalance
> > > display formatting balance
> > getDouble scanner
> > > try
> > > > read input line from scanner and trim spaces
> > > > convert input to double
> > > > return that number
> > > catch NumberFormatException
> > > > display "Invalid number entered. Using 0.0."
> > > > return 0.0
> > getInt
> > > try
> > > > read input line from scanner and trim spaces
> > > > convert input to integer
> > > > return that integer
> > > catch NumberFormatException
> > > > return -1
> > makeDeposit scanner
> > > promit for a deposit into a getDouble scanner
> > > if amt <= 0 then
> > > > display "Deposit amount must be positive."
> > > balance ← balance + amt
> > > display formatting balnace
> > makeWithdrawal scanner
> > > promit for withdraw and into a getDouble scanner
> > > if  amt <= 0 then
> > > > display "Withdrawal amount must be positive." and return 
> > > if amt > balance then
> > > > display "Insufficient funds. Current balance: " + formatted balance and return
