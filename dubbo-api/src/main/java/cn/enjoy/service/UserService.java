package cn.enjoy.service;

public interface UserService {
    public String queryUser(String userId);

    void doKill(String killid);
}
