package com.guo.java8;

/**
 * 
 * @author Administrator
 * @date 2017/12/07
 */
public class Competition {
    CompResult compResult;
    User user;

    /**
     * 
     * @return
     */
    public CompResult getCompResult() {
        System.out.println("------getCompResult-------");
        return compResult;
    }

    /**
     * 
     * @param compResult
     */
    public void setCompResult(CompResult compResult) {
        this.compResult = compResult;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
