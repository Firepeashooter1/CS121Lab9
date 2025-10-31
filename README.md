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

> > makeDeposit
> > > prompt a deposit and amt ← getDouble(scanner)
> > > if amt less than or equal to 0 
> > > > display positive and return
> > > balance ← balance + amt and display forrmatted balance

> > makeWithdrawal
> > > promt a withdraw and amt ← getDouble(scanner)
> > > if amt less than or equal to zero 
> > > > Display positive and return
> > > if amt greater than balance 
> > > > display insffucent funds and return
> > > balance ← balance - amt and formatted balance

