package com.yjy.maventest.designmodel.观察者模式;

import java.util.ArrayList;
import java.util.List;

//被观察者的具体实现类
public class NagaTimer implements TimeSubject{

	private long mCurrentStamp = 0L;  
	  
    private List<TimerObserver> mObservers = null;  
    
    public NagaTimer(){
    	if (mObservers == null) {  
            mObservers = new ArrayList<TimerObserver>();  
        }  
    }
	@Override
	public void registerObserver(TimerObserver o) {
		if (mObservers != null) {  
            mObservers.add(o);  
        }  
	}

	@Override
	public void removeObserver(TimerObserver o) {
		if (mObservers == null) {  
            return;  
        }
        mObservers.remove(o);  
	}

	@Override
	public void notifyObservers() {
		if (mObservers == null || mObservers.size() == 0) {  
            return;  
        }  
  
        for (int i = 0; i < mObservers.size(); i++) {  
            CountDownTimer countDownTimer = (CountDownTimer)mObservers.get(i);  
            if (countDownTimer.isDone()) {  
                removeObserver(mObservers.get(i));  
            } else {  
                countDownTimer.update(mCurrentStamp);  
            }  
        }  
	}
	
	private void measurementsChanged() {  
        notifyObservers();  
    }  
  
    public void setMeasurements(long currentStamp) {  
        mCurrentStamp = currentStamp;  
        measurementsChanged();  
    }  

	
}
