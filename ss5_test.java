import java.util.regex.Pattern;

public class ss5_test {
    public static void main(String[] args) {
        String[] studentIDList = new String[100];
        int count = 0;
        studentIDList[count++] = "B1234567";
        studentIDList[count++] = "B2345678";
        String choice = "";
        Pattern IDPattern = Pattern.compile("^B\\d{7}$");

        do {
            System.out.println("--- MENU ---");
            System.out.println("1. Hien thi danh sach ID sinh vien hien co");
            System.out.println("2. Them moi sinh vien");
            System.out.println("3. Cap nhat sinh vien");
            System.out.println("4. Xoa sinh vien");
            System.out.println("5. Tim kiem sinh vien");
            System.out.println("6. Thoat");
            System.out.print("Nhap lua chon cua ban (1-6): ");
            choice = System.console().readLine();

            switch (choice) {
                case "1":
                    System.out.println("Danh sach ID sinh vien:");
                    for (int i = 0; i < count; i++) {
                        System.out.println(studentIDList[i]);
                    }
                    break;
                case "2":
                    System.out.print("Nhap ID sinh vien moi: ");
                    String newID = System.console().readLine();
                    if (count < 100) {
                        if (IDPattern.matcher(newID).matches()) {
                            studentIDList[count++] = newID;
                            System.out.println("Da them sinh vien " + newID + " thanh cong.");
                        } else System.out.println("Sai dinh dang! Them sinh vien moi that bai.");
                    } else System.out.println("Danh sach da day! Khong the them sinh vien moi.");
                    break;
                case "3":
                    System.out.print("Nhap vi tri can sua: ");
                    int pos = Integer.parseInt(System.console().readLine());
                    if (pos >=0 && pos < count) {
                        System.out.print("Nhap ID sinh vien can cap nhat: ");
                        String updateID = System.console().readLine();
                        if(IDPattern.matcher(updateID).matches()) {
                            studentIDList[pos] = updateID;
                            System.out.println("Da cap nhat sinh vien thanh cong!");
                        } else System.out.println("Sai dinh dang! Cap nhat sinh vien that bai.");
                    } else System.out.println("Vi tri khong ton tai. Vui long thu lai.");
                    break;
                case "4":
                    System.out.print("Nhap ID sinh vien can xoa: ");
                    String deleteID = System.console().readLine();
                    boolean found = false;
                    for (int i = 0; i < count; i++) if (studentIDList[i].equals(deleteID)) {
                        for (int j = i; j < count - 1; j++) studentIDList[j] = studentIDList[j + 1];
                        studentIDList[--count] = null;
                        found = true;
                        System.out.println("Da xoa sinh vien " + deleteID + " thanh cong.");
                        break;
                    }
                    if (!found) {
                        System.out.println("Khong tim thay sinh vien " + deleteID + ". Vui long thu lai.");
                    }
                    break;
                case "5":
                    System.out.print("Nhap chuoi ky tu can tim kiem: ");
                    String keyword = System.console().readLine();
                    if (keyword.isEmpty()) System.out.println("Chuoi tim kiem rong");
                    Pattern searchPattern = Pattern.compile(".*" + Pattern.quote(keyword) + ".*");
                    System.out.println("Ket qua tim kiem:");
                    found = false;
                    for (int i = 0; i < count; i++) if (searchPattern.matcher(studentIDList[i]).matches()) {
                        System.out.println(studentIDList[i]);
                        found = true;
                    }
                    if (!found) System.out.println("Khong tim thay ket qua!");
                    break;
                case "6":
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Chuc nang khong hop le! Vui long thu lai.");
                    break;
            }
        } while (!choice.equals("6"));
    }
}