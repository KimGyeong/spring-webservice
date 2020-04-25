package com.spring_webservice.domain.posts;

import com.spring_webservice.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
@Entity
    - 테이블과 링크될 클래스임을 나타냅니다.
    - 언더스코어 네이밍으로 이름을 매칭합니다.
    - ex. SalesManager.java => sales_manager table
@Id
    - 해당 테이블의 PK 필드를 나타냅니다.
@GeneratedValue
    - PK의 생성 규칙을 나타냅니다.
    - 기본값은 AUTO 로, MySQL 의 auto_increment 와 같이 자동증가하는 정수형 값이 됩니다.
    - 스프링 부트 2.0에서는 옵션을 추가해야 auto_increment 가 됩니다.
@Column
    - 테이블의 컬럼을 나타내면, 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 됩니다.
    - 사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있을 경우 사용합니다.
    - 문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나, 타입을 TEXT 로 변경하고 싶은 경우 등에 사용됩니다.
@NoArgsConstructor : 기본 생성자 자동 추가
    - access = AccessLevel.PROTECTED : 기본 생성자의 접근 권한을 protected 로 제한
    - 생성자로 protected Posts() {} 와 동일한 효과
    - Entity 클래스를 프로젝트 코드상에서 기본 생성자로 생성하는 것은 막되, JPA 에서 Entity 클래스를 생성하는 것은 허용하기 위해 추가
@Getter : 클래스 내 모든 필드의 Getter 메소드를 자동 생성
@Builder : 해당 클래스의 빌더 패턴 클래스를 생성
    - 생성자 상단에 선언 시, 생성자에 포함된 필드만 빌더에 포함.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
