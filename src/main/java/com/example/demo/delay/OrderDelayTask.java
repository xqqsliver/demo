package com.qq.xu.test.test1;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class OrderDelayTask implements Delayed {
    private String orderNo;
    private String orderSatus;
    private long executeTime;
    private long createTime;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderSatus() {
        return orderSatus;
    }

    public void setOrderSatus(String orderSatus) {
        this.orderSatus = orderSatus;
    }

   

    public long getExecuteTime() {
		return executeTime;
	}

	public void setExecuteTime(long executeTime) {
		this.executeTime = executeTime;
	}

	public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    @Override
    public int compareTo(Delayed o) {
    	OrderDelayTask task=(OrderDelayTask) o;
    	if(this.createTime<task.createTime) {
    		return 1;
    	}else if(this.createTime==task.createTime) {
    		return 0;
    	}else {
    		return -1;
    	}
    }

    @Override
    public long getDelay(TimeUnit unit) {
    	return unit.convert(this.executeTime-System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        //return createTime.getTime() + 30;
    }

}
