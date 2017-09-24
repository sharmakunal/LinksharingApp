package com.kunal.Services;

import com.kunal.Entity.PasswordChangeRequest;
import com.kunal.dao.PasswordChangeRequestDao;
import com.kunal.dao.PasswordChangeRequestDaoImple;
import org.springframework.stereotype.Service;


@Service
public class PasswordChangeRequestServicesImpl implements PasswordChangeRequestServices {
    @Override
    public Boolean save(PasswordChangeRequest passwordChangeRequest) {
        PasswordChangeRequestDao passwordChangeRequestDao=new PasswordChangeRequestDaoImple();
        return passwordChangeRequestDao.save(passwordChangeRequest);
    }

    @Override
    public PasswordChangeRequest get(String email,String token) {
        PasswordChangeRequestDao passwordChangeRequestDao=new PasswordChangeRequestDaoImple();
        return passwordChangeRequestDao.get(email,token);
    }
    @Override
    public void delete(PasswordChangeRequest passwordChangeRequest){

        PasswordChangeRequestDao passwordChangeRequestDao=new PasswordChangeRequestDaoImple();
        passwordChangeRequestDao.delete(passwordChangeRequest);
    }
}
