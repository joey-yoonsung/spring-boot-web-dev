package jpa.querydsl;

import com.querydsl.core.annotations.QueryEntity;
import com.querydsl.jpa.JPQLQuery;
import jpa.model.QUserEntity;
import jpa.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;
import java.util.List;

public class UserRepositoryImpl extends QuerydslRepositorySupport implements UserRepositoryCustom{

    public UserRepositoryImpl(){
        super(UserEntity.class);
    }

    @Override
    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }

    @Override
    public List findAllLike(String keyword) {
        QUserEntity qUserEntity = QUserEntity.userEntity;
        JPQLQuery<UserEntity> query = from(qUserEntity);
        List<UserEntity> resultlist = query.where(qUserEntity.userName.like(keyword)).orderBy().fetch();

        return resultlist;
    }
}
