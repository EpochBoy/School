import java.time.LocalDate;

public class Temperature{

	private double celcius;
	private LocalDate date;

	public Temperature(double celcius, LocalDate date){
		this.celcius = celcius;
		this.date = date;
	}

	public void setCelcius(double celcius){
		this.celcius = celcius;
	}

	public double getCelcius(){
		return celcius;
	}

	public void setDate(LocalDate date){
		this.date = date;
	}

	public LocalDate getDate(){
		return date;
	}



}