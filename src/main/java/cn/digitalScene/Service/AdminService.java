package cn.digitalScene.Service;

import cn.digitalScene.Model.Admin;
import cn.digitalScene.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 25065 on 2017/2/16.
 */
@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public void add(Admin admin){
        adminRepository.save(admin);
    }

    public void delete(Integer id){
        adminRepository.delete(id);
    }

    public Admin findByUsername(String username){
        return adminRepository.findByUsername(username);
    }
}
