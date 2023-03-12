package interface01;

public class RemoteControlExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoteControl rc;
		
		rc= new Television();
		rc= new Audio();
		
		rc.turnOn();
		rc.turnOff();
		rc.setVloume(0);
	}

}
