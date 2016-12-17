package bluemoose;

import java.util.Date;

public class Period {
	public Period(Date start, Date end) {
		this.start = start;
		this.end = end;
	}
	public Period(String start, String end){
		this(new Date(Integer.decode(start)), new Date(Integer.decode(end)));
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	
	public boolean between(Date point){
		return point.before(end) && point.after(start);
	}
	private Date start;
	private Date end;
	
}
