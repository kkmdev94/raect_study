package hellojpa;

import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;


/**
 * 여기의 속성을 공용으로 같이 사용하고 싶을때 사용하는것이 @MappedSuperclass
 * 공용으로 사용하고 싶은 엔티티에서 상속을 받으면 자동으로 사용이 가능해 진다.
 * 테이블에도 자연스럽게 들어감.
 *
 * 해당 속성의 특징은
 *  - 상속관계 매핑 X
 *  - 엔티티 X, 테이블과 매핑 X
 *  - 상속받는 자식 클래스에 매핑 정보만 제공
 *  - 조회, 검색 불가(em.find(BaseEntity) 불가)
 *  - 직접 생성해서 사용할 일이 없으므로 추상 클래스 권장.
 */

@MappedSuperclass
public abstract class BaseEntity {

    private String createdBy;
    private LocalDateTime createdDate;
    private  String lastModifiedBy;
    private LocalDateTime lastModifiedDate;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
