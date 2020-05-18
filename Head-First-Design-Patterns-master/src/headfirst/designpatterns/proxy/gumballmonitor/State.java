package headfirst.designpatterns.proxy.gumballmonitor;

public interface State extends Serializable {
 
	public void insertQuarter();
	public void ejectQuarter();
	public void turnCrank();
	public void dispense();
}
