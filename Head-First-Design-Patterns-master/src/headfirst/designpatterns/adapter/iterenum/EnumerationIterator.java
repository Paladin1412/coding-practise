package headfirst.designpatterns.adapter.iterenum;

public class EnumerationIterator implements Iterator<Object> {
	Enumeration<?> enumeration;
 
	public EnumerationIterator(Enumeration<?> enumeration) {
		this.enumeration = enumeration;
	}
 
	public boolean hasNext() {
		return enumeration.hasMoreElements();
	}
 
	public Object next() {
		return enumeration.nextElement();
	}
 
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
