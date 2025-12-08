package kr.kro.moonlightmoist.shopapi.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("         더미 데이터 비밀번호 암호화");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");

        System.out.println("-- User 1-5 --");
        System.out.println("'pw1' → '" + encoder.encode("pw1") + "'");
        System.out.println("'pw2' → '" + encoder.encode("pw2") + "'");
        System.out.println("'pw3' → '" + encoder.encode("pw3") + "'");
        System.out.println("'pw4' → '" + encoder.encode("pw4") + "'");
        System.out.println("'pw5' → '" + encoder.encode("pw5") + "'");

        System.out.println("\n-- 일반 유저 & 관리자 --");
        System.out.println("'a' (user) → '" + encoder.encode("a") + "'");
        System.out.println("'a' (admin) → '" + encoder.encode("a") + "'");

        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("위 값을 복사해서 data.sql에 붙여넣으세요!");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
    }
}