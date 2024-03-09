package lk.ijse.library.service.impl;

import lk.ijse.library.config.PropertiesConfig;
import lk.ijse.library.dto.AdminDto;
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


}
