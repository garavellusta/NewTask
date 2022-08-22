import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Customers> customersList = new ArrayList<>();
        List<Trainers> trainersList = new ArrayList<>();
        List<Equipments> equipmentsList = new ArrayList<>();
        List<ExcercisePlans> excercisePlansList = new ArrayList<>();
        List<Subscriptions> subscriptionsList = new ArrayList<>();


        String fileNameCustomer = "customer.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileNameCustomer))) {
            stream.forEach(lines -> {

                List<String> line = List.of(lines.replace(" ", "").split(","));
                int CustomerID = Integer.parseInt(line.get(0));
                String name = line.get(1);
                String Address = line.get(2);
                int phone = Integer.parseInt(line.get(3));
                String email = line.get(4);
                customersList.add(new Customers(CustomerID, name, Address, phone, email));
            });
        } catch (IOException e) {
            System.err.println(e);
        }


        String fileNameTrainers = "trainers.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileNameTrainers))) {
            stream.forEach(lines -> {

                List<String> line = List.of(lines.replace(" ", "").split(","));
                int TrainerID = Integer.parseInt(line.get(0));
                String name = line.get(1);
                trainersList.add(new Trainers(TrainerID, name));
            });
        } catch (IOException e) {
            System.err.println(e);
        }

        String fileNameEquipments = "equipments.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileNameEquipments))) {
            stream.forEach(lines -> {

                List<String> line = List.of(lines.replace(" ", "").split(","));
                int EquipmentID = Integer.parseInt(line.get(0));
                String name = line.get(1);
                equipmentsList.add(new Equipments(EquipmentID, name));
            });
        } catch (IOException e) {
            System.err.println(e);
        }


        String fileNameExcercisePlans = "excercisePlans.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileNameExcercisePlans))) {
            stream.forEach(lines -> {

                List<String> line = List.of(lines.replace(" ", "").split(","));
                int PlanID = Integer.parseInt(line.get(0));
                int TrainerID = Integer.parseInt(line.get(1));
                int EquipmentID = Integer.parseInt(line.get(2));
                int Duration = Integer.parseInt(line.get(3));
                excercisePlansList.add(new ExcercisePlans(PlanID, TrainerID, EquipmentID, Duration));
            });
        } catch (IOException e) {
            System.err.println(e);
        }

        String fileNameSubscriptions = "subscriptions.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileNameSubscriptions))) {
            stream.forEach(lines -> {

                List<String> line = List.of(lines.replace(" ", "").split(","));
                int PlanID = Integer.parseInt(line.get(0));
                String dateTime = line.get(1);
                int CustomerID = Integer.parseInt(line.get(2));
                int TrainerId = Integer.parseInt(line.get(3));
                int ExerciseID = Integer.parseInt(line.get(4));
                subscriptionsList.add(new Subscriptions(PlanID, dateTime, CustomerID, TrainerId, ExerciseID));
            });
        } catch (IOException e) {
            System.err.println(e);
        }

        int option = 0;
        Scanner input = new Scanner(System.in);


        while (true) {


            System.out.println("**********************");
            System.out.println("1: Add Customer");
            System.out.println("2: Update Customer");
            System.out.println("3: Delete Customer");
            System.out.println("4: Add Trainer");
            System.out.println("5: Delete Trainer");
            System.out.println("6: Add Equipments");
            System.out.println("7: Delete Equipments");
            System.out.println("8: Add ExcercisePlan");
            System.out.println("9: Update ExcercisePlan");
            System.out.println("10: Delete ExcercisePlan");
            System.out.println("11: Add Subscriptions");
            System.out.println("12: Update Subscriptions");
            System.out.println("13: Delete Subscriptions");
            System.out.println("Seciniz :");


            option = input.nextInt();


            switch (option) {

                case 1:
                    System.out.println("Add Customer");

                    System.out.println("CustomerID gir");
                    Scanner scanner = new Scanner(System.in);
                    int customerID = scanner.nextInt();

                    System.out.println("Customer Name gir");
                    Scanner scanner1 = new Scanner(System.in);
                    String customerName = scanner1.nextLine();

                    System.out.println("Adres gir");
                    Scanner scanner2 = new Scanner(System.in);
                    String customerAdress = scanner2.nextLine();

                    System.out.println("Phone gir");
                    Scanner scanner3 = new Scanner(System.in);
                    int customerPhone = scanner3.nextInt();

                    System.out.println("Email gir");
                    Scanner scanner4 = new Scanner(System.in);
                    String customerEmail = scanner4.nextLine();

                    Customers addCustomer = new Customers(customerID, customerName, customerAdress, customerPhone, customerEmail);
                    customersList.add(addCustomer);

                    customersList.forEach(customers -> {
                        System.out.println(customers);
                    });

                    break;
                case 2:
                    System.out.println("Update Customer");

                    System.out.println("ID giriniz");
                    Scanner scanner5 = new Scanner(System.in);
                    int secilenId = scanner5.nextInt();
                    Customers updateAccount = customersList.get(secilenId - 1);


                    customersList.forEach(customers -> {
                        if (customers.getCustomerID() == secilenId){
                            System.out.println("Ne degistirmek istiyorsun");
                            Scanner scanner6 = new Scanner(System.in);
                            String degisen = scanner6.nextLine();
                            if (degisen.equals("Name".toLowerCase(Locale.ROOT))){
                                System.out.println("Yeni name ne olsun");
                                Scanner scanner7 = new Scanner(System.in);
                                String yeniName = scanner7.nextLine();
                                customers.setName(yeniName);
                                System.out.println(customersList);
                            }
                            if (degisen.equals("Address".toLowerCase(Locale.ROOT))){
                                System.out.println("Yeni address ne olsun");
                                Scanner scanner7 = new Scanner(System.in);
                                String newAddress = scanner7.nextLine();
                                customers.setAddress(newAddress);
                                System.out.println(customersList);
                            }
                            if (degisen.equals("Phone".toLowerCase(Locale.ROOT))){
                                System.out.println("Yeni phone ne olsun");
                                Scanner scanner7 = new Scanner(System.in);
                                int newPhone = scanner7.nextInt();
                                customers.setPhone(newPhone);
                                System.out.println(customersList);
                            }
                            if (degisen.equals("Email".toLowerCase(Locale.ROOT))){
                                System.out.println("Yeni email ne olsun");
                                Scanner scanner7 = new Scanner(System.in);
                                String newEmail = scanner7.nextLine();
                                customers.setEmail(newEmail);
                                System.out.println(customersList);
                            }
                        }
                    });

                    break;

                case 3:
                    System.out.println("Delete Customer");
                    Scanner scannerDelete = new Scanner(System.in);
                    int customerDelete = scannerDelete.nextInt();

                    for (int i = 0; i < customersList.size(); i++) {
                        if (customerDelete == customersList.get(i).getCustomerID()) {
                            customersList.remove(customersList.get(i));

                            System.out.println(customersList);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Add Trainer");

                    System.out.println("TrainerID gir");
                    Scanner scanner6 = new Scanner(System.in);
                    int trainerID = scanner6.nextInt();
                    Boolean exists = false;
                    List<Integer> idList = trainersList.stream().map(Trainers::getTrainerID).collect(Collectors.toList());

                    if(!idList.contains(trainerID)){
                        System.out.println("Trainer Name gir");
                        Scanner scanner7 = new Scanner(System.in);
                        String trainerName = scanner7.nextLine();
                        Trainers trainer = new Trainers(trainerID, trainerName);
                        trainersList.add(trainer);
                        System.out.println(trainersList);
                    }else{
                        System.out.println("bu id var");
                        System.out.println(trainersList);
                    }

                    break;

                case 5:
                    System.out.println("Delete Trainer");

                    System.out.println(trainersList);

                    System.out.println("ID gir");
                    Scanner scanner7 = new Scanner(System.in);
                    int deleteTrainer = scanner7.nextInt();

                    for (int i = 0; i < trainersList.size(); i++) {
                        if (deleteTrainer == trainersList.get(i).getTrainerID()) {
                            trainersList.remove(trainersList.get(i));

                            System.out.println(trainersList);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Add Equipments");
                    System.out.println("ID girin");
                    Scanner scanner8 = new Scanner(System.in);
                    int addID = scanner8.nextInt();

                    List<Integer> adID = equipmentsList.stream().map(Equipments :: getEquipmentID).collect(Collectors.toList());

                    if (!adID.contains(addID)){
                        System.out.println("Name gir");
                        Scanner scanner9 = new Scanner(System.in);
                        String addName = scanner9.nextLine();
                        Equipments newEquipments = new Equipments(addID,addName);
                        equipmentsList.add(newEquipments);
                        System.out.println(equipmentsList.toString());
                    }else {
                        System.out.println("Id zaten var");
                        System.out.println(equipmentsList.toString());
                    }
                    break;
                case 7:
                    System.out.println("Delete Equipments");

                    System.out.println("ID gir");
                    Scanner scanner9 = new Scanner(System.in);
                    int deleteEquipments = scanner9.nextInt();

                    for (int i = 0; i < equipmentsList.size(); i++) {
                        if (deleteEquipments == equipmentsList.get(i).getEquipmentID()) {
                            trainersList.remove(equipmentsList.get(i));

                            System.out.println(equipmentsList);
                        }
                    }
                case 8:
                    System.out.printf("Add Exercise Plan" + "\n");

                    System.out.printf("ID girin: ");
                    Scanner scanner11 = new Scanner(System.in);
                    int newExerciseID = scanner11.nextInt();
                    System.out.printf(trainersList.toString()+ "\n");

                    System.out.printf("Trainer ID gir: ");
                    Scanner scanner10 = new Scanner(System.in);
                    int trainerIDexercise = scanner10.nextInt();
                    System.out.printf(equipmentsList.toString()+ "\n");

                    System.out.printf("Equipment ID sec: ");
                    Scanner scanner12 = new Scanner(System.in);
                    int chosenEquipments = scanner12.nextInt();
                    int duratione = 0 ;
                    int CoffeeMug = 30;
                    if (chosenEquipments == 1){
                        duratione = 5;
                    } else if (chosenEquipments == 2) {
                        duratione = 20;
                    }else
                        duratione = CoffeeMug;

                    ExcercisePlans excercisePlans = new ExcercisePlans(newExerciseID,trainerIDexercise,chosenEquipments,duratione);
                    excercisePlansList.add(excercisePlans);
                    System.out.printf(excercisePlansList.toString()+ "\n");

                    break;

                case 9 :
                    System.out.printf("Update Exercise Plan" + "\n");
                    System.out.println(excercisePlansList);
                    System.out.println("Degistirmek istedigin Equipments ID gir");
                    Scanner scanner13 = new Scanner(System.in);
                    int secilenID = scanner13.nextInt();

                    excercisePlansList.forEach(excercisePlans1 -> {
                        if (secilenID == excercisePlans1.getEquipmentID()){
                            System.out.println("Neyi degistirmek istiyorsun");
                            Scanner scanner14 = new Scanner(System.in);
                            String degisenExer = scanner14.nextLine();
                            degisenExer=degisenExer.toLowerCase();
                            if (degisenExer.equals("trainer")){
                                System.out.println(trainersList.toString());
                                System.out.println("Kimi secmek istiyorsunuz (ID)");
                                Scanner scanner15 = new Scanner(System.in);
                                int secilenTrainer = scanner15.nextInt();
                                excercisePlans1.setTrainerID(secilenTrainer);
                                System.out.println(excercisePlansList);
                            }if (degisenExer.equals("equipments")){
                                System.out.println(equipmentsList.toString());
                                System.out.println("Hangi ekipman lazim (ID)");
                                Scanner scanner15 = new Scanner(System.in);
                                int secilenEkipman = scanner15.nextInt();
                                excercisePlans1.setEquipmentID(secilenEkipman);
                                System.out.println(excercisePlansList);
                            }
                        }
                    });
                    break;
                case 10:
                    System.out.println("Delete Exercise Plan");
                    System.out.println(excercisePlansList);
                    System.out.println("ID sec: (equipments ID)");
                    Scanner scanner14 = new Scanner(System.in);
                    int deleteExercise = scanner14.nextInt();

                    for (int i = 0; i < excercisePlansList.size(); i++) {
                        if (deleteExercise == excercisePlansList.get(i).getEquipmentID()) {
                            excercisePlansList.remove(excercisePlansList.get(i));

                            System.out.println(excercisePlansList);
                        }
                    }
                    break;

                case 11:
                    System.out.println("Add Subscriptions");
                    System.out.println("ID gir");
                    Scanner scanner15 = new Scanner(System.in);
                    int addSub = scanner15.nextInt();

                    List<Integer> sublist = subscriptionsList.stream().map(Subscriptions :: getSubscriptionID).collect(Collectors.toList());
                     if (!sublist.contains(addSub)){
                         System.out.println("Tarih girin:   format:(dd-mm-yyyy)");
                         Scanner scanner16 = new Scanner(System.in);
                         String time = scanner16.next();
                         List<String> dateTime = subscriptionsList.stream().map(Subscriptions ::getDateTime).collect(Collectors.toList());
                         if (!dateTime.contains(time)){
                             System.out.printf(customersList.toString());
                             System.out.println("Customer ID gir ");
                             Scanner scanner17 = new Scanner(System.in);
                             int customerSec = scanner17.nextInt();
                             System.out.println(trainersList.toString());
                             System.out.println("TrainerID gir:");
                             Scanner scanner18 = new Scanner(System.in);
                             int trainerSec = scanner18.nextInt();
                             System.out.println("Exercise ID: ");
                             Scanner scanner19 = new Scanner(System.in);
                             int exerciseSec = scanner19.nextInt();
                             Subscriptions subscriptions = new Subscriptions(addSub,time,customerSec,trainerSec,exerciseSec);
                             subscriptionsList.add(subscriptions);
                             System.out.println(subscriptionsList.toString());

                         }else
                             System.out.println("Tarih Dolu");
                     }else
                         System.out.println("ID dolu");
                    break;

                case 12:
                    System.out.println("Update Subscription");
                    System.out.println(subscriptionsList);
                    System.out.println("Degistirmek istedigin subs ID gir:");
                    Scanner scanner16 = new Scanner(System.in);
                    int degisSubs = scanner16.nextInt();
                    subscriptionsList.forEach(subscriptions -> {
                        if (subscriptions.getSubscriptionID() == degisSubs){
                            System.out.println("Ne degistirmek istiyorsun");
                            Scanner scanner17 = new Scanner(System.in);
                            String degisecekSub = scanner17.nextLine();
                            degisecekSub = degisecekSub.toLowerCase();
                            if (degisecekSub.equals("date")){
                                System.out.println(subscriptions.getDateTime());
                                System.out.println("Yeni date girin format (dd-mm-yyyy)");
                                Scanner scanner18 = new Scanner(System.in);
                                String degisenDate = scanner18.nextLine();
                                subscriptions.setDateTime(degisenDate);
                                System.out.println(subscriptionsList.toString());

                            }
                             if (degisecekSub.equals("customer")){
                                System.out.println("Yeni customer ID girin");
                                Scanner scanner18 = new Scanner(System.in);
                                int degisenCustomer = scanner18.nextInt();
                                subscriptions.setCustomerID(degisenCustomer);
                                System.out.println(subscriptionsList.toString());
                            }
                             if (degisecekSub.equals("trainer")){
                                System.out.println("Yeni trainer ID girin");
                                Scanner scanner18 = new Scanner(System.in);
                                int degisenTrainer = scanner18.nextInt();
                                subscriptions.setTrainerID(degisenTrainer);
                                System.out.println(subscriptionsList.toString());
                            }
                             if (degisecekSub.equals("exercise")){
                                System.out.println("Degisecek Exercise ID girin");
                                Scanner scanner18 = new Scanner(System.in);
                                int degisenExercise = scanner18.nextInt();
                                subscriptions.setExerciseID(degisenExercise);
                                System.out.println(subscriptionsList.toString());
                            }
                        }
                    });

                    break;

                case 13:
                    System.out.println("Delete Subscription");
                    System.out.println(subscriptionsList);
                    System.out.println("Silinecek ID Secin");
                    Scanner scanner17 = new Scanner(System.in);
                    int deleteSubs = scanner17.nextInt();

                    for (int i = 0; i < subscriptionsList.size(); i++) {
                        if (deleteSubs == subscriptionsList.get(i).getSubscriptionID()) {
                            subscriptionsList.remove(subscriptionsList.get(i));

                            System.out.println(subscriptionsList);
                        }
                    }
                    break;
            }
        }
    }
}





