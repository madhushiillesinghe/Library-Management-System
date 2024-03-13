package lk.ijse.library.repository.impl;

import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.Branches;
import lk.ijse.library.repository.BranchRepository;
import lk.ijse.library.repository.DAOFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BranchRepositoryImpl implements BranchRepository {
    private Session session;
    private static BranchRepositoryImpl branchRepositoryImpl;
    public BranchRepositoryImpl() {
    }
    public static BranchRepositoryImpl getInstance() {
        return null == branchRepositoryImpl
                ? branchRepositoryImpl= (BranchRepositoryImpl) DAOFactory.getDADFactory().getDao(DAOFactory.DAOType.BRANCH)
                : branchRepositoryImpl;
    }


    @Override
    public boolean save(Branches entity) {
        session.save(entity);
        return true;
    }

    @Override
    public boolean update(Branches entity) {
        session.update(entity);
        return true;
    }

    @Override
    public Branches getId(int id) {
        Branches branches=session.get(Branches.class,id);
        return branches;

    }

    @Override
    public Branches getName(String name) {
        return null;
    }


    @Override
    public boolean delete(Branches entity) {
        session.delete(entity);
        return true;
    }


    @Override
    public void setSession(Session session) {
    this.session=session;
    }

    @Override
    public List<Branches> getAllBranch() {
        List<Branches> branches= new ArrayList<>();

        Query<Branches> query = session.createQuery("SELECT i FROM lk.ijse.library.entity.Branches i", Branches.class);
        branches= query.getResultList();
        return branches;
    }

    @Override
    public List<Integer> getAllBranchIds() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Branches> criteriaQuery=builder.createQuery(Branches.class);
        Root<Branches> root=criteriaQuery.from(Branches.class);
        criteriaQuery.select(root);

        List<Branches> entities=session.createQuery(criteriaQuery).getResultList();
        List<Integer> branchIds=new ArrayList<>();
        List<Branches>branchesList=new ArrayList<>();
        for(int i=0;i<entities.size();i++){
            branchesList.add(entities.get(i));
        }
        for(int i=0;i<branchesList.size();i++){
            branchIds.add(branchesList.get(i).getId());
        }

        return branchIds;
    }
}
