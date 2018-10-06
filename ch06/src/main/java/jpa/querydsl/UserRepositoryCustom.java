package jpa.querydsl;

import java.util.List;

public interface UserRepositoryCustom {
    List findAllLike(String keyword);
}
