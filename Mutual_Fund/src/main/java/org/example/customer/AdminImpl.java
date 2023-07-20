package org.example.customer;

import java.time.LocalDate;
import java.util.*;

import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class AdminImpl {
    public static void main(String[] args) {

        boolean check = true ;
        ArrayList<FundManager> FundManagerList = new ArrayList<>();
        ArrayList<Fund> FundList = new ArrayList<>();
        ArrayList<Customer> CustomerList = new ArrayList<>();
        HashMap<String,List<BuySell>> CustomerHistory = new HashMap<>();

        boolean check1 = true;
        do {
            System.out.println("===========================================================");
            System.out.println("================Welcome Admin==============================");
            System.out.println("===========Press 1 to add New Fund Manager============================");

            System.out.println("===========Press 2 to add New Customer=================");

            Scanner sc1 = new Scanner(System.in);
            int decision = sc1.nextInt();
            sc1.nextLine();
            switch (decision) {
                case 1:
                    do {
                        System.out.println("===========================================================");
                        System.out.println("================Welcome Admin==============================");
                        System.out.println("Do you want to create Login id and password for Fund Manager Y/N");
                        Scanner sc = new Scanner(System.in);
                        String ans = sc.nextLine();
                        System.out.println("===========================================================");
                        System.out.println("=Name of Fund  || Name of Fund Manager || username || Password=");
                        String fundname = sc.nextLine();
                        String fundmanagername = sc.nextLine();
                        String fmusername = sc.nextLine();
                        String fmpassword = sc.nextLine();

                        Fund F1 = new Fund(fundname, 0);
                        FundList.add(F1);

                        FundManagerList.add(new FundManager(fundmanagername, fmusername, F1, fmpassword));

                        System.out.println("===========================================================");
                        System.out.println("Do you want to continue to add fund manager true/false");
                        check = sc.nextBoolean();


                    } while (check);

                    break;
/*
                case 2:
                    do {
                        System.out.println("==================================================================");
                        System.out.println("================Welcome Fund Manager==============================");

                        Scanner sc = new Scanner(System.in);
                        System.out.println("===================Enter username and Password==================");
                        System.out.println("================================================================");

                        String uname = sc.nextLine();
                        String pass = sc.nextLine();

                        Stream<FundManager> fundManagerStream = FundManagerList.stream().filter(fm -> fm.getUsername().equalsIgnoreCase(uname));

                        System.out.println("==================================================================");


                    } while (check);
                    break;
*/
                case 2:
                    do {

                        System.out.println("==================================================================");
                        System.out.println("====================Welcome Customer==============================");
                        System.out.println("=====================Do you have an account Y/N=======================");
                        Scanner sc = new Scanner(System.in);
                        String s = sc.nextLine();
                        if (s.equalsIgnoreCase("y")) {
                            System.out.println("Enter Username and Password");
                            String uname = sc.nextLine();
                            String pass = sc.nextLine();
                            Stream<Customer> customerStream = CustomerList.stream().filter(cm -> cm.getUsername().equals(uname));
                            Priceallocation PA = new Priceallocation();
                            FundList = PA.priceallocation(FundList);
                            System.out.println("After Price Allocation"+ FundList);
                            System.out.println("===========================Your details=================================================");
                            System.out.println(customerStream);
                            boolean checkcustomer = true;
                            do{
                                System.out.println("Press 1 to buy funds");
                                System.out.println("Press 2 to sell funds");
                                System.out.println("Press 3 to check holdings");
                                int customerdecision = sc.nextInt();
                                sc.nextLine();
                                int flag =0;
                                if(customerdecision==1){
                                    System.out.println("We have the following funds to buy");
                                    FundList.stream().forEach(fl -> System.out.println(fl.getName()));
                                    System.out.println("Please enter the name of the fund you want to buy");
                                    String buyFundName = sc.nextLine();
                                    System.out.println("Enter number of units to buy");
                                    int size = sc.nextInt();
                                    sc.nextLine();
                                    int l =0;
                                    int checkIfFundAvailable = 0;
                                    boolean isFundAvailable = FundList.stream().anyMatch(fl -> fl.getName().equalsIgnoreCase(buyFundName));
                                    List<Fund> fundToGetNav = FundList.stream().filter(fl -> fl.getName().equalsIgnoreCase(buyFundName)).collect(Collectors.toList());
                                    if(isFundAvailable) {
                                        System.out.println("-------------------------------------");
                                        for (int i = 0; i < CustomerList.size(); i++) {
                                            if (CustomerList.get(i).getUsername().equalsIgnoreCase(uname)) {
                                                for (int y = 0; y < CustomerList.get(i).getUserFunds().size(); y++) {
                                                    if(CustomerList.get(i).getUserFunds().get(y).getName().equalsIgnoreCase(buyFundName)) {

                                                        checkIfFundAvailable=1;
                                                        int cnt = CustomerList.get(i).getUserFunds().get(y).getSize();
                                                        CustomerList.get(i).getUserFunds().get(y).setSize(cnt+size);





                                                        System.out.println("********************");

                                                        for (Map.Entry<String,List<BuySell>> entry : CustomerHistory.entrySet()) {
                                                            if(entry.getKey().equalsIgnoreCase(uname)){
                                                                List<BuySell> templist = new ArrayList<>();
                                                                templist = entry.getValue();

                                                                BuySell b =new BuySell(1,buyFundName,size,fundToGetNav.get(0).getNAV());
                                                                templist.add(b);
                                                                CustomerHistory.put(uname,templist);
                                                                System.out.println("Inside buy already present" + CustomerHistory);
                                                                flag=1;
                                                                break;
                                                            }
                                                        }





                                                    }
                                                }
                                                if(checkIfFundAvailable==0){
                                                    for (int u = 0; u < CustomerList.size(); u++) {
                                                        if (CustomerList.get(u).getUsername().equalsIgnoreCase(uname)) {
                                                            System.out.println("==============yyyyyyyyyy===========");
                                                            CustomerList.get(u).getUserFunds().add(new Portfolio(buyFundName.toUpperCase(), size,
                                                                    fundToGetNav.get(0).getNAV()));
                                                        }
                                                    }

                                                    if(CustomerHistory.containsKey(uname)){
                                                        for (Map.Entry<String,List<BuySell>> entry : CustomerHistory.entrySet()) {
                                                            if(entry.getKey().equalsIgnoreCase(uname)){
                                                                List<BuySell> templist = new ArrayList<>();
                                                                templist = entry.getValue();

                                                                BuySell b =new BuySell(1,buyFundName,size,fundToGetNav.get(0).getNAV());
                                                                templist.add(b);
                                                                CustomerHistory.put(uname,templist);
                                                                System.out.println("Inside buy new " + CustomerHistory);

                                                                break;
                                                            }
                                                        }
                                                    }
                                                    else{

                                                        ArrayList<BuySell> history = new ArrayList<>();
                                                        history.add(new BuySell(1, buyFundName, size, fundToGetNav.get(0).getNAV()));

                                                        System.out.println("***********************************************************************************************");
                                                        CustomerHistory.put(uname, history);

                                                        System.out.println("Inside buy first time" + CustomerHistory);
                                                        break;
                                                    }
                                                }

                                            }




                                        }

                                    }
                                    else {
                                        System.out.println("Entered wrong Fund name");
                                    }
                                }
                                else if (customerdecision==3) {

                                    for (int i =0 ; i< CustomerList.size();i++){
                                        if(CustomerList.get(i).getUsername().equalsIgnoreCase(uname)){
                                            for (int j =0 ; j < CustomerList.get(i).getUserFunds().size();j++){
                                                System.out.println("--Name--"+CustomerList.get(i).getUserFunds().get(j).getName()+"--NAV--"+CustomerList.get(i).getUserFunds().get(j).getNAV()+"--Qty--"+CustomerList.get(i).getUserFunds().get(j).getSize()+"--Current Amount--"+CustomerList.get(i).getUserFunds().get(j).getNAV()*CustomerList.get(i).getUserFunds().get(j).getSize());
                                            }
                                        }


                                    }

                                }
                                else if(customerdecision==2){
                                    System.out.println("You have following funds");

                                    System.out.println("Please enter the name of the fund you want to sell");
                                    String sellFundName = sc.nextLine();
                                    System.out.println("Enter number of units to sell");
                                    int size = sc.nextInt();
                                    sc.nextLine();
                                    boolean isFundAvailable = FundList.stream().anyMatch(fl -> (fl.getName().equalsIgnoreCase(sellFundName)));
                                    System.out.println("+++++++++++++++++++");

                                    int BuyAmout=0;
                                    int SellAmount = 0;
                                    int SellQuantity=0;
                                    int BuyQuantity=0;
                                    int Quatity=0;
                                    int o=0;
                                    for (int i =0 ; i< CustomerList.size();i++){
                                        if(CustomerList.get(i).getUsername().equalsIgnoreCase(uname)){
                                            System.out.println("inside for ------------------");
                                            for (int j =0 ; j < CustomerList.get(i).getUserFunds().size();j++){
                                                if(CustomerList.get(i).getUserFunds().get(j).getName().equalsIgnoreCase(sellFundName)){
                                                    o=1;

                                                    for (Map.Entry<String,List<BuySell>> entry : CustomerHistory.entrySet()){
                                                        if(entry.getKey().equalsIgnoreCase(uname)){
                                                            for(int k = 0; k < entry.getValue().size();k++){
                                                                if(entry.getValue().get(k).getName().equalsIgnoreCase(sellFundName)){

                                                                    if(entry.getValue().get(k).getBuysellstatus()==1){
                                                                        System.out.println(entry.getValue());
                                                                        BuyAmout = BuyAmout + entry.getValue().get(k).getAmount()*entry.getValue().get(k).getSize();
                                                                        BuyQuantity = BuyQuantity + entry.getValue().get(k).getSize();
                                                                        System.out.println("Buy--"+BuyQuantity+"--"+BuyAmout);
                                                                    } else if (entry.getValue().get(k).getBuysellstatus()==0) {
                                                                        SellAmount = SellAmount +entry.getValue().get(k).getAmount()*entry.getValue().get(k).getSize();
                                                                        SellQuantity = SellQuantity + entry.getValue().get(k).getSize();
                                                                        System.out.println("Sell--"+SellAmount+"--"+SellQuantity);
                                                                    }

                                                                }

                                                            }

                                                        }

                                                    }
                                                    SellQuantity=SellQuantity+size;
                                                    if(SellQuantity==0){

                                                        SellQuantity=size;
                                                    }

                                                    if(BuyAmout>=SellAmount){
                                                        System.out.println("Amount greater");
                                                    }
                                                    if(BuyQuantity>=SellQuantity){
                                                        System.out.println("Quantity greater");
                                                    }
                                                    if(BuyQuantity!=0){
                                                        System.out.println("Buy not 0");
                                                    }

                                                    if(BuyAmout>=SellAmount && BuyQuantity>=SellQuantity && BuyQuantity!=0){
                                                        System.out.println("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{");
                                                        System.out.println("OOOO value"+o);
                                                        Quatity = BuyQuantity-SellQuantity;
                                                        List<Fund> fundToGetNav = FundList.stream().filter(fl -> fl.getName().equalsIgnoreCase(sellFundName)).collect(Collectors.toList());
                                                        CustomerList.get(i).getUserFunds().get(j).setSize(Quatity);
                                                        System.out.println(Quatity);
                                                        ArrayList<BuySell> history = new ArrayList<>();
                                                        history.add(new BuySell(0,sellFundName,size,fundToGetNav.get(0).getNAV()));

                                                        System.out.println("********************");
                                                        //CustomerHistory.put(uname,history);

                                                        for (Map.Entry<String,List<BuySell>> entry : CustomerHistory.entrySet()) {
                                                            if(entry.getKey().equalsIgnoreCase(uname)){
                                                                List<BuySell> templist = new ArrayList<>();
                                                                templist = entry.getValue();
                                                                o=1;
                                                                BuySell b =new BuySell(0,sellFundName,size,fundToGetNav.get(0).getNAV());
                                                                templist.add(b);
                                                                CustomerHistory.put(uname,templist);
                                                                System.out.println("Inside sell already present present" + CustomerHistory);
                                                                break;
                                                            }
                                                        }
                                                        System.out.println(CustomerList.get(i).getUserFunds());
                                                        System.out.println(FundManagerList);
                                                        System.out.println(FundList);
                                                        System.out.println(CustomerList);
                                                        System.out.println(CustomerHistory);
                                                        System.out.println("********************");
                                                        break;
                                                    }
                                                    else{
                                                        System.out.println("dont have enough share---");
                                                    }

                                                }
                                                else{
                                                    System.out.println("You do not have enough units to sell");
                                                }
                                            }
                                            break;
                                        }


                                    }


                                }
                                System.out.println("Do you want to continue to buy or sell funds true/false");
                                checkcustomer = sc.nextBoolean();

                            }while(checkcustomer);

                        } else {
                            System.out.println("Please Enter your Name, age, Pan Card number, username, password,email,address,pincode");
                            String name = sc.nextLine();
                            int age = sc.nextInt();
                            sc.nextLine();
                            String panCard = sc.nextLine();
                            String username = sc.nextLine();
                            String password = sc.nextLine();
                            String email = sc.nextLine();
                            String address = sc.nextLine();
                            int pincode = sc.nextInt();
                            sc.nextLine();
                            ArrayList<Portfolio> userFund = new ArrayList<>();

                            CustomerList.add(new Customer(name, age, panCard, username, password, email, address, pincode,userFund,0));
                            System.out.println("============Customer Registration Successfull=====================");
                        }
                        System.out.println("===========================================================");
                        System.out.println("Do you want to go ack to previous menu customer true/false");
                        check = sc.nextBoolean();


                    } while (check);
                    break;
            }
            System.out.println(FundManagerList);
            System.out.println(FundList);
            System.out.println(CustomerList);
            System.out.println(CustomerHistory);


        }while(check1);
    }



}
