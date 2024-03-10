package lk.ijse.library.service.impl;

import lk.ijse.library.config.PropertiesConfig;
import lk.ijse.library.dto.BranchDto;
import lk.ijse.library.entity.Branches;
import lk.ijse.library.repository.BranchRepository;
import lk.ijse.library.repository.impl.BranchRepositoryImpl;
import lk.ijse.library.service.BranchService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BranchServiceImpl implements BranchService {
    private Session session;
    private final BranchRepository branchRepository;
    private static BranchService branchService;

    public BranchServiceImpl() {
        branchRepository = BranchRepositoryImpl.getInstance();
    }
    public static BranchService getInstance() {
        return null ==branchService
                ? branchService = new BranchServiceImpl()
                : branchService;
    }
    @Override
    public boolean saveBranch(BranchDto branchDto) {

        session = PropertiesConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            branchRepository.setSession(session);
            boolean isSaved = branchRepository.save(branchDto.toEntity());
            transaction.commit();
            return isSaved;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean updateBranch(BranchDto branchDto) {
        session= PropertiesConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try{
            branchRepository.setSession(session);
            boolean isUpdate= branchRepository.update(branchDto.toEntity());
            transaction.commit();
            return isUpdate;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean deleteBranch(BranchDto branchDto) {
        session= PropertiesConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            branchRepository.setSession(session);
           Branches branches=new Branches(branchDto.getId(),branchDto.getLocation(),branchDto.getHead_Name(),branchDto.getBookTotal(),branchDto.getAdmin());

            boolean isDelete= branchRepository.delete(branches);
            transaction.commit();
            return  isDelete;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public List<BranchDto> getAllBranchId() {
        List<Branches> branchIds = new ArrayList<>();
        List<BranchDto> branchDtoList=new ArrayList<>();
        session = PropertiesConfig.getInstance().getSession();
        try {
            branchRepository.setSession(session);
            branchIds=branchRepository.getAllBranch();
            for(Branches branches:branchIds){
                branchDtoList.add(new BranchDto(branches.getId(),branches.getLocation(),branches.getHead_Name(),branches.getBookTotal(),branches.getAdmin()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return branchDtoList;
    }

    @Override
    public List<Integer> getAllBranchIds() {
        session = PropertiesConfig.getInstance().getSession();
        List<Integer> branchIds=new ArrayList<>();

        try {
            branchRepository.setSession(session);
            branchIds=branchRepository.getAllBranchIds();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return branchIds;
    }

    @Override
    public BranchDto getData(int id) {
        session = PropertiesConfig.getInstance().getSession();

        try{
            branchRepository.setSession(session);
            Branches branches= branchRepository.getId(id);
            BranchDto branchdto =new BranchDto(branches.getId(),branches.getLocation(),branches.getHead_Name(),branches.getBookTotal(),branches.getAdmin());
            return branchdto;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public BranchDto getDtodata(int id) {
        session = PropertiesConfig.getInstance().getSession();

        try{
            branchRepository.setSession(session);
            Branches branches= branchRepository.getId(id);
            BranchDto branchdto =new BranchDto(branches.getId(),branches.getLocation(),branches.getHead_Name(),branches.getBookTotal(),branches.getAdmin());
            return branchdto;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }
}
