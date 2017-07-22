package com.kunal.Services;

import com.kunal.Entity.PasswordChangeRequest;
import org.springframework.stereotype.Service;

/**
 * Created by kunal on 21-Jul-17.
 */
@Service
public interface PasswordChangeRequestServices {
    public Boolean save(PasswordChangeRequest passwordChangeRequest);
    public PasswordChangeRequest get(String email,String token);
    public void delete(PasswordChangeRequest passwordChangeRequest);
}
