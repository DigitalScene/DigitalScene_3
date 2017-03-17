package cn.digitalScene.Service;

import cn.digitalScene.Model.Role;
import cn.digitalScene.Model.User;
import cn.digitalScene.Repository.UserRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by 25065 on 2017/2/16.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository adminRepository;

    public void add(User admin){
        adminRepository.save(admin);
    }

    @Transactional
    public void delete(Integer id){
        adminRepository.deleteByPrimaryKey(id);
    }

    public User findByUsername(String username){
        return adminRepository.findByUsername(username);
    }

    public Page<User> findAllByIsDel0(final String username, final String nickname, final Integer status, String orderField, String orderDirection, PageRequest pageRequest) throws Exception{

        //特殊情况查询
        Specification<User> adminSpecification=new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList= Lists.newArrayList();

                Predicate predicate=null;

                //匹配属性和属性对应的值

                if (username!=null&&!username.equals("")){
                    Path<String> stringPath=root.get("username");
                    predicate=criteriaBuilder.like(stringPath,"%"+username+"%");
                    predicateList.add(criteriaBuilder.and(predicate));
                }

                if (nickname!=null&&!nickname.equals("")){
                    Path<String> stringPath=root.get("nickname");
                    predicate=criteriaBuilder.like(stringPath,"%"+nickname+"%");
                    predicateList.add(criteriaBuilder.and(predicate));
                }

                if (status!=null&&!status.equals("")){
                    predicate=criteriaBuilder.equal(root.get("status"),status);
                    predicateList.add(criteriaBuilder.and(predicate));
                }
                criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()]));
                return null;
            }
        };

        Sort sort;
        if (orderDirection!=null&&!orderDirection.equals("")&&orderField!=null&&!orderField.equals("")){
            sort=new Sort(Sort.Direction.fromString(orderDirection),orderField);
        }else {
            sort=new Sort(Sort.Direction.ASC,"id");
        }
        //起始，长度
        Pageable pageable=new PageRequest(pageRequest.getPageNumber(),pageRequest.getPageSize(),sort);

        Page<User> shopKeeperPage=null;
        try {
            shopKeeperPage=adminRepository.findAll(adminSpecification,pageable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shopKeeperPage.getTotalElements()>0?shopKeeperPage:null;
    }

    public User findById(Integer id){
        return adminRepository.findById(id);
    }

    public String checkUsername(String username){
        return adminRepository.checkUsername(username);
    }

    public String findPasswordById(Integer id){
        return adminRepository.findPasswordById(id);
    }

    @Transactional
    public void updatePasswordById(String password,Integer id){
         adminRepository.updatePasswordById(password,id);
    }

    public String findUsernameById(Integer id){
        return adminRepository.findUsernameById(id);
    }

    public List<Role> findRolesById(Integer id){
        return adminRepository.findRolesById(id);
    }

    public void update(User admin){
        adminRepository.saveAndFlush(admin);
    }

    @Transactional
    public void suoDingById(Integer id){
        adminRepository.suoJieDing(id,1);
    }

    @Transactional
    public void jieSuoById(Integer id){
        adminRepository.suoJieDing(id,0);
    }

    public List<User> findUsernameByStatus0AndUser(){
        return adminRepository.findUsernameByStatus0AndUser();
    }

}
