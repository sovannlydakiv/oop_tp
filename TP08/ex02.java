import java.util.*;

class Account {
    private String accountId;
    private String holderName;
    private double balance;

    private static final double MIN_BALANCE = 0.0;
    private static final double MAX_BALANCE = 100000.0;
    private static final double MAX_DEPOSIT = 1000.0;

    public Account(String accountId, String holderName, double initialBalance) {
        this.accountId = accountId;
        this.holderName = holderName;
        this.balance = initialBalance;
    }

    public String getAccountId() { 
        return accountId; 
    }
    public void setAccountId(String accountId) { 
        this.accountId = accountId; 
    }
    public String getHolderName() { 
        return holderName; 
    }
    public void setHolderName(String holderName) { 
        this.holderName = holderName; 
    }
    public double getBalance() { 
        return balance; 
    }

    public void deposit(double amount) {
        if (amount <= 0 || amount > MAX_DEPOSIT)
            throw new IllegalArgumentException("Deposit amount must be > 0 and <= $1000.00");
        if (Math.round(amount * 100.0) / 100.0 != amount)
            throw new IllegalArgumentException("Amount must have at most 2 decimal places.");
        if (balance + amount > MAX_BALANCE)
            throw new IllegalArgumentException("Deposit would exceed maximum balance of $" + MAX_BALANCE);
        balance = Math.round((balance + amount) * 100.0) / 100.0;
    }

    public void withdraw(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Withdrawal amount must be greater than 0.");
        if (Math.round(amount * 100.0) / 100.0 != amount)
            throw new IllegalArgumentException("Amount must have at most 2 decimal places.");
        if (balance - amount < MIN_BALANCE)
            throw new IllegalArgumentException("Insufficient funds. Balance cannot go below $0.00");
        balance = Math.round((balance - amount) * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "ACC_ID: " + accountId + "\nACC_HOLDER: " + holderName + "\nACC_BALANCE: " + String.format("%.2f", balance) + "$";
    }
}

public class ex02 {
    private ArrayList<Account> accounts;

    public ex02() {
        accounts = new ArrayList<>();
        accounts.add(new Account("00000000111", "Chiv Inthera", 506.67));
        accounts.add(new Account("00000000222", "Chheng Kimter", 677.69));
        accounts.add(new Account("00000000333", "Kiv Sovannlyda", 603.34));
        accounts.add(new Account("000000004444", "Sao Dali Inaco", 767.67));
    }

    private Account findAccount(String accountId) {
        for (Account acc : accounts)
            if (acc.getAccountId().equals(accountId)) return acc;
        return null;
    }

    private double parseAmount(String input) {
        try {
            double value = Double.parseDouble(input);
            String[] parts = String.valueOf(value).split("\\.");
            if (parts.length > 1 && parts[1].length() > 2)
                throw new IllegalArgumentException("Amount must have at most 2 decimal places.");
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid numeric input.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ex02 bank = new ex02();

        while (true) {
            System.out.println("\n:::: The Bank ::::");
            System.out.println("1. Account List");
            System.out.println("2. Create an account");
            System.out.println("3. Deposit to an account");
            System.out.println("4. Withdraw from an account");
            System.out.println("5. Transfer to another account");
            System.out.println("6. Quit");
            System.out.print("Choose an opt: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid option."); continue;
            }

            System.out.println("Option: " + choice);

            if (choice == 1) {
                System.out.println(":::: Account List ::::");
                if (bank.accounts.isEmpty()) { 
                    System.out.println("No accounts found."); 
                    continue; 
                }
                for (int i = 0; i < bank.accounts.size(); i++) {
                    System.out.println("No #" + (i + 1));
                    System.out.println(bank.accounts.get(i));
                    System.out.println();
                }
            } 
            else if (choice == 2) {
                System.out.print("Enter Account ID: ");
                String id = sc.nextLine().trim();

                if (bank.findAccount(id) != null) { 
                    System.out.println("Account ID already exists."); 
                    continue; 
                }
                System.out.print("Enter Account Holder Name: ");
                String name = sc.nextLine().trim();
                System.out.print("Enter Initial Balance: ");
                try {
                    double init = bank.parseAmount(sc.nextLine().trim());
                    bank.accounts.add(new Account(id, name, init));
                    System.out.println("Account created successfully.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } 
            else if (choice == 3) {
                System.out.print("Enter Account ID: ");
                Account acc = bank.findAccount(sc.nextLine().trim());
                if (acc == null) { 
                    System.out.println("Account not found."); 
                    continue; 
                }
                System.out.print("Enter deposit amount: ");
                try {
                    acc.deposit(bank.parseAmount(sc.nextLine().trim()));
                    System.out.printf("Deposit successful. New balance: %.2f$%n", acc.getBalance());
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } 
            else if (choice == 4) {
                System.out.print("Enter Account ID: ");
                Account acc = bank.findAccount(sc.nextLine().trim());
                if (acc == null) { 
                    System.out.println("Account not found."); 
                    continue;
                }
                System.out.print("Enter withdrawal amount: ");
                try {
                    acc.withdraw(bank.parseAmount(sc.nextLine().trim()));
                    System.out.printf("Withdrawal successful. New balance: %.2f$%n", acc.getBalance());
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else if (choice == 5) {
                System.out.print("Enter sender Account ID: ");
                Account sender = bank.findAccount(sc.nextLine().trim());

                if (sender == null) { 
                    System.out.println("Sender account not found."); 
                    continue; 
                }
                System.out.print("Enter receiver Account ID: ");
                Account receiver = bank.findAccount(sc.nextLine().trim());
                if (receiver == null) { 
                    System.out.println("Receiver account not found."); 
                    continue; 
                }
                if (sender.getAccountId().equals(receiver.getAccountId())) {
                    System.out.println("Cannot transfer to the same account."); 
                    continue;
                }
                System.out.print("Enter transfer amount: ");
                try {
                    double amount = bank.parseAmount(sc.nextLine().trim());
                    sender.withdraw(amount);
                    receiver.deposit(amount);
                    System.out.printf("Transfer successful. %s new balance: %.2f$%n", sender.getHolderName(), sender.getBalance());
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } 
            else if (choice == 6) {
                System.out.println("Goodbye!"); break;
            } 
            else {
                System.out.println("Invalid option.");
            }
        }
        sc.close();
    }
}