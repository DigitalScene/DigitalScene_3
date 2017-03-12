package cn.digitalScene.Service;

import cn.digitalScene.Model.Project;
import cn.digitalScene.Repository.ProjectRepository;
import com.google.common.collect.Lists;
import org.apache.commons.collections.list.PredicatedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 25065 on 2017/3/11.
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Transactional
    public void delete(Integer id){
        projectRepository.deleteByPrimaryKey(id);
    }

    public void save(Project project){
        projectRepository.save(project);
    }

    public Page<Project> findAllByIsDel0(final String projectName, final String createTime, String orderField, String orderDirection, PageRequest pageRequest) throws Exception{
        return this.findAllByIsDel0(projectName, createTime, 2,orderField, orderDirection, pageRequest);
    }

    public Page<Project> findAllByIsDel0(final String projectName, final String createTime, final Integer status, String orderField, String orderDirection, PageRequest pageRequest) throws Exception{
        Specification<Project> projectSpecification=new Specification<Project>() {
            @Override
            public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList= Lists.newArrayList();

                Predicate predicate=null;

                //默认查询isDel为0
                predicate=criteriaBuilder.equal(root.get("isDel"),0);
                predicateList.add(predicate);

                if (projectName!=null&&!projectName.equals("")){
                    Path<String> stringPath=root.get("projectName");
                    predicate=criteriaBuilder.like(stringPath,"%"+projectName+"%");
                    predicateList.add(predicate);
                }
                if (createTime!=null&&!createTime.equals("")){
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String date1=createTime+" 00:00:00";
                    String date2=createTime+" 23:59:59";
                    Date date3= null;
                    Date date4= null;
                    try {
                        date3 = sdf.parse(date1);
                        date4 = sdf.parse(date2);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Expression<Date> stringPath=root.get("createTime");
                    predicate=criteriaBuilder.between(stringPath,date3,date4);
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
            sort=new Sort(Sort.Direction.DESC,"createTime");
        }
        //起始，长度
        Pageable pageable=new PageRequest(pageRequest.getPageNumber(),pageRequest.getPageSize(),sort);

        Page<Project> projectPage=null;
        try {
            projectPage=projectRepository.findAll(projectSpecification,pageable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return projectPage.getTotalElements()>0?projectPage:null;
    }

    @Transactional
    public void updateStatusById(Integer id){
        projectRepository.updateStatusById(id);
    }

    public Project findById(Integer id){
        return projectRepository.findById(id);
    }
 }
