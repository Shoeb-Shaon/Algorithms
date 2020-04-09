import java.util.Hashtable;
import java.util.Scanner;

/**
 * @author Shoeb_Shaon
 */
public class Hash {

    public static Hashtable<String, String> table = new Hashtable<>();
    public static void main(String[] args) {
        int i = 100;
        Scanner sc = new Scanner(System.in);
        while (i != 0) {

            System.out.println("1 = Insert number\n2 = Find number\n3 = Delete number\n0 = exit\n");
            i = sc.nextInt();
            if (i == 1) {
                System.out.println("Enter Name:");
                String n = sc.next();
                if (table.containsKey(n)) {
                    System.out.println(n + " already exists. Is it a different contact?");
                    String x = sc.next();
                    if (x.equals("No")) {
                        System.out.println("Do you want to replace it?");
                        String h = sc.next();
                        if (h.equals("Yes")) {
                            System.out.println("Enter Number:");
                            String z = sc.next();
                            hash.replace(n, z);
                        } else if (x.equals("Yes")) {
                        } else if (x.equals("No")) {
                            System.out.println("Enter Number:");
                            String f = sc.next();
                            hash.add(n, f);
                        }
                    }
                } else {
                    System.out.println("Enter Number:");
                    String num = sc.next();
                    hash.add(n, num);
                }
            }
            if (i == 2) {
                System.out.println("Enter Name to search:");
                String n = sc.next();
                hash.search(n);
            }
            if (i == 3) {
                System.out.println("Enter Name to Remove:");
                String n = sc.next();
                hash.remove(n);
            }
        }
    }

    public static class hash {

        public static void add(String x, String y) {
            table.put(x, y);
            System.out.println("Number inserted successfully");
        }

        public static void replace(String x, String y) {
            table.put(x, y);
            System.out.println("Number replaced successfully");
        }

        public static void remove(String x) {
            if (table.get(x) != null) {
                table.remove(x);
                System.out.println(x + "'s Number deleted successfully");
            } else {
                System.out.println("Number Not Found");
            }
        }

        public static void search(String x) {
            if (table.get(x) == null) {
                System.out.println("Not Found");
            } else {
                System.out.println(x + "'s Number: " + table.get(x));
            }
        }
    }
}