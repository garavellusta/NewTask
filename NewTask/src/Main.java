import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        List<Customers> customersList = new ArrayList<>();
        List<Trainers> trainersList = new ArrayList<>();
        List<Equipments> equipmentsList = new ArrayList<>();
        List<ExcercisePlans> excercisePlansList= new ArrayList<>();
        List<Subscriptions> subscriptionsList = new ArrayList<>();


        String fileNameCustomer = "customer.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileNameCustomer))){
            stream.forEach(lines -> {

                List<String> line = List.of(lines.replace(" ","").split(","));
                int CustomerID = Integer.parseInt(line.get(0));
                String name = line.get(1);
                String Address = line.get(2);
                int phone = Integer.parseInt(line.get(3));
                String email = line.get(4);
                customersList.add(new Customers(CustomerID,name,Address,phone,email));
            });
        }
        catch (IOException e) {
            System.err.println(e);
        }



        String fileNameTrainers = "trainers.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileNameTrainers))){
            stream.forEach(lines -> {

                List<String> line = List.of(lines.replace(" ","").split(","));
                int TrainerID = Integer.parseInt(line.get(0));
                String name = line.get(1);
                trainersList.add(new Trainers(TrainerID,name));
            });
        }
        catch (IOException e) {
            System.err.println(e);
        }

        String fileNameEquipments = "equipments.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileNameEquipments))){
            stream.forEach(lines -> {

                List<String> line = List.of(lines.replace(" ","").split(","));
                int EquipmentID = Integer.parseInt(line.get(0));
                String name = line.get(1);
                equipmentsList.add(new Equipments(EquipmentID,name));
            });
        }
        catch (IOException e) {
            System.err.println(e);
        }


        String fileNameExcercisePlans = "excercisePlans.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileNameExcercisePlans))){
            stream.forEach(lines -> {

                List<String> line = List.of(lines.replace(" ","").split(","));
                int PlanID = Integer.parseInt(line.get(0));
                int TrainerID= Integer.parseInt(line.get(1));
                int EquipmentID = Integer.parseInt(line.get(2));
                int Duration = Integer.parseInt(line.get(3));
                excercisePlansList.add(new ExcercisePlans(PlanID,TrainerID,EquipmentID,Duration));
            });
        }
        catch (IOException e) {
            System.err.println(e);
        }

        String fileNameSubscriptions = "subscriptions.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileNameSubscriptions))){
            stream.forEach(lines -> {

                List<String> line = List.of(lines.replace(" ","").split(","));
                int PlanID = Integer.parseInt(line.get(0));
                String dateTime = line.get(1);
                int CustomerID = Integer.parseInt(line.get(2));
                int TrainerId = Integer.parseInt(line.get(3));
                int ExerciseID = Integer.parseInt(line.get(4));
                subscriptionsList.add(new Subscriptions(PlanID,dateTime,CustomerID,TrainerId,ExerciseID));
            });
        }
        catch (IOException e) {
            System.err.println(e);
        }

        int option =0;
        Scanner input = new Scanner(System.in);


        while (true){



            System.out.println("**********************");
            System.out.println("1: Add Customer");
            System.out.println("2: Update Customer");
            System.out.println("3: Delete Customer");
            System.out.println("4: Add Trainer");
            System.out.println("5: Delete Trainer");
            System.out.println("6: Add Equipments");
            System.out.println("7: Delete Equipments");
            System.out.println("8: Add Subscriptions");
            System.out.println("9: Update Subscriptions");
            System.out.println("10: Delete Subscriptions");
            System.out.println("Seciniz :");


            option = input.nextInt();


            switch (option){

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
                    String  customerEmail = scanner4.nextLine();

                    Customers addCustomer = new Customers(customerID,customerName,customerAdress,customerPhone,customerEmail);
                    customersList.add(addCustomer);

                    customersList.forEach(customers -> {
                        System.out.println(customers);
                    });

                    break;
                case 2:
                    System.out.println("Update Customer");
                    

                case 3:
                    System.out.println("Delete Customer");
                    Scanner scanner5 = new Scanner(System.in);
                    int customerDelete = scanner5.nextInt();

                    for (int i = 0 ; i< customersList.size();i++){
                        if (customerDelete == customersList.get(i).getCustomerID()){
                            customersList.remove(customersList.get(i));

                            System.out.println(customersList);
                        }
                    }
                    break;



        }






        }




    }

}







