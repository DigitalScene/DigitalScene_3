package cn.digitalScene.Service;

import cn.digitalScene.Model.Role;
import cn.digitalScene.Model.User;
import cn.digitalScene.Repository.RoleRepository;
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
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public void delete(Integer id){
        roleRepository.deleteByPrimaryKey(id);
    }
}
