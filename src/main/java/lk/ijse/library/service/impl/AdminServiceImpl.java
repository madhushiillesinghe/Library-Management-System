package lk.ijse.library.service.impl;

import lk.ijse.library.config.PropertiesConfig;
import lk.ijse.library.dto.AdminDto;
import lk.ijse.library.entity.Admin;
import lk.ijse.library.repository.AdminRepository;
import lk.ijse.library.repository.impl.AdminRepositoryImpl;
import lk.ijse.library.service.AdminService;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdminServiceImpl implements AdminService {
    private Session session;
    private final AdminRepository adminRepository;
    private static AdminService adminService;

    public AdminServiceImpl(){
        adminRepository = AdminRepositoryImpl.getInstance();
    }
    public static AdminService getInstance() {
        return null ==adminService
                ? adminService = new AdminServiceImpl()
                : adminService;
    }
    @Override
    public boolean saveAdmin(AdminDto adminDto) {
        session= PropertiesConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try{
            adminRepository.setSession(session);
            boolean isSaved= adminRepository.save(adminDto.toEntity());
            transaction.commit();
            return isSaved;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean checkUserNameAndPassword(String userName, String password) {
        session= PropertiesConfig.getInstance().getSession();
        try{
            adminRepository.setSession(session);

            return adminRepository.checkUserNameAndPassword(userName, password);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public AdminDto getAdminId(String userName) {
        session= PropertiesConfig.getInstance().getSession();
        try{
            adminRepository.setSession(session);
            Admin admin= adminRepository.getAdminId(userName);
            AdminDto adminDto=new AdminDto(
                    admin.getId(),
                    admin.getName(),
                    admin.getEmail(),
                    admin.getMobileNo(),
                    admin.getAddress(),
                    admin.getUserName(),
                    admin.getPassword()
                            );
            return adminDto;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

   /* @Override
    public AdminDto getAdmin(int id) {
        session= PropertiesConfig.getInstance().getSession();
        try{
            adminRepository.setSession(session);
            Admin admin=session.get(Admin.class,id);
            AdminDto adminDto=new AdminDto(admin.getId(),admin.getName(),admin.getEmail(),admin.getMobileNo(),admin.getAddress(),admin.getUserName(),admin.getPassword());
            return adminDto;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }*/


}
