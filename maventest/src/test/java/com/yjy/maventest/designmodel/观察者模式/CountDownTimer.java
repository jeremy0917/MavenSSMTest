package com.yjy.maventest.designmodel.观察者模式;

//观察者
public class CountDownTimer implements TimerObserver, TimerDisplayable{

	private String mName;  
    private long mStartStamp;  
    private long mCountdownStamp;  
    private long mCurrentStamp = 0L; 
	
    public CountDownTimer(String name, long countdown) {  
        this.mStartStamp = System.currentTimeMillis();  
        this.mName = name;  
        this.mCountdownStamp = countdown;  
    }

	@Override
	public void display() {
		//当前时间举例设定时间的差值 < 设定提醒的时间
		if (mCurrentStamp - mStartStamp <= mCountdownStamp) {  
            System.out.println(getName() + "还剩" + ((mCountdownStamp - (mCurrentStamp - mStartStamp)) / 1000) + "s");  
        }  
	}

	@Override
	public void update(long stamp) {
		 mCurrentStamp = stamp;  
	     display();
	}
	
	public boolean isDone() {  
        if (mCurrentStamp - mStartStamp >= mCountdownStamp) {  
            return true;  
        }  
  
        return false;  
    }  
  
    public String getName() {  
        return mName;  
    }  
}
