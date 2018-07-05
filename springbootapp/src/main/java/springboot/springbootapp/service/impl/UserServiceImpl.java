package springboot.springbootapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import springboot.springbootapp.dto.filter.MyFilter;
import springboot.springbootapp.entity.User;
import springboot.springbootapp.repository.UserRepository;
import springboot.springbootapp.service.UserService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findUserById(int i) {
        return userRepository.getOne(i);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByEmailAndLogin(String email, String login) {
        return userRepository.findUserByEmailAndLogin(email, login);
    }

    @Override
    public boolean isPresent(String email, String login) {
        return findAllUsers().contains(findUserByEmailAndLogin(email, login));
    }

    @Override
    public List<User> findUsersByFilter(MyFilter filter) {
        return userRepository.findAll(getSpecification(filter));
    }


    public Specification<User> getSpecification(MyFilter filter) {
        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                if (filter.getSearchFirstName().isEmpty()&&filter.getSearchLastName().isEmpty()&&filter.getSearchEmail().isEmpty()&&filter.getSearchLogin().isEmpty()&&filter.getSearchMinSalary().isEmpty()&&filter.getSearchMaxSalary().isEmpty()) {
                    return null;
                }
                if (filter.getSearchMinSalary().isEmpty()&&filter.getSearchMaxSalary().isEmpty()) {
                    return criteriaBuilder.and(criteriaBuilder.like(root.get("firstName"), "%" + filter.getSearchFirstName() + "%"),
                            criteriaBuilder.like(root.get("lastName"), "%" + filter.getSearchLastName() + "%"),
                            criteriaBuilder.like(root.get("email"), "%" + filter.getSearchEmail() + "%"),
                            criteriaBuilder.like(root.get("login"), "%" + filter.getSearchLogin() + "%"),
                            criteriaBuilder.greaterThanOrEqualTo(root.get("salary"), 0));
                }
                else if (filter.getSearchMinSalary().isEmpty()) {
                    return criteriaBuilder.and(criteriaBuilder.like(root.get("firstName"), "%" + filter.getSearchFirstName() + "%"),
                            criteriaBuilder.like(root.get("lastName"), "%" + filter.getSearchLastName() + "%"),
                            criteriaBuilder.like(root.get("email"), "%" + filter.getSearchEmail() + "%"),
                            criteriaBuilder.like(root.get("login"), "%" + filter.getSearchLogin() + "%"),
                            criteriaBuilder.lessThanOrEqualTo(root.get("salary"), Integer.valueOf(filter.getSearchMaxSalary())));
                }
                else if (filter.getSearchMaxSalary().isEmpty()) {
                    return criteriaBuilder.and(criteriaBuilder.like(root.get("firstName"), "%" + filter.getSearchFirstName() + "%"),
                            criteriaBuilder.like(root.get("lastName"), "%" + filter.getSearchLastName() + "%"),
                            criteriaBuilder.like(root.get("email"), "%" + filter.getSearchEmail() + "%"),
                            criteriaBuilder.like(root.get("login"), "%" + filter.getSearchLogin() + "%"),
                            criteriaBuilder.greaterThanOrEqualTo(root.get("salary"), Integer.valueOf(filter.getSearchMinSalary())));
                }
                else {
                    return criteriaBuilder.and(criteriaBuilder.like(root.get("firstName"), "%" + filter.getSearchFirstName() + "%"),
                            criteriaBuilder.like(root.get("lastName"), "%" + filter.getSearchLastName() + "%"),
                            criteriaBuilder.like(root.get("email"), "%" + filter.getSearchEmail() + "%"),
                            criteriaBuilder.like(root.get("login"), "%" + filter.getSearchLogin() + "%"),
                            criteriaBuilder.between(root.get("salary"), Integer.valueOf(filter.getSearchMinSalary()), Integer.valueOf(filter.getSearchMaxSalary())));
                }
            }
        };
    }

    @Override
    public Page<User> findUsersByPage(MyFilter filter, Pageable pageable) {
        return userRepository.findAll(getSpecification(filter), PageRequest.of(pageable.getPageNumber(), filter.getSize()));
    }

    @Override
    public Page<User> findUsersByPage(Pageable pageable) {
        return userRepository.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));
    }
}
