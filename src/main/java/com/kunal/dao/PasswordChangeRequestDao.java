package com.kunal.dao;

import com.kunal.Entity.PasswordChangeRequest;

public interface PasswordChangeRequestDao {
    public Boolean save(PasswordChangeRequest passwordChangeRequest);
    public PasswordChangeRequest get(String email,String token);
    public void delete(PasswordChangeRequest passwordChangeRequest);
}
