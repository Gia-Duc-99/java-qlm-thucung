import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import static java.lang.System.out;

import java.io.Writer;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @todo Bổ sung mã Java kiểm tra lỗi,
 *       rà soát các tình huống dị thường có thể xảy ra.
 *       Ví dụ: chỉ số nằm ngoài phạm vi độ dài mảng.
 *       Mảng bị rỗng.
 */
class// lớp
MảngThúCưng {
    static Scanner scan = new Scanner(System.in);
    // Dữ liệu
    // static ThúCưng[] mảng; // null
    static ThúCưng[] mảng = new ThúCưng[0];

    static ThúCưng[] ds() {
        return mảng;
    }

    // Hành Động, Thao Tác Dữ Liệu
    static void Gán() {

        // Khởi tạo Thú Cưng
        var tc1 = new ThúCưng();
        tc1.Tên = "Nobita";
        tc1.Tuổi = 1995;
        tc1.CânNặng = 6.5f;
        tc1.NhómMáu = 'A';
        tc1.GiớiTính = true;

        var tc2 = new ThúCưng();
        tc2.Tên = "Xuka";
        tc2.Tuổi = 1996;
        tc2.CânNặng = 9.5f;
        tc2.NhómMáu = 'B';
        tc2.GiớiTính = false;

        var tc3 = new ThúCưng();
        tc3.Tên = "Chaien";
        tc3.Tuổi = 1994;
        tc3.CânNặng = 7.5f;
        tc3.NhómMáu = 'B';
        tc3.GiớiTính = false;

        mảng = new ThúCưng[] {
                tc1, tc2, tc3
        };
    }

    static void Nhập() {
        //var scan = new Scanner(System.in);

        // Nhập độ dài mảng
        int độ_dài;
        out.print("\n Nhập độ dài mảng: ");
        độ_dài = scan.nextInt();
        // scan.close();

        // khởi tạo
        mảng = new ThúCưng[độ_dài]; // 3 phần tử đang null

        // Nhập dữ liệu cho từng phần tử
        for (int i = 0; i < mảng.length; i++) {

            var tc = new ThúCưng();
            out.printf("\n Nhập dữ liệu cho phần tử mảng[%d]: ", i);
            // Nhập tên
            out.print("\n Nhập tên: ");
            tc.Tên = scan.next();
            // scan.close();

            // Nhập năm
            out.print("\n Nhập Tuổi: ");
            tc.Tuổi = scan.nextInt();

            // Nhập CânNặng
            // Nếu nhập 2,5 thì không sao
            // Nhưng nhập 2.5 thì báo lỗi: InputMismatchException
            // Nguyên nhân có thể là do Locale của máy tính đang rối loạn dấu phẩy với dấu chấm
            out.print("\n Nhập cân nặng: ");
            //tc.CânNặng = scan.nextFloat();
            tc.CânNặng = Float.parseFloat(scan.next());

            // Nhập nhóm
            out.print("\n Nhập nhóm máu(A, B, O): ");
            tc.NhómMáu = scan.next().charAt(0);

            // Nhập giới
            //out.print("\n Giới tính (1=Đực/0=Cái): ");
            //tc.GiớiTính = scan.nextInt() == 1 ? true : false; // Java không cho chuyển đổi qua lại giữa bool và
            out.print("\n Giới tính (true=Đực/false=Cái): ");
            tc.GiớiTính = scan.nextBoolean();

            // Đẩy Thú Cưng vào mảng/danh sách sau khi khởi tạo
            mảng[i] = tc;
        }

        // Thông báo đã nhập
        out.println("\n Đã hoàn tất việc nhập mảng !");
    }

    static void Xuất() {

        // in cột
        Cột();

        // in các dòng
        for (int i = 0; i < mảng.length; i++) {
            int stt = i + 1;
            ThúCưng dữ_liệu = mảng[i];

            Dòng(dữ_liệu, stt);
        }

    }

    static void Bảng() {
        out.print("\n Bảng Dữ Liệu Thú Cưng:");

        // in cột
        Cột();

        // in các dòng
        // @todo Nếu dữ liệu dòng NULL thì sao ?
        for (int i = 0; i < mảng.length; i++) {
            int stt = i + 1;
            ThúCưng dữ_liệu = mảng[i];
            Dòng(dữ_liệu, stt);
        }

    }

    static// Hàm hiện
    void Cột() {
        out.print("\n+---------------------------------------------------------+");
        out.print("\n| STT | TÊN | TUỔI | CânNặng | NHÓM MÁU |  GIỚI TÍNH  |");
        out.print("\n+---------------------------------------------------------+");
    }

    static// Hàm hiện
    void Dòng(ThúCưng đt, int stt) {
        // String GiớiTính_Text = (đt.GiớiTính==true) ? "Nam" : "Nữ";
        String GiớiTính = đt.GiớiTính ? "Đực" : "Cái";

        out.printf("\n| %3d | %3s | %4d | %4.2f | %8s |  %9s  |",
                stt, đt.Tên, đt.Tuổi, đt.CânNặng, đt.NhómMáu, GiớiTính);
        out.print("\n+---------------------------------------------------------+");
    }

    static void XếpTăngDầnTheoCânNặng() {
        for (int i = 0; i < mảng.length; i++) {
            for (int j = i + 1; j < mảng.length; j++) {
                var logic = mảng[i].CânNặng > mảng[j].CânNặng;

                if// nếu
                (!logic)// logic sai, không thỏa mãn
                {
                    ThúCưng tạm = mảng[i];
                    mảng[i] = mảng[j];
                    mảng[j] = tạm;
                }
            }
        }

        out.print("\n Đã sắp xếp giảm dần theo CânNặng: ");
        Xuất();
    }

    static void PhânLoạiTheoGiớiTính() {

        // Mảng chứa dữ liệu thống kê
        int[] sl = new int[mảng.length]; // mối phần tử = 0

        for (int i = 0; i < sl.length; i++) {
            sl[i] = 1;
        }

        // Tinh chỉnh dữ liệu thống kê
        for (int i = 0; i < mảng.length; i++) {
            for (int j = i + 1; j < mảng.length; j++) {
                var i_j_cùng_loại = (mảng[i].GiớiTính == mảng[j].GiớiTính);

                if// nếu
                (i_j_cùng_loại && sl[j] != 0) {
                    sl[i]++;
                    sl[j]--;
                }
            }
        }

        // In dữ liệu thống kê, phân loại ra màn hình
        for (int i = 0; i < sl.length; i++) {
            if (sl[i] != 0) {
                // out.printf("Có 3 thú cưng giới tính đực.");
                out.printf("\n Có %d thú cưng giới tính %s.", 
                                        sl[i], mảng[i].GiớiTính ? "Đực" : "Cái");
            }
        }
    }

    public static void MMA() {
        float min;
        float max;
        float sum; // tổng
        float avg; // trung_bình;

        min = mảng[0].Tuổi;
        max = mảng[0].Tuổi;
        sum = 0.0f;
        avg = 0.0f;

        for (ThúCưng tc : mảng) {
            if (min > tc.Tuổi)
                min = tc.Tuổi;
            if (max < tc.Tuổi)
                max = tc.Tuổi;

            sum += tc.CânNặng;
        }
        avg = sum / mảng.length;

        out.printf("\n CânNặng min: %.2f", min);
        out.printf("\n CânNặng max: %.2f", max);
        out.printf("\n CânNặng trung bình: %.2f", avg);
    }

    public static void Thêm() {
        // - Tạo mảng mới có độ dài lớn hơn độ dài mảng cũ (1 đơn vị)
        // - Copy dữ liệu của mảng cũ sang
        // - Khởi tạo phần tử mới,
        // - Lưu phần tử mới vào cuối mảng mới
        // - Gán mảng mới vào mảng cũ

        // 1. Tạo mảng mới có độ dài lớn hơn
        ThúCưng[] mảng_mới = new ThúCưng[mảng.length + 1];

        // 2. Copy dữ liệu của mảng cũ sang:
        for (int i = 0; i < mảng.length; i++) {
            mảng_mới[i] = mảng[i];
        }

        // 3. Khởi tạo phần tử mới
        //var scan = new Scanner(System.in);

        var tc = new ThúCưng();
        out.printf("\n Nhập dữ liệu cho phần tử mới: ");
        // Nhập tên
        out.print("\n Nhập tên: ");
        tc.Tên = scan.next();
        // scan.close();

        // Nhập năm
        out.print("\n Nhập tuổi: ");
        tc.Tuổi = scan.nextInt();

        // Nhập CânNặng
        out.print("\n Nhập CânNặng: ");
        tc.CânNặng = scan.nextFloat();

        // Nhập nhóm
        out.print("\n Nhập nhóm máu(A, B, O): ");
        tc.NhómMáu = scan.next().charAt(0);

        // Nhập giới
        out.print("\n Giới tính (true=Đực/false=Cái): ");
        tc.GiớiTính = scan.nextBoolean(); // Java không cho chuyển đổi qua lại giữa bool và
        // int
        // 4. Đặt Thú Cưng mới vào vị trí cuối của mảng mới
        mảng_mới[mảng.length] = tc;

        mảng = mảng_mới;

        out.print("\n Danh sách Thú Cưng sau khi thêm mới:");
        Xuất();
    }

    public static void Sửa() {
        // hiện lại
        Bảng();

        //var scan = new Scanner(System.in);
        out.print("\n Chọn số thứ tự để sửa:");
        int stt = scan.nextInt();

        int chỉ_số_cũ = stt - 1;

        var tc = new ThúCưng();
        out.printf("\n Cập nhật dữ liệu cho phần tử mảng[%d]: ", chỉ_số_cũ);
        // Nhập tên
        out.print("\n Nhập tên: ");
        tc.Tên = scan.next();
        // scan.close();

        // Nhập năm
        out.print("\n Nhập tuổi: ");
        tc.Tuổi = scan.nextInt();

        // Nhập CânNặng
        out.print("\n Nhập CânNặng: ");
        tc.CânNặng = scan.nextFloat();

        // Nhập nhóm
        out.print("\n Nhập nhóm máu(A, B, O): ");
        tc.NhómMáu = scan.next().charAt(0);

        // Nhập giới
        out.print("\n Giới tính (true=Đực/false=Cái): ");
        tc.GiớiTính = scan.nextBoolean(); // Java không cho chuyển đổi qua lại giữa bool và
        // int

        // Lưu dữ liệu mới của Thú Cưng vào vị trí cũ
        mảng[chỉ_số_cũ] = tc;

        out.print("\n Danh sách Thú Cưng sau khi sửa: ");

        Bảng();

    }

    public static void Xóa() {
        // hiện lại
        Bảng();

        //var scan = new Scanner(System.in);
        out.print("\n Chọn số thứ tự để xóa:");
        int stt = scan.nextInt();

        int chỉ_số_cũ = stt - 1;

        int độ_dài_mới = mảng.length - 1;

        // @todo độ dài mới <= 1 thì sao ?

        ThúCưng[] mảng_mới = new ThúCưng[độ_dài_mới];

        // Copy dữ liệu mảng cũ sang mảng mới, trừ phần tử muốn xóa
        for (int i = 0; i < mảng_mới.length; i++) {

            if (i < chỉ_số_cũ)
                // Copy những phần tử đứng trước chỉ số cũ
                mảng_mới[i] = mảng[i];
            else
                // Copy những phần tử đứng sau chỉ số cũ
                mảng_mới[i] = mảng[i + 1];
        }

        mảng = mảng_mới;

        out.print("\n Danh sách sau khi xóa: ");
        Bảng();
    }

    public static void Tìm() {
        // thân hàm
        //var scan = new Scanner(System.in);
        out.print("\n Nhập tên thú cưng cần tìm: ");
        String tên = scan.next();

        //boolean cóTìmThấy = false;
        int count = 0;
        for (ThúCưng tc : mảng) {
            if //Nếu
            //(tc.Tên.equals(tên)) //Tên giống hệt
            (tc.Tên.contains(tên)) // %Tên% 
            {
                count++;
                //out.printf("\n Đã tìm thấy thú cưng có tên là: %s", tên);
                if (count == 1) {
                    Cột();
                }
                Dòng(tc, count);
                //cóTìmThấy = true;
            }
        }

        if 
        //(!cóTìmThấy) 
        (count < 1)
        {
            out.printf("\n Không tìm thấy thú cưng có tên là: %s", tên);
        }
    }

    /**
     * @abstract Lưu dữ liệu mảng vào tệp, với định dạng JSON
     *           Các dị thường có thể xảy ra:
     *           -UnsupportedEncodingException: Chuỗi kí tự sử dụng lược đồ mã hóa
     *           không hỗ trợ
     *           -FileNotFoundException: Không tìm thấy tệp trên ổ cứng
     *           Khi nhập đường dẫn tệp file từ Terminal/Console thì nên
     *           dùng dấu suộc trái '/' để biểu diễn. Đỡ bị lỗi
     *           FileNotFoundException
     */
    public static void GhiFileJSON() {

        // Chuyển đổi mảng Java Array sang chuỗi Java String JSON
        Gson gson = new Gson();
        String jsonContent = gson.toJson(mảng);
        // out.println(jsonContent);

        // Đối tượng chịu trách nhiệm viết/ghi
        // nội dung JSON tiếng Việt vào tệp/file trên ổ cứng
        Writer writer;
        try {
            // Đường dẫn tĩnh để test nhanh
            String filePath = "C:\\Users\\Public\\mang.json";

            // Đường dẫn động nhập từ bàn phím:
            //var scan = new Scanner(System.in);
            out.print("\n Nhập đường dẫn tệp file cần ghi dữ liệu: ");
            filePath = scan.next();
            // ví dụ: c:/users/public/mang-sinhvien.json

            writer = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(filePath),
                            "UTF-8"));
            writer.write(jsonContent);
            writer.flush();
            writer.close(); // Viết xong phải đóng nó lại nếu không là công cốc !
                            // Đến lúc mở tệp ra lại chẳng thấy có dữ liệu nào được viết vào

        } catch (Exception ex) {
            out.print("\n Lỗi tệp file hoặc mã hóa bộ kí tự UTF8: ");
            ex.printStackTrace();
        }
        // finally {
        // writer.close();
        // }

        System.out.println("\n Đã ghi file JSON");
    }

    /**
     * @abstract Đọc dữ liệu tệp JSON và chuyển đổi nó thành mảng
     *           Các dị thường có thể xảy ra:
     *           -UnsupportedEncodingException: Chuỗi kí tự sử dụng lược đồ mã hóa
     *           không hỗ trợ
     *           -FileNotFoundException: Không tìm thấy tệp trên ổ cứng
     * 
     *           Khi nhập đường dẫn tệp file từ Terminal/Console thì nên
     *           dùng dấu suộc trái '/' để biểu diễn. Đỡ bị lỗi
     *           FileNotFoundException
     */
    public static void ĐọcFileJSON() {
        Gson gson = new Gson();

        try {
            // Đường dẫn tĩnh để test nhanh
            String filePath = "C:\\Users\\Public\\mang-sinhvien.json";

            // Đường dẫn động nhập từ bàn phím:
            //var scan = new Scanner(System.in);
            out.print("\n Nhập đường dẫn tệp file cần đọc dữ liệu: ");
            filePath = scan.next();
            // ví dụ: c:/users/public/mang-sinhvien.json

            JsonReader reader = new JsonReader(new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(filePath),
                            "UTF-8")));

            mảng = gson.fromJson(reader, ThúCưng[].class);

            Xuất();
        } catch (Exception e) {
            out.print("\n Lỗi tệp file hoặc mã hóa bộ kí tự UTF8: ");
            e.printStackTrace();
        }
    }

}
// kết thúc lớp