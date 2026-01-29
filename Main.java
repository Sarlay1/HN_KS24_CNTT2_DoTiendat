import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = new String[100];
        int n = 0;
        int choice;

        do {
            System.out.println("MENU");
            System.out.println("1. Hiển thị mssv");
            System.out.println("2. Thêm mới (có regex)");
            System.out.println("3. Cập nhật thông tin");
            System.out.println("4. Xóa mssv");
            System.out.println("5. Cập nhật");
            System.out.println("6. Thoát");
            choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                if(n==0) {
                    System.out.println("Danh sách rỗng");
                } else {
                    for (int i = 0; i < n; i++) {
                        System.out.println((i + 1) + " " + arr[i]);
                    }
                }
            } else if (choice == 2) {
                if (n == 100) {
                    System.out.println("Mảng da day!");
                } else {
                    String mssv;
                    do {
                        System.out.print("Nhập MSSV: ");
                        mssv = sc.nextLine();
                    } while (!mssv.matches("^B\\d{7}$"));

                    arr[n] = mssv;
                    n++;
                    System.out.println("Thêm thành cong!");
                }
            }

            else if (choice == 3) {
                System.out.print("Nhap vi tri can sua: ");
                int pos = Integer.parseInt(sc.nextLine());

                if (pos < 1 || pos > n) {
                    System.out.println("Vị trí không hợp lê");
                } else {
                    String mssv;
                    do {
                        System.out.print("Nhap MSSV moi: ");
                        mssv = sc.nextLine();
                    } while (!mssv.matches("^B\\d{7}$"));

                    arr[pos - 1] = mssv;
                    System.out.println("Cap nhat thanh cong");
                }
            }


            else if (choice == 4) {
                System.out.print("Nhap MSSV can xoa: ");
                String xoa = sc.nextLine();

                int index = -1;
                for (int i = 0; i < n; i++) {
                    if (arr[i].equalsIgnoreCase(xoa)) {
                        index = i;
                        break;
                    }
                }

                if (index == -1) {
                    System.out.println("Khong tim thay!");
                } else {
                    for (int i = index; i < n - 1; i++) {
                        arr[i] = arr[i + 1];
                    }
                    n--;
                    System.out.println("Xoa thanh cong!");
                }
            }


            else if (choice == 5) {
                System.out.print("Nhap chuoi can tim: ");
                String key = sc.nextLine().toLowerCase();

                boolean found = false;
                for (int i = 0; i < n; i++) {
                    if (arr[i].toLowerCase().contains(key)) {
                        System.out.println((i + 1) + ". " + arr[i]);
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("Khong co ket qua!");
                }
            }



        } while (choice != 0);
        System.out.println("Da thoat chương trình");
    }
}
