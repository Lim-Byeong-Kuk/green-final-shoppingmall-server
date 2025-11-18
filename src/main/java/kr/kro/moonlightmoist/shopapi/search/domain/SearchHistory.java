package kr.kro.moonlightmoist.shopapi.search.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Builder
@Setter
@Entity
@Table(name="search_histories")
public class SearchHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="user_id", nullable = false)
//    // todo: User 클래스 만들어야함
//    private User user;
    @Column(nullable = false)
    private String keyword;
    @Column(nullable = false)
    private LocalDateTime searchedAt;

}
