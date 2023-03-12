package interface02;

public interface RemoteControl {
	//상수 선언
	public static final int MAX_VOLUME = 10;
	public int MIN_VOLUME = 0;
	//public (static final) 생략가능 int MAX_VOLUME = 10;
	

	public void turnOn();
	public void turnOff();
	public void setVloume(int volume);
	
	
}
