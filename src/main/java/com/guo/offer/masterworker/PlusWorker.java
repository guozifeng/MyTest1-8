package com.guo.offer.masterworker;

/**
 * @author Administrator
 * @date 2018/03/22
 */
public class PlusWorker extends Worker {

    @Override
    public Object handle(Object input) {

        Integer i = (Integer)input;
        return i * i * i;
    }

}