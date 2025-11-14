//package kr.kro.moonlightmoist.shopapi.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                // 1. CSRF (보안 토큰) 기능을 비활성화합니다. (API 서버에서 흔히 사용)
//                .csrf(csrf -> csrf.disable())
//
//                // 2. CORS 설정은 기존에 컨트롤러나 글로벌 설정에서 처리하도록 둡니다.
//
//                // 3. 모든 요청(/api/**, /h2-console 등 모든 경로)에 대해 인증 없이 접근을 허용합니다.
//                .authorizeHttpRequests(auth -> auth
//                        .anyRequest().permitAll() // 👈 모든 요청에 대해 무조건 허용
//                )
//
//                // 4. Spring Security가 자동으로 생성하는 폼 로그인 및 HTTP 기본 인증을 비활성화합니다.
//                .formLogin(form -> form.disable())
//                .httpBasic(httpBasic -> httpBasic.disable());
//
//        return http.build();
//    }
//}