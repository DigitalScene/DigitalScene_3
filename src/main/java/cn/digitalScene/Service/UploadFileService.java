package cn.digitalScene.Service;

import cn.digitalScene.Model.UploadFile;
import cn.digitalScene.Repository.UploadFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 25065 on 2017/3/21.
 */
@Service
public class UploadFileService {

    @Autowired
    private UploadFileRepository subtitleEditFileRepository;

    public void save(UploadFile subtitleEditFile){
        subtitleEditFileRepository.save(subtitleEditFile);
    }

    @Transactional
    public void delete(Integer id){
        subtitleEditFileRepository.delete(id);
    }

    public List<UploadFile> findAllByModuleId(String moduleId){
        return subtitleEditFileRepository.findAllByModuleId(moduleId);
    }
}
