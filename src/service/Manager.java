package service;
import entity.Phone;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager {
    private static List<Phone> phoneList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String FILE_DATA_Genuine ="src/Data/dataGenuinePhone.csv";
    private static final String FILE_DATA_CELL ="src/Data/dataCellPhone.csv";
    private static Pattern patternPhone = Pattern.compile("[a-zA-Z0-9\\s]{2,12}");
//    private static Pattern patternPrice = Pattern.compile("[1-9]{12}");
    private static Matcher matcher;
    private static int id = 0;

    public static void main(String[] args) {
        boolean cont = true;
        do {
            Menu.Menu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case Constant.CREATE_PHONE:
                    addPhone();
                    break;
                case Constant.DELETE_PHONE:
                    deletePhone();
                    break;
                case Constant.DISPLAY_PHONE:
                    displayPhoneList();
                    break;
                case Constant.FIND_PHONE:
                    findPhone();
                    break;
                case Constant.EXIT:
                    cont = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }while (cont);
    }
    private static void addPhone() {
        System.out.print("Mời bạn nhập số lượng cần nhập thông tin: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < number; i++){
            id++;
            System.out.println("Mời bạn nhập thông tin sản phẩm");
            System.out.print("Tên sản phẩm: ");
            String name = scanner.nextLine();
            while (!isPhone(name)){
                System.out.println("Tên sản phẩm phải gồm từ 2 đến 7 ký tự, chứa chữ cái và số. Mời bạn nhập lại.");
                name = scanner.nextLine();
            }
            System.out.print("Giá sản phẩm: ");
            double price = scanner.nextDouble();
//            while (!isPrice(price)){
//                System.out.println("Giá sản phẩm phải lớn hơn 0 và không quá 1 tỏi. Mời bạn nhập lại.");
//                price = scanner.nextDouble();
//                scanner.nextLine();
//            }
            System.out.print("Số lượng sản phẩm: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nhà sản xuất: ");
            String producer = scanner.nextLine();
            Phone phone = createPhone(id, name, price, quantity, producer);
            phoneList.add(phone);
        }
        System.out.println("Thêm thông tin thành công!");
    }
    private  static void deletePhone(){
        System.out.print("Nhập tên cần tìm: ");
        String findName1 = scanner.nextLine();
        Phone removePhone = findPhoneByName(findName1);
        if (removePhone != null){
            phoneList.remove(removePhone);
            System.out.println("Xóa thành công");
        }else
            System.out.println("Không có số điện thoại");
    }
    private static void findPhone(){
        System.out.print("Nhập tên cần tìm: ");
        String findName1 = scanner.nextLine();
        Phone phone = findPhoneByName(findName1);
        if (findName1 != null){
            System.out.println("Tên bạn cần tìm là: ");
            System.out.println(phone.toString());
        }else
            System.out.println("Không có sản phẩm này");

    }
    private static Phone findPhoneByName(String findName1){
        for (Phone phone : phoneList){
            String findName = phone.getName();
            if (phone.equals(findName)){
                return phone;
            }
        }
        return null;
    }
    static Phone createPhone(int id, String name, double price, int quantity, String producer){
          return new Phone(id, name, price, quantity, producer);
    }
    private static void displayPhoneList(){
        for(Phone phone : phoneList){
            System.out.println(phone);
            }
    }
    private static boolean isPhone(String name) {
        matcher = patternPhone.matcher(name);
        return matcher.matches();
    }
//    private static boolean isPrice(double price) {
//        String priceStr = String.valueOf(price);
//        matcher = patternPrice.matcher(priceStr);
//        return matcher.matches();
//    }
}
