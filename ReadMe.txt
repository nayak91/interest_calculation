Design:
1)We have used Rabbit MQ to handle events.We have created 3 queues.
2)"account.opening.queue" queue will fetch  events to open new account.
3)"account.balance.queue" will fetch events of new balance info for accounts
4)"account.closing.queue" queue will fetch event to close any account
5)We have created scheduler which will run last day of every month and push monthly interest accrued by  all accounts in "account.interestInfo.event.exchange" queue.
6)we have created Account document in mongodb to store account information.
7)We have created AccountInterestAccruedDailyHistory,AccountMonthlyInterestInfo document
 in mongo to store interest accrued daily and monthly basis.
8)We have created two controller "/findAccountMonthlyInterestInfo","/findAccountsInfo"
using webflux which will return stream of data.
